#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){
    char data[1024];
    long long n;
    long long cnt=0;
    n=1000000;
    for(long long i=0;i<n;i++){
        a[i]=rand();
        cnt=0;
        while(a[i]>0){
            data[cnt]=(a[i]%26)-'0'+'a';
            a[i]=a[i]/2;
        }
        printf("%s\n",a[i]);
    }
    return 0;
}