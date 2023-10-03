#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
#include "array.h"
#include "binary search.h"

//./a.out -d 1e4 -q 1e3 -bst -arr
//     0   1  2   3  4    5    6

char*a[1000010];
int main(int argc,char*argv[]){
    char line[1024];
    int c;
    int maxHash=999983;
    struct lnode*list;
    long long dcnt;
    long long qcnt;
    unsigned long diff;
    struct tnode*tree;
    struct tnode*p;
    struct lnode*list=NULL;
    struct lnode*q;
    struct dnode**hashTab;
    struct dnode*r;
    struct timeval start;
    struct timeval end;
    dcnt=atoll(argv[2]);
    qcnt=atoll(argv[4]);
    for(int i=5;i<argc;i+=2){
        if(strcmp(argv[i],"-bst")==0){
            gettimeofday(&start,NULL);
            for(long long i=0;i<dcnt;i++){
                scanf("%s",line);
                tree=bst_insert(tree,line);
            }
            gettimeofday(&end,NULL);
            d_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
            gettimeofday(&start,NULL);
            for(long long i=0;i<qcnt;i++){
                scanf("%s",line);
                p=bst_find(tree,line);
                //printf("%s\n",p->key);
            }
            gettimeofday(&end,NULL);
            q_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
        }else if(strcmp(argv[i],"-bs")==0){
            gettimeofday(&start,NULL);
            for(long long i=0;i<dcnt;i++){
                scanf("%s",line);
                a[i]=strdup(line);
            }
            qsort(a,cnt,sizeof(a[0]),cmp);
            gettimeofday(&end,NULL);
            d_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
            gettimeofday(&start,NULL);
            for(long long i=0;i<qcnt;i++){
                scanf("%s",line);
                binary(a,line,dcnt);
                //printf("%s\n",binary(a,line,dcnt));
            }
            gettimeofday(&end,NULL);
            q_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
        }else if(strcmp(argv[i],"-arr")==0){
            gettimeofday(&start,NULL);
            for(long long i=0;i<dcnt;i++){
                scanf("%s",line);
                a[i]=strdup(line);
            }
            gettimeofday(&end,NULL);
            d_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
            gettimeofday(&start,NULL);
            for(long long i=0;i<qcnt;i++){
                scanf("%s",line);
                arr_find(a,line,dcnt);
                //printf("%s\n",arr_find(a,line,dcnt));
            }
            gettimeofday(&end,NULL);
            q_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
        }else if(strcmp(argv[i],"-ll")==0){
            gettimeofday(&start,NULL);
            for(long long i=0;i<dcnt;i++){
                scanf("%s",line);
                list=ll_insert(list,line);
            }
            gettimeofday(&end,NULL);
            d_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
            gettimeofday(&start,NULL);
            for(long long i=0;i<qcnt;i++){
                scanf("%s",line);
                q=ll_find(list,line);
                //printf("%s\n",q->key);
            }
            gettimeofday(&end,NULL);
            q_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
        }else if(strcmp(argv[i],"-hash")==0){
            hashTab=(struct dnode**)malloc(sizeof(struct dnode*)*maxHash);
            for(int i=0;i<maxHash;i++){
                hashTab[i]=NULL;
            }
            gettimeofday(&start,NULL);
            for(long long i=0;i<dcnt;i++){
                scanf("%s",line);
                c=hash65(line)%maxHash;
                hashTab[c]=h_insert(hashTab[c]);
            }
            gettimeofday(&end,NULL);
            d_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
            gettimeofday(&start,NULL);
            for(long long i=0;i<qcnt;i++){
                scanf("%s",line);
                r=h_find(list,line);
                //printf("%s\n",r->key);
            }
            gettimeofday(&end,NULL);
            q_diff=1000000*(end.tv_sec - start.tv_sec) + end.tv_usec - start.tv_usec;
        }else{
            printf("format error\n");
            exit(1);
        }
        printf("building time: %d sec\n",d_diff/1000000.0);
        printf("query time: %d sec\n",q_diff/1000000.0);
    }
    return 0;
}