#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
 
void adjust(char*a[],long long idx,long long cnt){
    char*tmp;
    long long max;
    long long left=idx*2+1;
    long long right=idx*2+2;
    //每個root(idex=n)的child在陣列裡都是在idex=2n+1和idex=2n+2的位置。
    if(left<cnt&&strcmp(a[left],a[idx])>0){
        max=left;
    }else{
        max=idx;
    }
    if(right<cnt&&strcmp(a[right],a[max])>0){
        max=right;
    }
    if(max!=idx){
        //swap(&a[max],&a[idx]);
        tmp=a[max];
        a[max]=a[idx];
        a[idx]=tmp;
        adjust(a,max,cnt);
    }
}
 
void buildTree(char*a[],long long cnt){
    for(long long i=cnt/2-1;i>=0;i--){
        adjust(a,i,cnt);
    }
}
 
void heapsort(char*a[],long long cnt){
    char*tmp;
    buildTree(a,cnt);
    for(long long i=cnt-1;i>0;i--){
        //swap(&a[0],&a[i]);
        tmp=a[0];
        a[0]=a[i];
        a[i]=tmp;
        cnt--;
        adjust(a,0,cnt);
    }
}
 
int main(){
    struct timeval start;
    struct timeval end;
    unsigned long diff;
 
    char*a[1000010];
    char line[1024];
    long long cnt=0;
    while(scanf("%s",line)!=EOF){
        a[cnt]=strdup(line);
        cnt++;
    }
    gettimeofday(&start,NULL);
    heapsort(a,cnt);
    gettimeofday(&end,NULL);
    for(long long i=0;i<cnt;i++){
        printf("%s\n",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}

