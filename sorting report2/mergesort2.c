#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

void insertionsort(int a[],long long cnt){
    int tmp;
    for(long long i=1;i<cnt;i++){
        tmp=a[i];
        for(long long j=i-1;j>=0;j--){
            if(tmp<a[j]){
                a[j+1]=a[j];
                a[j]=tmp;
            }
        }
    }
}

void merge(int a[],int left[],long long leftCnt,int right[],long long rightCnt){
    long long i=0,j=0,k=0;
    while(i<leftCnt&&j<rightCnt){
        if(left[i]<=right[j]){
            a[k]=left[i];
            k++;
            i++;
        }else{
            a[k]=right[j];
            k++;
            j++;
        }
    }
    while(i<leftCnt){
        a[k]=left[i];
        k++;
        i++;
    }
    while(j<rightCnt){
        a[k]=right[j];
        k++;
        j++;
    }
}
 
void mergesort(int a[],long long cnt){
    if(cnt<15){
        insertionsort(a,cnt);
        return;
    }
    long long mid=cnt/2;
    int left[mid],right[cnt-mid];
    
    for(long long i=0;i<mid;i++){   //將陣列分成左右兩個子陣列
        left[i]=a[i];
    }
    for(long long i=mid;i<cnt;i++){
        right[i-mid]=a[i];
    }
    mergesort(left,mid);
    mergesort(right,cnt-mid);
    merge(a,left,mid,right,cnt-mid);
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
    mergesort(a,cnt);
    gettimeofday(&end,NULL);
    for(long long i=0;i<cnt;i++){
        printf("%d\n",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}
