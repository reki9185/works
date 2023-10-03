#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>

int main(){
	//c[i]+=a[i][j]*b[i][j]
	float a[250][250];
	float b[250][250];
	char line[2048];
	float c[250];
	FILE*fp;
	char*ptr;
	char*qtr;
	char tmp[10];
	int cnt;
	long int read,compute,write;
	struct timespec start,end;
	fp=fopen("data.txt","r");
	for(int i=0;i<200;i++){
		c[i]=0.0;
	}

	//read data 
	clock_gettime(CLOCK_REALTIME,&start);
	//input matrix a
	for(int i=0;i<200;i++){
		fgets(line,2048,fp);
		ptr=line;
		cnt=0;
		while(*ptr){
			qtr=tmp;
			//slipt the line with space
			while(*ptr&&!isspace(*ptr)){
				*qtr++=*ptr++;
			}
			*qtr='\0';
			a[i][cnt]=atof(tmp);
			cnt++;
			ptr++;	
		}
	}
	//input matrix b
	for(int i=0;i<200;i++){
                fgets(line,2048,fp);
                ptr=line;
                cnt=0;
                while(*ptr){
                        qtr=tmp;
                        while(*ptr&&!isspace(*ptr)){
                                *qtr++=*ptr++;
                        }
                        *qtr='\0';
                        b[i][cnt]=atof(tmp);
			cnt++;
                        ptr++;
                }
        }
	clock_gettime(CLOCK_REALTIME,&end);
        read=end.tv_nsec-start.tv_nsec;
	
	//computatuin
	clock_gettime(CLOCK_REALTIME,&start);
	for(int i=0;i<198;i++){
		for(int j=1;j<200;j++){
			b[0][i]+=b[j][i];
		}
	}
	for (int i=0;i<200;i++){
		for(int j=0;j<198;j++){
			c[i]+=a[i][j]*b[0][j];
		}
	}
	clock_gettime(CLOCK_REALTIME,&end);
        compute=end.tv_nsec-start.tv_nsec;
	
	//write data
	fclose(fp);
	fp=fopen("output.txt","w");
	clock_gettime(CLOCK_REALTIME,&start);
	for(int i=0;i<200;i++){
		fprintf(fp,"%f\n",c[i]);
	}
	clock_gettime(CLOCK_REALTIME,&end);
        write=end.tv_nsec-start.tv_nsec;

	fprintf(fp,"read time:%ld(ns)\n",read);
	fprintf(fp,"compute time:%ld(ns)\n",compute);
	fprintf(fp,"write time:%ld(ns)\n",write);
	return 0;
}
