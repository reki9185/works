#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){
    char data[1024];
    long long a;
    long long n;
    n=1000000;
    for(long long i=0;i<n;i++){
        for(int j=0;j<100;j++){
            a=rand();
            data[j]=a%26+'a';
        }
        printf("%s\n",data);
    }
    return 0;
}
