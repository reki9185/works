#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

//check if n is prime
char isPrime(unsigned int n){
    char flag='0';
    for(unsigned int i=2;i<=sqrt(n);i++){
        if(n%i==0){
            flag='1';
            break;
        }
    }
    if(flag=='0'){
        return '1';
    }
    return '0';
}

long long find(long long m){
    for(long long i=m;i>=2;i--){
        if(isPrime(i)=='1'){
            return i;
        }
    }
    return 0;
}

unsigned int hash1(unsigned int id,unsigned int p,unsigned int m,unsigned int a,unsigned int b,unsigned int c){
    long long t;
    if(id<=m){
        return id;
    }
    if(p<m/10&&p>m/50){
        return id%c%m;
    }
    if(id%p==0){
        return (id/p)%m;
    }
    if(id>m*50){
        t=find(m*50);
        return (unsigned int)id%t%m;
    }
    if(id>m*10){
        t=find(m*10);
        return (unsigned int)id%t%m;
    }
    if(id>m*2){
        t=find(m*2);
        return (unsigned int)id%t%m;
    }
    if(p>m*50){
        return id%a%m;
    }
    return id%b%m;
}

int main(){
    unsigned int n,m,p;
    unsigned int id;
    unsigned int i;
    unsigned int t1;
    unsigned int a,b,c=0;
    unsigned int tmp1,self1;
    unsigned int*hashtab1;
    scanf("%u%u%u",&p,&m,&n);
    //decide how many int we need
    if(m%32==0){
        t1=m/32;
    }else{
        t1=m/32+1;
    }
    //initialize
    hashtab1=(unsigned int*)malloc(sizeof(unsigned int)*t1);
    for(i=0;i<t1;i++){
        hashtab1[i]=0;
    }
    //pick a prime that is closer to m
    for(unsigned i=m;i>=2;i--){
        if(isPrime(i)=='1'){
            a=i;
            break;
        }
    }
    for(unsigned i=m;i>=2;i--){
        if(isPrime(i)=='1'&&i!=a){
            b=i;
            break;
        }
    }
    for(unsigned i=m/2;i<=m;i++){
        if(isPrime(i)=='1'&&i!=a&&i!=b){
            c=i;
            break;
        }
    }
    if(c==0){
        c=a;
    }
    for(i=0;i<n;i++){
        scanf("%u",&id);
        t1=hash1(id,p,m,a,b,c);
        tmp1=t1/32;
        t1=t1%32;
        self1=(1<<t1);
        if((hashtab1[tmp1]|self1)!=hashtab1[tmp1]){
            hashtab1[tmp1]=hashtab1[tmp1]|self1;
            printf("%u 1\n",id);
        }else{
            printf("%u 0\n",id);
        }
    }
    return 0;
}