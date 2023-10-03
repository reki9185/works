#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
 
long long partition(char*a[],long long left,long long right){
    long long i=left+1,j=right;
    char*key;
    char*tmp;
    key=strdup(a[left]);
    while(i<j){
        while((strcmp(a[j],key)>0)&&i<j){
            j--;
        }
        while((strcmp(a[i],key)<=0)&&i<j){
            i++;
        }
        if(i<j){
            tmp=a[i];
            a[i]=a[j];
            a[j]=tmp;
        }   
    }
    if(strcmp(a[left],a[i])>0){
        tmp=a[left];
        a[left]=a[i];
        a[i]=tmp;
    }
    return i;
}
 
void quicksort(char*a[],long long left,long long right){
    long long pivot;
    if(left>=right){
        return;
    }
    pivot=partition(a,left,right);
    quicksort(a,left,pivot-1);
    quicksort(a,pivot,right);
}
 
int main(){
    struct timeval start;
    struct timeval end;
    unsigned long diff;

    char*a[5000010];
    int line[1000000];
    long long cnt=0;
    while(scanf("%s",line)!=EOF){
        a[cnt]=strdup(line);
        cnt++;
    }

    gettimeofday(&start,NULL);
    quicksort(a,0,cnt-1);
    gettimeofday(&end,NULL);

    for(long long i=0;i<cnt;i++){
        printf("%s",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}
