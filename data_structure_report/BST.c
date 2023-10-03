#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "BST.h"

struct tnode*bst_insert(struct tnode*tree,char*key){
    struct tnode*p;
    if(tree==NULL){
        p=(struct tnode*)malloc(sizeof(struct tnode));
        p->key=strdup(key);
        p->left=NULL;
        p->right=NULL;
        return p;
    }
    if(strcmp(key,tree->key)<0){
        tree->left=insert(tree->left,key);
    }else if(strcmp(key,tree->key)>0){
        tree->right=insert(tree->right,key);
    }
    return tree;
}

struct tnode*bst_find(struct tnode*tree,char*key){
    if(tree==NULL){
        return NULL;
    }
    if(strcmp(tree->key,key)==0){
        return tree;
    }else if(strcmp(tree->key,key)<0){
        return find(tree->left,key);
    }else{
        return find(tree->right,key);
    }
}
