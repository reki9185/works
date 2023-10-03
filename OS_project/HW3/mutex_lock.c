#define _GNU_SOURCE
#include <stdio.h>
#include <pthread.h>
#include <stdatomic.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/syscall.h>
#include <assert.h>
#include <sys/types.h>
#include <time.h>

long long num_thr,critical_section_size,noncritical_section_size,num_iter;

atomic_int start = 0;
atomic_long count;
pthread_mutex_t mutex;
//pthread_mutex_init(&mutex,0);

struct timespec t;

void func(void*id){
    int givenID = (intptr_t)id;
    long long ncs;
    while(start == 0);
    for(int i=0;i<num_iter;i++){
        //printf("%d\n",i);
        t.tv_nsec = critical_section_size;
        pthread_mutex_lock(&mutex);
        //sleep(critical_section_size);
        nanosleep(&t,&t);
        pthread_mutex_unlock(&mutex);
        ncs = random()%noncritical_section_size;
        t.tv_nsec = ncs;
        nanosleep(&t,&t);
    }
}

int main(int argc,char*argv[]){
    num_thr = atoi(argv[1]);
    critical_section_size = atoi(argv[2]);
    noncritical_section_size = atoi(argv[3]);
    num_iter = atoi(argv[4]);

    pthread_t* tid = (pthread_t*)malloc(sizeof(pthread_t)*num_thr);
    for(long i=0;i<num_thr;i++){
        pthread_create(&tid[i],NULL,(void*)func,(void*)i);
        pthread_mutex_init(&mutex,0);
    }
    //atomic_store(&start,0);

    start = 1;

    for(int i=0;i<num_thr;i++){
        pthread_join(tid[i],NULL);
    }
    //wait_for_all_threads();

    return 0;
}
