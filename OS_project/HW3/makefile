SHELL=/bin/bash

all: spin_lock mutex_lock
spin_lock: spin_lock.c
	gcc -g -pthread spin_lock.c -o spin_lock
mutex_lock: mutex_lock.c
	gcc -g -pthread mutex_lock.c -o mutex_lock
clean:
	rm spin_lock mutex_lock
