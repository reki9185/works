#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hash.h"

unsigned int hash65(char*line){
    char*ptr=line;
    unsigned int hv=0;
    while(*ptr){
        hv=hv*65+*ptr;
        ptr++;
    }
    return hv;
}

struct dnode*h_insert(struct dnode*list,char*key){
    struct dnode*p;
    p=(struct dnode*)malloc(sizeof(struct dnode));
    p->key=strdup(key);
    if(list==NULL){
        p->next=NULL;
        return p;
    }
    p->next=list;
    return p;
}

struct dnode*h_find(struct dnode*list,char*key){
    struct dnode*p=list;
    while(p){
        if(strcmp(key,p->key)==0){
            return p;
        }
        p=p->next;
    }
    return NULL;
}