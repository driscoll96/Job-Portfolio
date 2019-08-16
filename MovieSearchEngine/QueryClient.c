/*
* Modified by Cole Driscoll, 4/21/2019
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <unistd.h>
#include <arpa/inet.h>

#include "includes/QueryProtocol.h"

char *port_string = "1500";
unsigned short int port;
char *ip = "127.0.0.1";

#define BUFFER_SIZE 1000


void RunQuery(char *query) {
 
  // Find the address

  // Create the socket

  // Connect to the server

  // Do the query-protocol

  // Close the connection
  
  if (strlen(query) > 100) {
    printf("Query terms have a 100 character limit\nTry again\n");
    return;
  } 
  int sock_fd;
  sock_fd = socket(AF_INET, SOCK_STREAM, 0);
  struct addrinfo hints, *result;
  memset(&hints, 0, sizeof(hints));
  hints.ai_family = AF_INET;
  hints.ai_socktype = SOCK_STREAM;
  int s;
  if ((s = getaddrinfo(ip, port_string, &hints, &result)) != 0) {
    fprintf(stderr, "getaddrinfo: %s\n", gai_strerror(s));
    exit(1);
  }
  if(connect(sock_fd, result->ai_addr, result->ai_addrlen) == -1){
    perror("Connection Error");
    exit(2);
  }
  char buffer[BUFFER_SIZE];
  int len = recv(sock_fd, &buffer, sizeof(buffer), 0);
  buffer[len] = '\0';
  int checker = CheckAck(buffer);
  if (checker != 0) {
    printf("Query Terminated\n");
    close(sock_fd);
    return;
  }  
  send(sock_fd, query, sizeof(query), 0);
  len = recv(sock_fd, &buffer, sizeof(buffer), 0);
  buffer[len] = '\0';
  int num_responses = atoi(buffer);
  if (num_responses < 1) {
    printf("No movies with the given word in the title.\n");
    close(sock_fd);
    return;
  }
  SendAck(sock_fd);
  for (int i = 1; i <= num_responses; i++) {
    len = recv(sock_fd, &buffer, sizeof(buffer), 0);
    buffer[len] = '\0';
    printf("Results Page %d:\n %s\n", i, buffer);
    SendAck(sock_fd);
  }
  len = recv(sock_fd, &buffer, sizeof(buffer), 0);
  buffer[len] = '\0';
  checker = CheckGoodbye(buffer);
  if (checker != 0) {
    printf("Query Terminated\n");
    close(sock_fd);
    return;
  }
  close(sock_fd);
}

void RunPrompt() {
  char input[BUFFER_SIZE];

  while (1) {
    printf("Enter a term to search for, or q to quit: ");
    scanf("%s", input);

    printf("input was: %s\n", input);

    if (strlen(input) == 1) {
      if (input[0] == 'q') {
        printf("Thanks for playing! \n");
        return;
      }
    }
    printf("\n\n");
    RunQuery(input);
  }
}

int main(int argc, char **argv) {
  // Check/get arguments

  // Get info from user

  // Run Query
  
  if (argc != 3) {
    printf("Arguments Error: Incorrect number of command line arguments.\nAppropriate Arugment Form: ./queryclient [Ip_address] [port_number]\nProgram terminated.\n");
    return 0;
  }
  ip = argv[1];
  port_string = argv[2];
  RunPrompt();
  return 0;
}
