/*
* Modified by Cole Driscoll, 4/21/2019
*/

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/wait.h>
#include <signal.h>
#include <errno.h>


#include "QueryProtocol.h"
#include "MovieSet.h"
#include "MovieIndex.h"
#include "DocIdMap.h"
#include "htll/Hashtable.h"
#include "QueryProcessor.h"
#include "FileParser.h"
#include "FileCrawler.h"

#define BUFFER_SIZE 1000

int Cleanup();

DocIdMap docs;
Index docIndex;
// Global socket to be able to close it after CTRL-C
int sock_fd;

#define SEARCH_RESULT_LENGTH 1500

char movieSearchResult[SEARCH_RESULT_LENGTH];

void sigchld_handler(int s) {
  write(0, "Handling zombies...\n", 20);
  // waitpid() might overwrite errno, so we save and restore it:
  int saved_errno = errno;

  while (waitpid(-1, NULL, WNOHANG) > 0);

  errno = saved_errno;
}


void sigint_handler(int sig) {
  write(0, "Ahhh! SIGINT!\n", 14);
  Cleanup();
  exit(0);
}

/**
 *
 */
int HandleConnections(int sock_fd) {
  // Step 5: Accept connection
  // Fork on every connection.
  LOOP: while(1) {
    printf("Waiting for connection...\n");
    int client_fd = accept(sock_fd, NULL, NULL);
    printf("Connection accepted\n");
    int new_process;
    new_process = fork();
    if (new_process < 0) {
      printf("Error: Unable to create new process");
      exit(0);
    }
    if (new_process == 0) {
      if (SendAck(client_fd) == -1) {
        printf("Error: Could not send ack protocol\nConnection Terminated.\n");
        close(client_fd);
	goto LOOP;
      }

      char buffer[BUFFER_SIZE];	
      int len = recv(client_fd, &buffer, sizeof(buffer), 0);
      buffer[len] = '\0';
      printf("The search term: %s\n", buffer);
      MovieSet term_set;
      term_set = GetMovieSet(docIndex, buffer);
      int num_movies;
      if (term_set == NULL) {
        printf("No movies with the given word in the title.\n");
        num_movies = 0;
        sprintf(buffer, "%d", num_movies);
        send(client_fd, buffer, sizeof(buffer), 0);
        close(client_fd);
	goto LOOP;
      } else {
        num_movies = NumMoviesInSet(term_set);
        printf("Number of Movies Found: %d\n", num_movies);
        sprintf(buffer, "%d", num_movies);
        send(client_fd, buffer, sizeof(buffer), 0);
        len = recv(client_fd, &buffer, sizeof(buffer), 0);
        buffer[len] = '\0';
        int checker = CheckAck(buffer);
        if (checker != 0) {
          printf("Protocol broken.\nConnection Terminated.\n");
          close(client_fd);
          goto LOOP;
        }
        SearchResultIter iter;
        iter = CreateSearchResultIter(term_set);
        SearchResult search_result = malloc(sizeof(struct searchResult));
        SearchResultGet(iter, search_result);
        CopyRowFromFile(search_result, docs, buffer);
        send(client_fd, &buffer, sizeof(buffer), 0);
        len = recv(client_fd, &buffer, sizeof(buffer), 0);
        buffer[len] = '\0';
        checker = CheckAck(buffer);
        if (checker != 0) {
          printf("Protocol broken.\nConnection Terminated.\n");
          close(client_fd);
	  free(search_result);
          DestroySearchResultIter(iter);
          goto LOOP;
        }
        while (SearchResultIterHasMore(iter) == 1) {
          SearchResultGet(iter, search_result);
          CopyRowFromFile(search_result, docs, buffer);
          send(client_fd, &buffer, sizeof(buffer), 0);
          len = recv(client_fd, &buffer, sizeof(buffer), 0);
          buffer[len] = '\0';
          checker = CheckAck(buffer);
          if (checker != 0) {
	    printf("Protocol broken.\nConnection Terminated.\n");
            close(client_fd);
	    free(search_result);
            DestroySearchResultIter(iter);
            goto LOOP;
          }
          SearchResultNext(iter);
        }
        free(search_result);
        DestroySearchResultIter(iter);
        if (SendGoodbye(client_fd) != 0) {
          printf("Error: Goodbye unable to send\nConnection Terminated\n");
          close(client_fd);
          goto LOOP;
        }
      }
    } 
    if (new_process > 0) {
      close(client_fd);
    }
  }
}

void Setup(char *dir) {
  struct sigaction sa;

  sa.sa_handler = sigchld_handler;  // reap all dead processes
  sigemptyset(&sa.sa_mask);
  sa.sa_flags = SA_RESTART;
  if (sigaction(SIGCHLD, &sa, NULL) == -1) {
    perror("sigaction");
    exit(1);
  }

  struct sigaction kill;

  kill.sa_handler = sigint_handler;
  kill.sa_flags = 0;  // or SA_RESTART
  sigemptyset(&kill.sa_mask);

  if (sigaction(SIGINT, &kill, NULL) == -1) {
    perror("sigaction");
    exit(1);
  }

  printf("Crawling directory tree starting at: %s\n", dir);
  // Create a DocIdMap
  docs = CreateDocIdMap();
  CrawlFilesToMap(dir, docs);
  printf("Crawled %d files.\n", NumElemsInHashtable(docs));

  // Create the index
  docIndex = CreateIndex();

  // Index the files
  printf("Parsing and indexing files...\n");
  ParseTheFiles(docs, docIndex);
  printf("%d entries in the index.\n", NumElemsInHashtable(docIndex->ht));
}

int Cleanup() {
  DestroyOffsetIndex(docIndex);
  DestroyDocIdMap(docs);
  close(sock_fd);
  return 0;
}

int main(int argc, char **argv) {
  // Get args
  
  if (argc != 3) {
    printf("Arguments Error: Incorrect number of command line arguments.\nAppropriate Arugment Form: ./queryserver [data_directory] [port_number]\nProgram terminated.\n");
    return 0;
  }

  char* dir_to_crawl;
  dir_to_crawl = argv[1];
  char* port_string;
  port_string = argv[2];	
  

  Setup(dir_to_crawl);

  // Step 1: Get address stuff

    // Step 2: Open socket

    // Step 3: Bind socket    
    
    // Step 4: Listen on the socket

    // Step 5: Handle the connections

  int getaddr;
  struct addrinfo hints, *result;
  memset(&hints, 0, sizeof(struct addrinfo));
  hints.ai_family = AF_INET;
  hints.ai_socktype = SOCK_STREAM;
  hints.ai_flags = AI_PASSIVE;
  getaddr = getaddrinfo(NULL, port_string, &hints, &result);
  if (getaddr != 0) {
    fprintf(stderr, "getaddrinfo: %s\n", gai_strerror(getaddr));
    return 0;
  }
  sock_fd = socket(AF_INET, SOCK_STREAM, 0);
  if (bind(sock_fd, result->ai_addr, result->ai_addrlen) != 0) {
    perror("bind()");
    return 0;
  }
  
  freeaddrinfo(result);

  if (listen(sock_fd, 10) != 0) {
    perror("listen()");
    return 0;
  }
  HandleConnections(sock_fd);

  // Got Kill signal
  close(sock_fd);
  Cleanup();
  return 0;
}
