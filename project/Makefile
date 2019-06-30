all: server multiserver client

# define the commands we'll use for compilation and library building
AR = ar
ARFLAGS = rcs
CC = gcc

GOOGLE_TEST_INCLUDE=${HOME}/src/googletest-release-1.8.0/googletest/include/
GTEST_DIR = ${HOME}/src/googletest-release-1.8.0/googletest

# define useful flags to cc/ld/etc.
CPPFLAGS += -isystem $(GTEST_DIR)/include
CXXFLAGS += -g -Wall -Wextra -pthread
CFLAGS = -g -Wall -I. -I.. -Iincludes -pthread
LDFLAGS = -L.

GTEST_HEADERS = $(GTEST_DIR)/include/gtest/*.h \
	$(GTEST_DIR)/include/gtest/internal/*.h

GTEST_SRCS_ = $(GTEST_DIR)/src/*.cc $(GTEST_DIR)/src/*.h $(GTEST_HEADERS)

gtest-all.o : $(GTEST_SRCS_)
	$(CXX) $(CPPFLAGS) -I$(GTEST_DIR) $(CXXFLAGS) \
	-c $(GTEST_DIR)/src/gtest-all.cc

gtest_main.a : gtest-all.o
	$(AR) $(ARFLAGS) $@ $^

server: QueryServer.c
	gcc $(CFLAGS) -g  -o queryserver \
	QueryServer.c -L. libIndexer.a -L. libHtll.a

multiserver: MultiServer.c
	gcc $(CFLAGS) -g -o multiserver MultiServer.c \
	-L. libIndexer.a -L. libHtll.a

runserver:
	./queryserver data_small/ 1500

runmultiserver:
	./multiserver data_small/ 1500

client: QueryClient.c
	gcc $(CFLAGS) -g -o queryclient QueryClient.c \
	-L. libIndexer.a -L. libHtll.a

runclient:
	./queryclient 127.0.0.1 1500

test: test_suite.o $(OBJS) queryclient.o gtest_main.a
	$(CXX) $(CPPFLAGS) $(CXXFLAGS) $^ -o $@ -L. -lHtll

test_suite.o: test_suite.cc
	$(CXX) $(CPPFLAGS) $(CXXFLAGS) -c test_suite.cc

clean: FORCE
	/bin/rm -f *.o *~ main multiserver queryserver queryclient test

FORCE:
