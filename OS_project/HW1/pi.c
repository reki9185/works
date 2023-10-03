#define _GNU_SOURCE
#include <stdio.h>
#include <pthread.h>
#include <stdatomic.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>
#include <strings.h>
#include <sys/syscall.h> 
#include <assert.h>
#include <string.h>
#include <math.h>

long long int loopCount=100000000;
int numCPU=-1;
int precise=-1;
char* exename;

/*long gettid() {
    return (long int)syscall(__NR_gettid);
}*/

//注意，我使用了「volatile」
//volatile long score[100];
//long score[100];
long double up[100]; 
long double down[100];

double interval;

void thread(void *givenName) {
    int id = (intptr_t)givenName;
    //struct drand48_data r_data;
    //double right=(double)(id+1)/(double)numCPU;
    //double left=(double)id/(double)numCPU;
    //int bar_size=(right-left)/loopCount;
    for(int i=id;i<loopCount;i+=numCPU){
        up[id]+=sqrt(1-pow((double)i/loopCount,2));
    }
}

int main(int argc, char **argv) {
    exename = argv[0];

    numCPU = sysconf( _SC_NPROCESSORS_ONLN );
    //numCPU = 7;
    //pthread_t* tid = (pthread_t*)malloc(sizeof(pthread_t) * numCPU);

    precise=atoi(argv[1]); //double precise
    //if(precise>6) precise=6;

    printf("numCPU:%d\n",numCPU);

    pthread_t*tid=(pthread_t*)malloc(sizeof(pthread_t)*numCPU);

    //do until up and down are same before precise
    long double total_up=0;
    long double total_down=0;
    long double the_up=0;
    long double the_down=0;
    long long int tmp_up;
    long long int tmp_down;
    //interval = 1;
    while(1){
        for (long i=0; i< numCPU; i++)
            pthread_create(&tid[i], NULL, (void *) thread, (void*)i);

        for (int i=0; i< numCPU; i++)
	        pthread_join(tid[i], NULL);

        total_up=0;
        total_down=0;

        for (int i=0;i< numCPU; i++){
            total_up += up[i]; 
            //total_down += down[i];
        }

        the_up=((long double)total_up)/loopCount;
        the_down=the_up-(long double)1/loopCount+(long double)1/loopCount*sqrt(1-pow((long double)1-(long double)1/loopCount,2));

        the_up *= 4;
        the_down *= 4;

        //tmp_up = the_up * pow(10,precise);
        //tmp_down = the_down * pow(10,precise);

        //printf("up = %.10Lf\n",tmp_up);
        //printf("down = %.10Lf\n",tmp_down);

        /*if(tmp_up!=tmp_down){
            loopCount = loopCount*2;
            for(int i=0;i<numCPU;i++){
                up[i] = 0;
            }
        }else{
            break;
        }*/


        if(precise > 0){
            char string_up[20];
            char string_down[20];
            sprintf(string_up,"%.10Lf",the_up);
            sprintf(string_down,"%.10Lf",the_down);

            if(strncmp(string_up,string_down,precise+2)==0){
                //printf("Pi = %.*Lf\n",precise,(tmp_up+tmp_down)/2);
                break;
            }
            loopCount = loopCount*2;
            for(int i=0;i<numCPU;i++){
                up[i]=0;
            }
            string_up[0]='\0';
            string_down[0]='\0';
        }
    }
    printf("Pi = %.*Lf\n",precise,(the_up+the_down)/2);
}

