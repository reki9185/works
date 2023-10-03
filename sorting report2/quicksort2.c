#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#define head 0
#define center 1
#define tail 2

long long cnt=0;

void swap(int*a,int*b){
    int c;
    c=*a;
    *a=*b;
    *b=c;
}
 
long long partition(int a[],long long left,long long right){
    long long mid=(left+right)/2;
    int state;
    long long max;
    long long i,j;
    int key;
    if(a[left]>=a[mid]){
        max=left;
        state=head;
    }else{
        max=mid;
        state=center;
    }
    if(a[right]<a[max]){
        if(max==left){
            if(a[right]>=a[mid]){
                state=tail;
            }else{
                state=center;
            }
        }else{
            if(a[right]>=a[left]){
                state=tail;
            }else{
                state=center;
            }
        }
    }
    if(state==head){
        i=left+1,j=right;
        key=a[left];
        while(i<j){
            while(a[j]>key&&i<j){
                j--;
            }
            while(a[i]<=key&&i<j){
                i++;
            }
            if(i<j){
                swap(&a[i],&a[j]); 
            }   
        }
        if(a[left]>a[i]){
            swap(&a[left],&a[i]);
        }
    }else if(state==tail){
        i=left,j=right-1;
        key=a[right];
        while(i<j){
            while(a[j]>key&&i<j){
                j--;
            }
            while(a[i]<=key&&i<j){
                i++;
            }
            if(i<j){
                swap(&a[i],&a[j]); 
            }   
        }
        if(a[right]<a[i+1]){
            swap(&a[right],&a[i+1]);
        }
        return i+1;
    }else{
        i=left,j=right;
        key=a[mid];
        while(i<j){
            while((a[j]>key||j==mid)&&i<j){
                j--;
            }
            while((a[i]<=key||i==mid)&&i<j){
                i++;
            }
            if(i<j){
                swap(&a[i],&a[j]); 
            }   
        }
        if(a[mid]>a[i]){
            swap(&a[mid],&a[i]);
        }
    }
    return i;
}
 
void quicksort(int a[],long long left,long long right){
    long long pivot;
    if(left>=right){
        return;
    }
    pivot=partition(a,left,right);
    quicksort(a,left,pivot-1);
    quicksort(a,pivot,right);
}
 
int main(){
    struct timeval start;
    struct timeval end;
    unsigned long diff;

    int a[1000010];
    int number;
    //long long cnt=0;
    while(scanf("%d",&number)!=EOF){
        a[cnt]=number;
        cnt++;
    }

    gettimeofday(&start,NULL);
    quicksort(a,0,cnt-1);
    gettimeofday(&end,NULL);

    for(long long i=0;i<cnt;i++){
        printf("%d\n",a[i]);
    }
    diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
    printf("Sorting performance %ld us (equal %f sec)\n",diff,diff/1000000.0);
    return 0;
}
