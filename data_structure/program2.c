#include <stdio.h>
#include <stdlib.h>

int visited[1024];

struct point{
    int idx;
    long long weight;
    //store the node that this point connect to
    int connect[1024];
    //store the count of such links
    int cnt;
    int parent;
};

struct edge{
    int idx;
    int a;
    int b;
};

void tree(struct point*node,int nodes,int size){
    int tmp;
    int q[1024];
    int t;
    int cnt_q=0;
    int result=0;
    int pop_q=0;
    visited[0]=1;
    q[cnt_q]=node[0].idx;
    cnt_q++;
    while(cnt_q-pop_q>0){
        tmp=q[pop_q];
        for(int i=0;i<node[tmp].cnt;i++){
            t=node[tmp].connect[i];
            if(visited[t]==0){
                node[t].parent=node[tmp].idx;
                q[cnt_q]=node[t].idx;
                cnt_q++;
                visited[t]=1;
            }
        }
        pop_q++;
    }
    for(int i=cnt_q-1;i>0;i--){
        t=q[i];
        tmp=node[t].parent;
        if(node[t].weight%size==0){
            result+=node[t].weight/size;
        }else{
            result+=(node[t].weight/size)+1;
        }
        node[tmp].weight+=node[t].weight;
    }
    printf("%d %d\n",nodes,result);
    for(int i=0;i<nodes;i++){
        printf("%d %d\n",node[i].idx,node[i].parent);
    }
}


int main(){
    int nodes,links,size;
    int tmp;
    int t;
    int a,b,c;
    long long w;
    struct point node[1024];
    struct edge link[1024];
    scanf("%d%d%d",&nodes,&links,&size);
    for(int i=0;i<nodes;i++){
        visited[i]=0;
    }
    //input node and initialize node[i].cnt node[i].cost
    for(int i=0;i<nodes;i++){
        scanf("%d%lld",&a,&w);
        node[i].idx=a;
        node[i].weight=w;
        node[i].cnt=0;
        node[i].parent=0;
    }
    for(int i=0;i<links;i++){
        scanf("%d%d%d",&link[i].idx,&link[i].a,&link[i].b);
    }
    //build graph
    for(int i=0;i<links;i++){
        tmp=link[i].a;
        t=node[tmp].cnt;
        node[tmp].connect[t]=link[i].b;
        node[tmp].cnt++;
        tmp=link[i].b;
        t=node[tmp].cnt;
        node[tmp].connect[t]=link[i].a;
        node[tmp].cnt++;
    }
    //build tree
    tree(node,nodes,size);
    return 0;
}
