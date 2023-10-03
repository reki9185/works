#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>
#include <xmmintrin.h>
#include <pmmintrin.h>

int main(){
	float a[240][240]__attribute__((aligned(16)));
	float b[240][240]__attribute__((aligned(16)));
	float c[240][4]__attribute__((aligned(16)));
	char line[2048];
	float tmp[4];
	float tmp_a[200][50][4];
	float tmp_b[200][50][4];
	float tmp_c[200][4]__attribute__((aligned(16)));
	int cnt;
	__m128*A[200][50],*B[200][50],*C[200],*TMP;
	FILE*fp;
	char*ptr;
	char*qtr;
	char word[10];
	long int read,compute,write;
	struct timespec start,end;
	fp=fopen("data.txt","r");
	for(int i=0;i<200;i++){
		for(int j=0;j<4;j++){
			c[i][j]=0;
		}
	}

	//read data
	clock_gettime(CLOCK_REALTIME,&start);
	for(int i=0;i<200;i++){
		fgets(line,2048,fp);
		ptr=line;
		cnt=0;
		while(*ptr){
			qtr=word;
			while(*ptr&&!isspace(*ptr)){
				*qtr++=*ptr++;
			}
			*qtr='\0';
			a[i][cnt]=atof(word);
			cnt++;
			ptr++;	
		}
	}
	for(int i=0;i<200;i++){
                fgets(line,2048,fp);
                ptr=line;
                cnt=0;
                while(*ptr){
                        qtr=word;
                        while(*ptr&&!isspace(*ptr)){
                                *qtr++=*ptr++;
                        }
                        *qtr='\0';
                        b[i][cnt]=atof(word);
			cnt++;
                        ptr++;
                }
        }
	clock_gettime(CLOCK_REALTIME,&end);
        read=end.tv_nsec-start.tv_nsec;
	
	//turn matirx a,b into vector A,B
	for(int i=0;i<200;i++){
                cnt=0;
                for(int j=0;j<196;j+=4){
                        tmp_a[i][cnt][0]=a[i][j];
                        tmp_a[i][cnt][1]=a[i][j+1];
                        tmp_a[i][cnt][2]=a[i][j+2];
                        tmp_a[i][cnt][3]=a[i][j+3];
                        A[i][cnt]=(__m128*)tmp_a[i][cnt];
			cnt++;
                }
                tmp_a[i][cnt][0]=a[i][196];
                tmp_a[i][cnt][1]=a[i][197];
                tmp_a[i][cnt][2]=0;
                tmp_a[i][cnt][3]=0;
                A[i][cnt]=(__m128*)tmp_a[i][cnt];
                cnt++;
        }
	for(int i=0;i<200;i++){
                cnt=0;
                for(int j=0;j<196;j+=4){
                        tmp_b[i][cnt][0]=b[i][j];
                        tmp_b[i][cnt][1]=b[i][j+1];
                        tmp_b[i][cnt][2]=b[i][j+2];
                        tmp_b[i][cnt][3]=b[i][j+3];
                        B[i][cnt]=(__m128*)tmp_b[i][cnt];
                        cnt++;
                }
                tmp_b[i][cnt][0]=b[i][196];
                tmp_b[i][cnt][1]=b[i][197];
                tmp_b[i][cnt][2]=0;
                tmp_b[i][cnt][3]=0;
                B[i][cnt]=(__m128*)tmp_b[i][cnt];
                cnt++;
        }

	//computation
	clock_gettime(CLOCK_REALTIME,&start);
	for(int i=1;i<200;i++){
		for(int j=0;j<50;j++){
			*B[0][j]=_mm_add_ps(*B[i][j],*B[0][j]);
		}
	}
	TMP=(__m128*)tmp;
	for(int i=0;i<200;i++){
		C[i]=(__m128*)c[i];
		for(int j=0;j<50;j++){
			*TMP=_mm_mul_ps(*A[i][j],*B[0][j]);
			*C[i]=_mm_add_ps(*C[i],*TMP);
		}
	}
	for(int i=0;i<200;i+=2){
		//add each element in c[i] together
		TMP=(__m128*)tmp_c[i];
		*TMP=_mm_hadd_ps(*C[i],*C[i+1]);
		*TMP=_mm_hadd_ps(*TMP,*TMP);
	}
	clock_gettime(CLOCK_REALTIME,&end);
        compute=end.tv_nsec-start.tv_nsec;
	
	//write data
	fclose(fp);
	fp=fopen("output_simd.txt","w");
	clock_gettime(CLOCK_REALTIME,&start);
	for(int i=0;i<200;i+=2){
		fprintf(fp,"%f\n",tmp_c[i][0]);
		fprintf(fp,"%f\n",tmp_c[i][1]);
	}
	clock_gettime(CLOCK_REALTIME,&end);
        write=end.tv_nsec-start.tv_nsec;

	fprintf(fp,"read time:%ld(ns)\n",read);
	fprintf(fp,"compute time:%ld(ns)\n",compute);
	fprintf(fp,"write time:%ld(ns)\n",write);
	return 0;
}
