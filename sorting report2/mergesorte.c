#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
void merge(char*a[],long long left,long long right,long long mid){
    long long i=left,j=mid,k=0;
    char*result[right-left+5];
    while(i<mid&&j<right){
        if(strcmp(a[i],a[j])<=0){
            result[k]=strdup(a[i]);
            k++;
            i++;
        }else{
            result[k]=strdup(a[j]);
            k++;
            j++;
        }
    }
    while(i<mid){
        result[k]=strdup(a[i]);
        k++;
        i++;
    }
    while(j<right){
        result[k]=strdup(a[j]);
        k++;
        j++;
    }
    for(long long x=left,y=0;x<right;x++,y++){
        a[x]=result[y];
    }
}
 
void mergesort(char*a[],long long left,long long right,long long cnt){
    if(cnt<2){
        return;
    }
    long long mid=(left+right)/2;
    mergesort(a,left,mid,mid-left);
    mergesort(a,mid,right,right-mid);
    merge(a,left,right,mid);
}
 
char*a[5000010];
int main(){
    struct timeval start;
    struct timeval end;
    unsigned long diff;
 
    char line[1024];
    long long cnt=0;
    while(scanf("%s",line)!=EOF){
        a[cnt]=strdup(line);
        cnt++;
    }
    gettimeofday(&start,NULL);
    mergesort(a,0,cnt,cnt);
    gettimeofday(&end,NULL);
    for(long long i=0;i<cnt;i++){
        printf("%s\n",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}

