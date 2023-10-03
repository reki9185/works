#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "binary search.h"

int cmp(const void*a,const void*b){
    char*c=*(char**)a;
    char*d=*(char**)b;
    return strcmp(c,d);
}

char*binary(char*a[],char*key,long long cnt){
    long long low=0;
    long long high=cnt;
    long long mid;
    while(low<high-1){
        mid=(low+high)/2;
        if(strcmp(key,a[mid])==0){
            return a[mid];
        }else if(strcmp(key,a[mid])>0){
            low=mid+1;
        }else{
            high=mid;
        }
    }
    return NULL;
}