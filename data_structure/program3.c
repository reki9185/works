#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//marginal+t-r
//處理equal

//選擇一條邊(離所有人最遠的點的最短距離?)
//從最邊緣的點開始，(x)還是選距離最小的link?
//以已選擇的邊為基準，找一條link其receiver離select.t最遠、transmitter離select.r最遠

int visited[1024];
//離所有人最遠的點
int marginal[1024];
//離far[i]的距離
int far[1024][1024];
double distance[1204][1024];

struct edge{
    int*idx_r;
    int*idx_t;
    int*receiver; //link[i] as transmitter
    int*transmitter; //link[i] as receiver
    int cnt_r;
    int cnt_t;
};

struct choose{
    int idx;
    int t; //trasmitter
    int r; //receiver
    double SINR;
};

struct point{
    int x;
    int y;
};

double my_pow(double num,int n){
    double sum=1;
    for(int i=0;i<n;i++){
        sum*=num;
    }
    return sum;
}

void pick(struct edge*link,int nodes,int power,int N,struct choose**select){
    double tmp,now,sum,s;
    int flag;
    int number;
    int count[5];
    int max=0;
    int max_idx=0;
    for(int i=0;i<5;i++){
        count[i]=0;
    }
    //case 1:以已選擇的邊為基準，找一條link其receiver離select.t最遠、(transmitter離select.r最遠)
    visited[marginal[0]]=1;
    visited[link[marginal[0]].receiver[0]]=1;
    select[0][count[0]].idx=link[marginal[0]].idx_r[0];
    select[0][count[0]].t=marginal[0];
    select[0][count[0]].r=link[marginal[0]].receiver[0];
    count[0]++;
    for(int i=0;i<nodes;i++){
        for(int m=0;m<nodes;m++){
            number=far[select[0][count[0]-1].t][m];
            //receiver:number  transmitter:link[number].transmitter[j]
            if(visited[number]==0){
                for(int j=0;j<link[number].cnt_t;j++){
                    if(visited[link[number].transmitter[j]]==0){
                        s=N;
                        tmp=(double)power/my_pow(distance[link[number].transmitter[j]][number],3);
                        for(int k=0;k<count[0];k++){
                            s+=(double)power/my_pow(distance[select[0][k].t][number],3);
                        }
                        flag=0;
                        if(tmp>s){
                            for(int k=0;k<count[0];k++){
                                now=(double)power/my_pow(distance[select[0][k].t][select[0][k].r],3);
                                sum=select[0][k].SINR+(double)power/my_pow(distance[link[number].transmitter[j]][select[0][k].r],3);
                                if(now<=sum){
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0){
                                for(int k=0;k<count[0];k++){
                                    select[0][k].SINR+=(double)power/my_pow(distance[link[number].transmitter[j]][select[0][k].r],3);
                                }
                                select[0][count[0]].idx=link[number].idx_t[j];
                                select[0][count[0]].t=link[number].transmitter[j];
                                select[0][count[0]].r=number;
                                select[0][count[0]].SINR=s;
                                count[0]++;
                                visited[number]=1;
                                visited[link[number].transmitter[j]]=1;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    //case 2:最邊緣的點
    for(int i=0;i<nodes;i++){
        visited[i]=0;
    }
    for(int i=0;i<nodes;i++){
        if(visited[marginal[i]]==0){
            for(int j=0;j<link[marginal[i]].cnt_r;j++){
                if(visited[link[marginal[i]].receiver[j]]==0){
                    //check the SINR of trasmitter
                    s=N;
                    tmp=(double)power/my_pow(distance[marginal[i]][link[marginal[i]].receiver[j]],3);
                    for(int k=0;k<count[1];k++){
                        s+=(double)power/my_pow(distance[select[1][k].t][link[marginal[i]].receiver[j]],3);
                    }
                    //check SINR of other links
                    flag=0;
                    if(tmp>s){
                        for(int k=0;k<count[1];k++){
                            now=(double)power/my_pow(distance[select[1][k].t][select[1][k].r],3);
                            sum=select[1][k].SINR+(double)power/my_pow(distance[marginal[i]][select[1][k].r],3);
                            if(now<=sum){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            for(int k=0;k<count[1];k++){
                                select[1][k].SINR+=(double)power/my_pow(distance[marginal[i]][select[1][k].r],3);
                            }
                            select[1][count[1]].idx=link[marginal[i]].idx_r[j];
                            select[1][count[1]].t=marginal[i];
                            select[1][count[1]].r=link[marginal[i]].receiver[j];
                            select[1][count[1]].SINR=s;
                            count[1]++;
                            visited[marginal[i]]=1;
                            visited[link[marginal[i]].receiver[j]]=1;
                            break;
                        }
                    }
                }
            }
        }
    }
    //case 3:greedy
    for(int i=0;i<nodes;i++){
        visited[i]=0;
    }
    for(int i=0;i<nodes;i++){
        if(visited[i]==0){
            for(int j=0;j<link[i].cnt_r;j++){
                if(visited[link[i].receiver[j]]==0){
                    //check the SINR of trasmitter
                    s=N;
                    tmp=(double)power/my_pow(distance[i][link[i].receiver[j]],3);
                      for(int k=0;k<count[2];k++){
                        s+=(double)power/my_pow(distance[select[2][k].t][link[i].receiver[j]],3);
                    }
                    //check SINR of other links
                    flag=0;
                    if(tmp>s){
                        for(int k=0;k<count[2];k++){
                            now=(double)power/my_pow(distance[select[2][k].t][select[2][k].r],3);
                            sum=select[2][k].SINR+(double)power/my_pow(distance[i][select[2][k].r],3);
                            if(now<=sum){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            for(int k=0;k<count[2];k++){
                                select[2][k].SINR+=(double)power/my_pow(distance[i][select[2][k].r],3);
                            }
                            select[2][count[2]].idx=link[i].idx_r[j];
                            select[2][count[2]].t=i;
                            select[2][count[2]].r=link[i].receiver[j];
                            select[2][count[2]].SINR=s;
                            count[2]++;
                            visited[i]=1;
                            visited[link[i].receiver[j]]=1;
                            break;
                        }
                    }
                }
            }
        }
    }
    //case 4:greedy start from node[1]
    for(int i=0;i<nodes;i++){
        visited[i]=0;
    }
    for(int i=1;i<nodes;i++){
        if(visited[i]==0){
            for(int j=0;j<link[i].cnt_r;j++){
                if(visited[link[i].receiver[j]]==0){
                    //check the SINR of trasmitter
                    s=N;
                    tmp=(double)power/my_pow(distance[i][link[i].receiver[j]],3);
                    for(int k=0;k<count[3];k++){
                        s+=(double)power/my_pow(distance[select[3][k].t][link[i].receiver[j]],3);
                    }
                    //check SINR of other links
                    flag=0;
                    if(tmp>s){
                        for(int k=0;k<count[3];k++){
                            now=(double)power/my_pow(distance[select[3][k].t][select[3][k].r],3);
                            sum=select[3][k].SINR+(double)power/my_pow(distance[i][select[3][k].r],3);
                            //printf("%d %d:%.2f %.2f %.2f\n",i,link[i].receiver[j],now,sum,now/sum);
                            if(now<=sum){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            for(int k=0;k<count[3];k++){
                                select[3][k].SINR+=(double)power/my_pow(distance[i][select[3][k].r],3);
                            }
                            select[3][count[3]].idx=link[i].idx_r[j];
                            select[3][count[3]].t=i;
                            select[3][count[3]].r=link[i].receiver[j];
                            select[3][count[3]].SINR=s;
                            count[3]++;
                            visited[i]=1;
                            visited[link[i].receiver[j]]=1;
                            break;
                        }
                    }
                }
            }
        }
    }
    //case 5:greedy start from back
    for(int i=0;i<nodes;i++){
        visited[i]=0;
    }
    for(int i=nodes-1;i>=0;i--){
        if(visited[i]==0){
            for(int j=0;j<link[i].cnt_r;j++){
                if(visited[link[i].receiver[j]]==0){
                    //check the SINR of trasmitter
                    s=N;
                    tmp=(double)power/my_pow(distance[i][link[i].receiver[j]],3);
                    for(int k=0;k<count[4];k++){
                        s+=(double)power/my_pow(distance[select[4][k].t][link[i].receiver[j]],3);
                    }
                    //check SINR of other links
                    flag=0;
                    if(tmp>s){
                        for(int k=0;k<count[4];k++){
                            now=(double)power/my_pow(distance[select[4][k].t][select[4][k].r],3);
                            sum=select[4][k].SINR+(double)power/my_pow(distance[i][select[4][k].r],3);
                            //printf("%d %d:%.2f %.2f %.2f\n",i,link[i].receiver[j],now,sum,now/sum);
                            if(now<=sum){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            for(int k=0;k<count[4];k++){
                                select[4][k].SINR+=(double)power/my_pow(distance[i][select[4][k].r],3);
                            }
                            select[4][count[4]].idx=link[i].idx_r[j];
                            select[4][count[4]].t=i;
                            select[4][count[4]].r=link[i].receiver[j];
                            select[4][count[4]].SINR=s;
                            count[4]++;
                            visited[i]=1;
                            visited[link[i].receiver[j]]=1;
                            break;
                        }
                    }
                }
            }
        }
    }
    for(int i=0;i<5;i++){
        if(count[i]>max){
            max=count[i];
            max_idx=i;
        }
    }
    printf("%d\n",max);
    for(int i=0;i<count[max_idx];i++){
        printf("%d %d %d\n",select[max_idx][i].idx,select[max_idx][i].t,select[max_idx][i].r);
    }
}

int main(){
    int nodes,links,power,N;
    int tmp,a,b,cnt;
    int flag[1024];
    double dis;
    double sum[1024];
    struct edge link[1024];
    struct point node[1024];
    struct choose*select[5];
    for(int i=0;i<5;i++){
        select[i]=(struct choose*)malloc(sizeof(struct choose)*1024);
    }
    scanf("%d%d%d%d",&nodes,&links,&power,&N);
    //initial
    for(int i=0;i<nodes;i++){
        link[i].idx_r=(int*)malloc(sizeof(int)*nodes);
        link[i].idx_t=(int*)malloc(sizeof(int)*nodes);
        link[i].receiver=(int*)malloc(sizeof(int)*nodes);
        link[i].transmitter=(int*)malloc(sizeof(int)*nodes);
        link[i].cnt_r=0;
        link[i].cnt_t=0;
        visited[i]=0;
        sum[i]=0;
        flag[i]=0;
    }
    for(int i=0;i<nodes;i++){
        scanf("%d",&tmp);
        scanf("%d%d",&node[tmp].x,&node[tmp].y);
    }
    for(int i=0;i<links;i++){
        scanf("%d%d%d",&tmp,&a,&b);
        cnt=link[a].cnt_r;
        link[a].idx_r[cnt]=tmp;
        link[a].receiver[cnt]=b;
        link[a].cnt_r++;
        cnt=link[b].cnt_t;
        link[b].idx_t[cnt]=tmp;
        link[b].transmitter[cnt]=a;
        link[b].cnt_t++;
    }
    //distance
    for(int i=0;i<nodes;i++){
        for(int j=0;j<nodes;j++){
            if(i==j){
                distance[i][j]=0;
            }else{
                dis=sqrt(my_pow((double)node[i].x-node[j].x,2)+my_pow((double)node[i].y-node[j].y,2));
                distance[i][j]=dis;
                sum[i]+=dis;
            }
        }
    }
    //find marginal
    for(int i=0;i<nodes;i++){
        dis=-1;
        for(int j=0;j<nodes;j++){
            if(flag[j]==0){
                if(sum[j]>dis){
                    dis=sum[j];
                    tmp=j;
                }
            }
        }
        marginal[i]=tmp;
        flag[tmp]=1;
    }
    //distance[i][link[i].receiver] from short to long
    for(int i=0;i<nodes;i++){
        for(int j=0;j<link[i].cnt_r-1;j++){
            for(int k=0;k<link[i].cnt_r-1-j;k++){
                if(distance[i][link[i].receiver[k]]>distance[i][link[i].receiver[k+1]]){
                    a=link[i].receiver[k];
                    b=link[i].idx_r[k];
                    link[i].receiver[k]=link[i].receiver[k+1];
                    link[i].idx_r[k]=link[i].idx_r[k+1];
                    link[i].receiver[k+1]=a;
                    link[i].idx_r[k+1]=b;
                }
            }
        }
        for(int j=0;j<link[i].cnt_t-1;j++){
            for(int k=0;k<link[i].cnt_t-1-j;k++){
                if(distance[i][link[i].transmitter[k]]>distance[i][link[i].transmitter[k+1]]){
                    a=link[i].transmitter[k];
                    b=link[i].idx_t[k];
                    link[i].transmitter[k]=link[i].transmitter[k+1];
                    link[i].idx_t[k]=link[i].idx_t[k+1];
                    link[i].transmitter[k+1]=a;
                    link[i].idx_t[k+1]=b;
                }
            }
        }
    }
    //find the farest point of each node
    for(int i=0;i<nodes;i++){
        for(int j=0;j<nodes;j++){
            flag[j]=0;
        }
        for(int j=0;j<nodes;j++){
            dis=-1;
            for(int k=0;k<nodes;k++){
                if(flag[k]==0){
                    if(distance[i][k]>dis){
                        dis=distance[i][k];
                        tmp=k;
                    }
                }
            }
            far[i][j]=tmp;
            flag[tmp]=1;
        }
    }
    pick(link,nodes,power,N,select);
    return 0;
}