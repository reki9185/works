#include <iostream>
#include <map>
#include <queue>
#include <stack>
#include <string.h>
#include <algorithm>
#include <vector>
#include <fstream>
#include <iomanip>

using namespace std;

class instruction{
public:
    int label;
    long long address;
};

class sub_type{
public:
    int dirty;
    int num;
    int order;
};

class type{
public:
    bool valid;
    int ptr;
    //store tag
    sub_type*content;
};

long long HextoDec(string address){
    long long number = 0;
    int len = address.length();
    long long tmp;
    long long sum_tmp = 1;
    for(int i=len-1;i>=0;i--){
        if(address[i]<='9' && address[i]>='0'){
            tmp = address[i] - '0';
        }else if(address[i] == 'a' or address[i] == 'A'){
            tmp = 10;
        }else if(address[i] == 'b' or address[i] == 'B'){
            tmp = 11;
        }else if(address[i] == 'c' or address[i] == 'C'){
            tmp = 12;
        }else if(address[i] == 'd' or address[i] == 'D'){
            tmp = 13;
        }else if(address[i] == 'e' or address[i] == 'F'){
            tmp = 14;
        }else{
            tmp = 15;
        }
        number += sum_tmp * tmp;
        sum_tmp *= 16;
    }
    return number;
}

int main(int argc,char*argv[]){
    
    long long cache_size;
    long long block_size;
    long long associativity;
    long long cnt = 0;
    int len;
    int label;
    long long read = 0;
    long long write = 0;
    long long hit = 0;
    long long miss = 0;
    long long counter = 0;

    long long block_address;
    long long index;
    long long tag;
    long long num;
    long long max;

    int flag;
    long long tmp;

    string address;
    string replace;
    string filename;
    string line;
    instruction instructions;
    ifstream file;

    //input
    cache_size = atoi(argv[1])*1024;
    block_size = atoi(argv[2]);
    if (argv[3] == "f"){
        associativity = 0;
    }else{
        associativity = atoi(argv[3]);
    }
    replace = argv[4];
    filename = argv[5];

    if(associativity == 0){
        num = 1;
        associativity = cache_size/block_size;
    }else{
        num = cache_size/block_size/associativity;
    }

    type*cache = new type[num];
    for(long long i=0;i<num;i++){
        cache[i].content = new sub_type[associativity];
    }

    for(long long i=0;i<num;i++){
        cache[i].valid = 0;
        cache[i].ptr = 0;
        for(int j=0;j<associativity;j++){
            cache[i].content[j].dirty = 0;
            cache[i].content[j].num = -1;
            cache[i].content[j].order = -1;
        }
    }

    //read file
    file.open(filename);

    while((file>>label>>address)){
        if(label==0) read++;
        if(label==1) write++;
        instructions.label = label;
        
        //Hex->Dec
        instructions.address = HextoDec(address);

        //check cache
        block_address = instructions.address/block_size;
        index = block_address%num;
        tag = block_address/num;

        if(cache[index].valid == 0){
            cache[index].content[0].num = tag;
            cache[index].content[0].order = 0;
            if(label==1){
                cache[index].content[0].dirty = 1;
            }
            cache[index].valid = 1;
            cache[index].ptr++;
            miss++;
        }else{
            flag = 0;
            //cout << cache[index].ptr << endl;
            for(int i=0;i<cache[index].ptr;i++){
                //hit
                if(cache[index].content[i].num == tag){
                    hit++;
                    if(replace == "LRU"){
                        for(int j=0;j<cache[index].ptr;j++){
                            if(cache[index].content[j].order < cache[index].content[i].order){
                                cache[index].content[j].order++;
                            }
                        }
                        cache[index].content[i].order = 0;
                    }
                    if(label==1){
                        cache[index].content[i].dirty = 1;
                    }
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                miss++;
                if(cache[index].ptr == associativity){
                    //cout << cache[index].ptr << endl;
                    max = 0;
                    for(int i=0;i<cache[index].ptr;i++){
                        if(cache[index].content[i].order > max){
                            max = cache[index].content[i].order;
                            tmp = i;
                        }
                    }
                    //cout << max << endl;
                    cache[index].content[tmp].num = tag;
                    if(cache[index].content[tmp].dirty == 1){
                        counter++;
                    }
                    if(label==1){
                        cache[index].content[tmp].dirty = 1;
                    }else{
                        cache[index].content[tmp].dirty = 0;
                    }
                    for(int j=0;j<cache[index].ptr;j++){
                        if(cache[index].content[j].order < cache[index].content[tmp].order){
                            cache[index].content[j].order++;
                        }
                    }
                    cache[index].content[tmp].order = 0;
                }else{
                    if(label==1){
                        cache[index].content[cache[index].ptr].dirty = 1;
                    }else{
                        cache[index].content[cache[index].ptr].dirty = 0;
                    }
                    cache[index].content[cache[index].ptr].num = tag;
                    for(int j=0;j<cache[index].ptr;j++){
                        cache[index].content[j].order++;
                    }
                    cache[index].content[cache[index].ptr].order = 0;
                    cache[index].ptr++;
                }
            }
        }
        cnt++;
        //cout << instructions.address << " " << num << " "  << index << " " << tag << endl;
    }

    for(int i=0;i<num;i++){
        for(int j=0;j<cache[i].ptr;j++){
            if(cache[i].content[j].dirty == 1){
                counter++;
            }
        }
    }

    //output
    cout << "Input file = " << filename << endl;
    cout << "Demand fetch = " << cnt << endl;
    cout << "Cache hit = " << hit << endl;
    cout << "Cache miss = " << miss << endl;
    cout << "Miss rate = " << setprecision(4) << (double)miss/(hit+miss) << endl;
    cout << "Read data = " << read << endl;
    cout << "Write data = " << write << endl;
    cout << "Bytes from memory = " << miss*block_size << endl;
    cout << "Bytes to memory = " << counter*block_size << endl;

    file.close();
    
    return 0;
}