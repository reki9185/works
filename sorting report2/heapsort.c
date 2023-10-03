#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
void swap(int*a,int*b){
    int c;
    c=*a;
    *a=*b;
    *b=c;
}
 
void adjust(int a[],long long idx,long long cnt){
    long long max;
    long long left=idx*2+1;
    long long right=idx*2+2;
    //每個root(idex=n)的child在陣列裡都是在idex=2n+1和idex=2n+2的位置。
    if(left<cnt&&a[left]>a[idx]){
        max=left;
    }else{
        max=idx;
    }
    if(right<cnt&&a[right]>a[max]){
        max=right;
    }
    if(max!=idx){
        swap(&a[max],&a[idx]);
        adjust(a,max,cnt); //調整更動過後的子樹
    }
}
 
void buildTree(int a[],long long cnt){
    for(long long i=cnt/2-1;i>=0;i--){
        adjust(a,i,cnt);
    }
}
 
void heapsort(int a[],long long cnt){
    buildTree(a,cnt);
    for(long long i=cnt-1;i>0;i--){
        swap(&a[0],&a[i]);
        cnt--;
        adjust(a,0,cnt);
    }
}
 
int main(){
    struct timeval start;
    struct timeval end;
    unsigned long diff;

    int a[5000010];
    int number;
    long long cnt=0;
    while(scanf("%d",&number)!=EOF){
        a[cnt]=number;
        cnt++;
    }
    gettimeofday(&start,NULL);
    heapsort(a,cnt);
    gettimeofday(&end,NULL);
    for(long long i=0;i<cnt;i++){
        printf("%d\n",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}
