#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
void radixsort(int a[],long long cnt){
    int tmp[10][cnt]={0};
    long long order[10]={0};
    long long n=1,k=0; 
    int lsd;
    while(n<=1000000){ //最大位數(1000000)
        for(long long i=0;i<cnt;i++){
            lsd=((a[i]/n)%10);
            tmp[lsd][order[lsd]]=a[i];
            order[lsd]++;
        }
        //重新排列
        k=0;
        for(int i=0;i<10;i++){
            if(order[i]!=0){
                for(long long j=0;j<order[i];j++){
                    a[k]=tmp[i][j];
                    k++;
                }
            }
            order[i]=0;
        }
        n=n*10;
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
    radixsort(a,cnt);
    gettimeofday(&end,NULL);
    for(long long i=0;i<cnt;i++){
        printf("%d\n",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}
