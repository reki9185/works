#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#define INF 1000000000

using namespace std;

bool visited[1024];

class weight{
public:
    unsigned int id;
    unsigned int idx;
    int oldW;
    int newW;
};

class road{
public:
    unsigned int key;
    unsigned int id;
};

class point{
public:
    //edge
    vector<weight>neighbor;
    //map<destination ID,next node>
    map<unsigned int,unsigned int>result;
};

//find the next node start from start point
unsigned int find(road*path,unsigned int start,unsigned int end){
    unsigned int tmp=end;
    while(path[tmp].key!=start){
        tmp=path[tmp].key;
    }
    return tmp;
}

void dijkstra(unsigned int start,point node[],int nodes,int state,road*path){
    unsigned int dis[1024];
    unsigned int tmp,t,w,root;
    for(int i=0;i<nodes;i++){
        dis[i]=INF;
        visited[i]=0;
        path[i].key=0;
    }
    dis[start]=0;
    path[start].key=start;
    for(int i=0;i<nodes;i++){
        //priority_queue
        tmp=INF;
        for(int j=0;j<nodes;j++){
            if(visited[j]==0){
                if(dis[j]<tmp){
                    tmp=dis[j];
                    t=j;
                }
            }
        }
        visited[t]=1;
        for(int j=0;j<(int)node[t].neighbor.size();j++){
            tmp=node[t].neighbor[j].idx;
            //case with old weight or new weight
            if(state==0){
                w=node[t].neighbor[j].oldW;
            }else{
                w=node[t].neighbor[j].newW;
            }
            if(visited[tmp]==0){
                if((dis[t]+w)<dis[tmp]){
                    dis[tmp]=dis[t]+w;
                    root=find(path,start,tmp);
                    if(root==start){
                        path[tmp].key=t;
                        path[tmp].id=node[t].neighbor[j].id;
                    }else{
                        path[tmp].key=t;
                        path[tmp].id=path[root].id;
                    }
                }else if((dis[t]+w)==dis[tmp]){
                    if(path[t].id<path[tmp].id){
                        path[tmp].key=t;
                        path[tmp].id=path[t].id;
                    }
                }
            }
        }
    }
}

int main(){
    point node[1024];
    weight tmp;
    unsigned int nodes,dsts,links;
    unsigned int ID,a,b,oldW,newW;
    unsigned int dst[1024];
    road path[1024];
    int flag;
    cin>>nodes>>dsts>>links;
    for(unsigned int i=0;i<dsts;i++){
        cin>>dst[i];
    }
    for(unsigned int i=0;i<links;i++){
        cin>>ID>>a>>b>>oldW>>newW;
        tmp.id=ID;
        tmp.idx=b;
        tmp.oldW=oldW;
        tmp.newW=newW;
        node[a].neighbor.push_back(tmp);
        tmp.idx=a;
        node[b].neighbor.push_back(tmp);
    }

    //dijkstra(unsigned int start,point node[],int nodes,int case,road*path)
    //find path of oldW
    for(unsigned int i=0;i<nodes;i++){
        flag=0;
        dijkstra(i,node,nodes,0,path);
        for(unsigned int j=0;j<dsts;j++){
            if(i==dst[j]){
                continue;
            }
            if(flag==0){
                cout<<i<<endl;
                flag=1;
            }
            node[i].result[dst[j]]=find(path,i,dst[j]);
            cout<<dst[j]<<" "<<node[i].result[dst[j]]<<endl;
        }
    }
    //find path of newW
    for(unsigned int i=0;i<nodes;i++){
        flag=0;
        dijkstra(i,node,nodes,1,path);
        for(unsigned int j=0;j<dsts;j++){
            if(i==dst[j]){
                continue;
            }
            a=find(path,i,dst[j]);
            if(a!=node[i].result[dst[j]]){
                if(flag==0){
                    cout<<i<<endl;
                    flag=1;
                }
                cout<<dst[j]<<" "<<a<<endl;
            }
        }
    }
    return 0;
}
