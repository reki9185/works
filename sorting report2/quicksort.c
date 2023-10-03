#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
void swap(int*a,int*b){
    int c;
    c=*a;
    *a=*b;
    *b=c;
}
 
long long partition(int a[],long long left,long long right){
    long long i=left+1,j=right;
    int key=a[left];
    while(i<j){
        while(a[j]>key&&i<j){
            j--;
        }
        while(a[i]<=key&&i<j){
            i++;
        }
        if(i<j){
            swap(&a[i],&a[j]); //若i=j則不用進行交換
        }   
    }
    if(a[left]>a[i]){
        swap(&a[left],&a[i]);
    }
    return i;
}
 
void quicksort(int a[],long long left,long long right){
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

    int a[5000010];
    int number;
    long long cnt=0;
    while(scanf("%d",&number)!=EOF){
        a[cnt]=number;
        cnt++;
    }

    gettimeofday(&start,NULL);
    quicksort(a,0,cnt-1);
    gettimeofday(&end,NULL);

    for(long long i=0;i<cnt;i++){
        printf("%d\n",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}
