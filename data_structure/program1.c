#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void seperation(char*line,int**encode,int n);
void generate(int n,int m,int**encode);
void swap(double*a,double*b);
void gauss(int n,double**decode);

int main(){
    int mode;
    int n,m;
    int num; //number
    int**encode; //encode matrix
    double**decode; //decode matrix
    char line[10240]; //string

    scanf("%d",&mode);

    if(mode==0){  //mode encode
        scanf("%d%d",&n,&m);
        encode=(int**)malloc(sizeof(int*)*(n+m+1));
        for(int i=0;i<n+m+1;i++){
            encode[i]=(int*)malloc(sizeof(int)*(n+2));
        }
        for(int i=0;i<n+m;i++){
            for(int j=0;j<n+1;j++){
                encode[i][j]=0;
            }
        }

        scanf("%s",line);

        seperation(line,encode,n); //cut into n chunks
        generate(n,m,encode); //generate m chunks

        for(int i=0;i<n+m;i++){
                printf("%d",encode[i][0]);
            for(int j=1;j<n+1;j++){
                printf(" %d",encode[i][j]);
            }
            printf("\n");
        }

    }else if(mode==1){ //mode decode
        scanf("%d",&n);
        decode=(double**)malloc(sizeof(double*)*(n+1));
        for(int i=0;i<n+m+1;i++){
            decode[i]=(double*)malloc(sizeof(double)*(n+2));
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                scanf("%d",&num);
                decode[i][j]=(double)num;
            }
        }

        gauss(n,decode); //Gaussian-Elimination

        for(int i=0;i<n;i++){
            printf("%.0f",decode[i][n]);
        }
        printf("\n");
    }
    return 0;
}

void seperation(char*line,int**encode,int n){
    int len=strlen(line);
    int l=len/n;
    char*ptr=line;
    char tmp[50];
    for(int i=0;i<n;i++){
        strncpy(tmp,ptr,l);
        ptr+=l;
        encode[i][i]=1;
        encode[i][n]=atoi(tmp);
    }
}

void generate(int n,int m,int**encode){
    for(int i=1;i<=m;i++){
        for(int j=0;j<n;j++){
            encode[i+n-1][j]=(int)(pow(i,j));
        }
        for(int j=0;j<n;j++){
            encode[i+n-1][n]+=encode[j][n]*encode[i+n-1][j];
        }
    }
}

void swap(double*a,double*b){
    int tmp;
    tmp=*a;
    *a=*b;
    *b=tmp;
}

void gauss(int n,double**decode){
    double tmp;
    //elementary row operation
    for(int i=0;i<n;i++){
        if(decode[i][i]==0&&i!=n-1){ //interchange
            for(int j=i+1;j<n;j++){
                if(decode[j][i]!=0){
                    for(int k=0;k<n+1;k++){
                        swap(&decode[i][k],&decode[j][k]);
                    }
                }
            }
        }
        tmp=decode[i][i];
        for(int j=0;j<n+1;j++){
            decode[i][j]=decode[i][j]/tmp;
        }
        for(int j=i+1;j<n;j++){
            tmp=decode[j][i]/decode[i][i];
            for(int l=0;l<n+1;l++){
                decode[j][l]-=decode[i][l]*tmp;
            }
        }
    }

    //Gauss-Jordan-Elimination
    for(int i=n-1;i>=0;i--){
        tmp=decode[i][i];
        for(int j=0;j<n+1;j++){
            decode[i][j]=decode[i][j]/tmp;
        }
        for(int j=i-1;j>=0;j--){
            tmp=decode[j][i]/decode[i][i];
            for(int l=0;l<n+1;l++){
                decode[j][l]-=decode[i][l]*tmp;
            }
        }
    }
}

