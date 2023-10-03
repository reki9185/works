#include <stdio.h>
#include <stdlib.h>

int main(){
    int a[1000010];
    long long n;
    n=1000000;
    for(long long i=0;i<n;i++){
        a[i]=rand();
        printf("%d\n",a[i]);
    }
    return 0;
}