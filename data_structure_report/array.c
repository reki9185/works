#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "array.h"

char*arr_find(char*a[],char*key,long long cnt){
    for(int i=0;i<cnt;i++){
        if(strcmp(a[i],key)==0){
            return a[i];
        }
    }
    return NULL;
}
