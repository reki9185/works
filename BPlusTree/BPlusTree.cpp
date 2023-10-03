#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

int MAX_SIZE;
string mode;

class Node{
public:
    vector<int>values;
    vector<Node*>children;

    Node*parent = nullptr;
    Node*left_neighbor = nullptr;
    Node*right_neightbor = nullptr;
    
    Node(){}
    void traverse(int depth);
};

class BPlusTree{
public:
    Node*root = nullptr;
    BPlusTree(){};
    void insert(Node*node_ptr,int value,Node*node);
    void delete_node(Node*node_ptr,int value);
    bool redistribution(Node*node_ptr);
    bool redistribution_insert(Node*node_ptr);
    int merge(Node*node_ptr);
    Node*search(Node*node_ptr,int value);
    void traverse();
    void insertValue(int value);
    void deleteValue(int value);
    void find(Node*root,int a,int b);
};

void Node::traverse(int depth){
    if(children.empty()){
        for(int i=0;i<depth;i++) cout << "     ";
        cout << "[" << values[0];
        for(int i=1;i<values.size();i++){
            cout << "," << values[i];
        }
        for(int i=values.size();i<MAX_SIZE;i++){
            cout << ",_";
        }
        cout << "]" << endl;
    }else{
        for(int i=0;i<depth;i++) cout << "     ";
        cout << "(" << values[0];
        for(int i=1;i<values.size();i++){
            cout << ":" << values[i];
        }
        for(int i=values.size();i<MAX_SIZE;i++){
            cout << ":_";
        }
        cout << ")" <<endl;
        for(int i=0;i<children.size();i++){
            children[i]->traverse(depth+1);
        }
    }
}


void BPlusTree::insert(Node*node_ptr,int value,Node*node){
    int new_midKey;
    Node*new_root = new Node();
    Node*right = new Node();

    if(node_ptr == nullptr){
        return;
    }else if(node_ptr->values.size()<MAX_SIZE){
        int i=0;
        while(node_ptr->values[i] <= value && i<node_ptr->values.size()){
            i++;
        }
        node_ptr->values.insert(node_ptr->values.begin()+i,value);
        if(!node_ptr->children.empty()){
            node_ptr->children.insert(node_ptr->children.begin()+i+1,node);
            for(int j=0;j<node_ptr->children.size();j++){
                node_ptr->children[j]->parent = node_ptr;
            }
        }
        return;
    }else{
        if(node_ptr->parent == nullptr){ 
            //no redistribution
            int i=0;
            while(node_ptr->values[i] <= value && i<node_ptr->values.size()){
                i++;
            }
            //leaf node
            if(node_ptr->children.empty()){
                node_ptr->values.insert(node_ptr->values.begin()+i,value);
                for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                    right->values.push_back(node_ptr->values[j]);
                    //cout << node_ptr->values[j] << endl;
                }
                for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                    node_ptr->values.pop_back();
                }
                new_midKey=right->values.front();
                right->right_neightbor = node_ptr->right_neightbor;
                right->left_neighbor = node_ptr;
                node_ptr->right_neightbor = right;
            //branch node
            }else{
                node_ptr->values.insert(node_ptr->values.begin()+i,value);
                node_ptr->children.insert(node_ptr->children.begin()+i+1,node);
                new_midKey=node_ptr->values[MAX_SIZE/2];
                for(int j=MAX_SIZE/2+1;j<=MAX_SIZE;j++){
                    right->values.push_back(node_ptr->values[j]);
                }
                for(int j=MAX_SIZE/2+1;j<=MAX_SIZE+1;j++){
                    right->children.push_back(node_ptr->children[j]);
                }
                for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                    node_ptr->values.pop_back();
                }
                for(int j=MAX_SIZE/2+1;j<=MAX_SIZE+1;j++){
                    node_ptr->children.pop_back();
                }
                for(int j=0;j<right->children.size();j++){
                    right->children[j]->parent = right;
                }
            }
            right->parent = new_root;
            node_ptr->parent = new_root;
            new_root->values.push_back(new_midKey);
            new_root->children.push_back(node_ptr);
            new_root->children.push_back(right);
            root = new_root;
        }else{
            //split
            int i=0;
            while(node_ptr->values[i] <= value && i<node_ptr->values.size()){
                i++;
            }
            //leaf node
            if(node_ptr->children.empty()){
                node_ptr->values.insert(node_ptr->values.begin()+i,value);
                if(mode == "insert-r"){
                    if(!redistribution_insert(node_ptr->parent)){
                        for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                            right->values.push_back(node_ptr->values[j]);
                        }
                        for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                            node_ptr->values.pop_back();
                        }
                        new_midKey=right->values.front();
                        right->right_neightbor = node_ptr->right_neightbor;
                        right->left_neighbor = node_ptr;
                        node_ptr->right_neightbor = right;
                    }else{
                        return;
                    }
                }else{
                    for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                        right->values.push_back(node_ptr->values[j]);
                    }
                    for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                        node_ptr->values.pop_back();
                    }
                    new_midKey=right->values.front();
                    right->right_neightbor = node_ptr->right_neightbor;
                    right->left_neighbor = node_ptr;
                    node_ptr->right_neightbor = right;
                }
            //branch node
            }else{
                node_ptr->values.insert(node_ptr->values.begin()+i,value);
                node_ptr->children.insert(node_ptr->children.begin()+i+1,node);
                if(mode == "insert-r"){
                    if(!redistribution_insert(node_ptr->parent)){
                        new_midKey=node_ptr->values[MAX_SIZE/2];
                        for(int j=MAX_SIZE/2+1;j<=MAX_SIZE;j++){
                            right->values.push_back(node_ptr->values[j]);
                        }
                        for(int j=MAX_SIZE/2+1;j<=MAX_SIZE+1;j++){
                            right->children.push_back(node_ptr->children[j]);
                        }
                        for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                            node_ptr->values.pop_back();
                        }
                        for(int j=MAX_SIZE/2+1;j<=MAX_SIZE+1;j++){
                            node_ptr->children.pop_back();
                        }
                        right->parent = node_ptr->parent;
                        for(int j=0;j<right->children.size();j++){
                            right->children[j]->parent = right;
                        }
                    }else{
                        return;
                    }
                }else{
                    new_midKey=node_ptr->values[MAX_SIZE/2];
                    for(int j=MAX_SIZE/2+1;j<=MAX_SIZE;j++){
                        right->values.push_back(node_ptr->values[j]);
                    }
                    for(int j=MAX_SIZE/2+1;j<=MAX_SIZE+1;j++){
                        right->children.push_back(node_ptr->children[j]);
                    }
                    for(int j=MAX_SIZE/2;j<=MAX_SIZE;j++){
                        node_ptr->values.pop_back();
                    }
                    for(int j=MAX_SIZE/2+1;j<=MAX_SIZE+1;j++){
                        node_ptr->children.pop_back();
                    }
                    right->parent = node_ptr->parent;
                    for(int j=0;j<right->children.size();j++){
                        right->children[j]->parent = right;
                    }
                }
            }
            return insert(node_ptr->parent,new_midKey,right);
        }
    }
    return;
}

bool BPlusTree::redistribution_insert(Node*node_ptr){
    Node*over_flow;
    Node*neighbor;
    int new_midKey;
    int tmp;
    Node*tmp_node;
    //root
    if(node_ptr == nullptr){
        return false;
    }
    int i;
    for(i=0;i<=node_ptr->values.size();i++){
        if(node_ptr->children[i]->values.size()>MAX_SIZE) break;
    }
    over_flow=node_ptr->children[i];
    //right neighbor
    if(i!=node_ptr->values.size()){
        neighbor=node_ptr->children[i+1];
        if(neighbor->values.size()<MAX_SIZE){
            //leaf node
            if(over_flow->children.empty()){
                new_midKey=over_flow->values.back();
                neighbor->values.insert(neighbor->values.begin()+0,new_midKey);
                //cout << tmp << endl;
                over_flow->values.pop_back();
                node_ptr->values.erase(node_ptr->values.begin()+i);
                node_ptr->values.insert(node_ptr->values.begin()+i,new_midKey);
            //branch node
            }else{
                new_midKey=over_flow->values.back();
                tmp_node=over_flow->children.back();
                neighbor->values.insert(neighbor->values.begin()+0,new_midKey);
                neighbor->children.insert(neighbor->children.begin()+0,tmp_node);
                for(int j=0;j<neighbor->children.size();j++){
                    neighbor->children[j]->parent = neighbor;
                }
                over_flow->values.pop_back();
                over_flow->children.pop_back();
                node_ptr->values.erase(node_ptr->values.begin()+i);
                node_ptr->values.insert(node_ptr->values.begin()+i,new_midKey);
            }
            return true;
        }
    }
    if(i!=0){
        neighbor=node_ptr->children[i-1];
        if(neighbor->values.size()<MAX_SIZE){
            if(over_flow->children.empty()){
                tmp=over_flow->values.front();
                neighbor->values.push_back(tmp);
                over_flow->values.erase(over_flow->values.begin()+0);
                new_midKey=over_flow->values.front();
                node_ptr->values.erase(node_ptr->values.begin()+i-1);
                node_ptr->values.insert(node_ptr->values.begin()+i-1,new_midKey);
            //branch node
            }else{
                tmp=over_flow->values.front();
                tmp_node=over_flow->children.front();
                neighbor->values.push_back(tmp);
                neighbor->children.push_back(tmp_node);
                for(int j=0;j<neighbor->children.size();j++){
                    neighbor->children[j]->parent = neighbor;
                }
                over_flow->values.erase(over_flow->values.begin()+0);
                over_flow->children.erase(over_flow->children.begin()+0);
                new_midKey=over_flow->values.front();
                node_ptr->values.erase(node_ptr->values.begin()+i-1);
                node_ptr->values.insert(node_ptr->values.begin()+i-1,new_midKey);
            }
            return true;
        }
    }
    return false;
}


Node* BPlusTree::search(Node*node_ptr,int value){
    //node is a leaf node
    if(node_ptr->children.empty()){
        int i;
        for(i=0;i<node_ptr->values.size();i++){
            if(value == node_ptr->values[i]) break;
        }
        if(i<node_ptr->values.size() && mode == "insert"){
            cout << value << " is already in the B+Tree." << endl;
            return nullptr;
        }else if(i>=node_ptr->values.size() && mode == "delete"){
            cout << value << " is not in the B+Tree." << endl;
            return nullptr;
        }
        else return node_ptr;
    }
    //node is a branch node
    else{
        int i=0;
        while(node_ptr->values[i] <= value && i<node_ptr->values.size()){
            i++;
        }
        node_ptr = node_ptr->children[i];
        return search(node_ptr,value);
    }
}

void BPlusTree::insertValue(int value){
    if(root == nullptr){
        Node*new_root = new Node();
        new_root->values.push_back(value);
        root = new_root;
    }else{
        insert(search(root,value),value,nullptr);
    }
    return;
}

void BPlusTree::traverse(){
    if(root!=nullptr) root->traverse(0);
    else cout << "The tree is empty." << endl;
    return;
}

void BPlusTree::deleteValue(int value){
    if(root == nullptr){
        cout << "The tree is empty." << endl;
    }else{
        delete_node(search(root,value),value);
    }
    return;
}

void BPlusTree::delete_node(Node*node_ptr,int value){
    int key;
    Node*node;
    Node*neighbor;
    if(node_ptr == nullptr){
        return;
    }else{
        //root and not leaf -> new root
        if(node_ptr == root && node_ptr->children.size()==1){
            node_ptr->children[0]->parent = nullptr;
            root = node_ptr->children[0];
            node_ptr->children.pop_back();
            return;
        }
        int i;
        for(i=0;i<node_ptr->values.size();i++){
            if(value == node_ptr->values[i]) break;
        } 
        node_ptr->values.erase(node_ptr->values.begin()+i);
        if(node_ptr == root && node_ptr->values.size()==0){
            root = nullptr;
            return;
        }
        if(node_ptr->values.size()<MAX_SIZE/2 && node_ptr != root){
            //under-full
            if(!redistribution(node_ptr->parent)){
                key=merge(node_ptr->parent);
                if(key != -1){
                    node_ptr=node_ptr->parent;
                    delete_node(node_ptr,key);
                }
            }
        }
    }
    return;
}

bool BPlusTree::redistribution(Node*node_ptr){
    Node*under_flow;
    Node*neighbor;
    int new_midKey;
    int tmp;
    Node*tmp_node;
    //root
    if(node_ptr == nullptr){
        return false;
    }
    int i;
    for(i=0;i<=node_ptr->values.size();i++){
        if(node_ptr->children[i]->values.size()<MAX_SIZE/2) break;
    }
    under_flow=node_ptr->children[i];
    //right neighbor
    if(i!=node_ptr->values.size()){
        neighbor=node_ptr->children[i+1];
        if(neighbor->values.size()-1>=MAX_SIZE/2){
            //leaf node
            if(under_flow->children.empty()){
                tmp=neighbor->values.front();
                under_flow->values.push_back(tmp);
                //cout << tmp << endl;
                neighbor->values.erase(neighbor->values.begin()+0);
                new_midKey=neighbor->values[0];
                node_ptr->values.erase(node_ptr->values.begin()+i);
                node_ptr->values.insert(node_ptr->values.begin()+i,new_midKey);
            //branch node
            }else{
                new_midKey=neighbor->values[0];
                under_flow->values.push_back(neighbor->children[0]->values.front());
                under_flow->children.push_back(neighbor->children.front());
                for(int j=0;j<under_flow->children.size();j++){
                    under_flow->children[j]->parent = under_flow;
                }
                neighbor->values.erase(neighbor->values.begin()+0);
                neighbor->children.erase(neighbor->children.begin()+0);
                node_ptr->values.erase(node_ptr->values.begin()+i);
                node_ptr->values.insert(node_ptr->values.begin()+i,new_midKey);
            }
            return true;
        }
    }
    if(i!=0){
        neighbor=node_ptr->children[i-1];
        if(neighbor->values.size()-1>=MAX_SIZE/2){
            tmp=neighbor->values.back();
            //tmp_node=neighbor->children.back();
            neighbor->values.pop_back();
            //leaf node
            if(under_flow->children.empty()){
                under_flow->values.insert(under_flow->values.begin()+0,tmp);
                new_midKey=tmp;
                node_ptr->values.erase(node_ptr->values.begin()+i-1);
                node_ptr->values.insert(node_ptr->values.begin()+i-1,new_midKey);
                //traverse();
            //branch node
            }else{
                neighbor->children.pop_back();
                tmp_node=neighbor->children.back();
                under_flow->values.insert(under_flow->values.begin()+0,tmp);
                under_flow->children.insert(under_flow->children.begin()+0,tmp_node);
                for(int j=0;j<under_flow->children.size();j++){
                    under_flow->children[j]->parent = under_flow;
                }
                new_midKey=tmp;
                node_ptr->values.erase(node_ptr->values.begin()+i-1);
                node_ptr->values.insert(node_ptr->values.begin()+i-1,new_midKey);
            }
            return true;
        }
    }
    return false;
}

int BPlusTree::merge(Node*node_ptr){
    int new_midKey;
    int tmp;
    Node*tmp_node;
    Node*under_flow;
    Node*neighbor;
    //root
    if(node_ptr == nullptr){
        return -1;
    }
    int i;
    for(i=0;i<node_ptr->children.size();i++){
        if(node_ptr->children[i]->values.size()<MAX_SIZE/2) break;
    }
    under_flow=node_ptr->children[i];
    //right neighbor
    if(i!=node_ptr->values.size()){
        neighbor=node_ptr->children[i+1];
        new_midKey=node_ptr->values[i];
        //leaf node
        if(under_flow->children.empty()){
            for(int j=0;j<neighbor->values.size();j++){
                under_flow->values.push_back(neighbor->values[j]);
            }
            neighbor->values.clear();
            if(neighbor->right_neightbor!=nullptr) neighbor->right_neightbor->left_neighbor=under_flow;
            under_flow->right_neightbor=neighbor->right_neightbor;
            node_ptr->children[i+1]->parent=nullptr;
            node_ptr->children.erase(node_ptr->children.begin()+i+1);
            return new_midKey;
        }else{
            under_flow->values.push_back(new_midKey);
            for(int j=0;j<neighbor->values.size();j++){
                under_flow->values.push_back(neighbor->values[j]);
            }
            for(int j=0;j<neighbor->children.size();j++){
                under_flow->children.push_back(neighbor->children[j]);
            }
            for(int j=0;j<under_flow->children.size();j++){
                under_flow->children[j]->parent=under_flow;
            }
            neighbor->values.clear();
            neighbor->children.clear();
            node_ptr->children.erase(node_ptr->children.begin()+i+1);
            return new_midKey;
        }
    }
    //left neighbor
    if(i!=0){
        neighbor=node_ptr->children[i-1];
        new_midKey=node_ptr->values[i-1];
        //leaf node
        if(under_flow->children.empty()){
            for(int j=0;j<under_flow->values.size();j++){
                neighbor->values.push_back(under_flow->values[j]);
            }
            under_flow->values.clear();
            if(under_flow->right_neightbor!=nullptr) under_flow->right_neightbor->left_neighbor=neighbor;
            neighbor->right_neightbor=under_flow->right_neightbor;
            node_ptr->children.erase(node_ptr->children.begin()+i);
            return new_midKey;
        }else{
            neighbor->values.push_back(new_midKey);
            for(int j=0;j<under_flow->values.size();j++){
                neighbor->values.push_back(under_flow->values[j]);
            }
            for(int j=0;j<under_flow->children.size();j++){
                neighbor->children.push_back(under_flow->children[j]);
            }
            for(int j=0;j<neighbor->children.size();j++){
                neighbor->children[j]->parent=neighbor;
            }
            under_flow->values.clear();
            under_flow->children.clear();
            node_ptr->children.erase(node_ptr->children.begin()+i);
            return new_midKey;
        }
    }
    return -1;
}

void BPlusTree::find(Node*root,int a,int b){
    Node*tmp=search(root,a);
    while(tmp!=nullptr){
        for(int i=0;i<tmp->values.size();i++){
            if(tmp->values[i]<b && tmp->values[i]>a){
                cout << tmp->values[i] << " ";
            }
        }
        tmp=tmp->right_neightbor;
    }
    cout << endl;
}

bool is_number(string value){
    for(int i=0;i<value.length();i++){
        if(value[i]>'9' || value[i]<'0') return false;
    }
    return true;
}

void usage(){
    cout << "----------------------------------------------------------------" << endl;
    cout << "Enter \"help\" for usage." << endl;
    cout << "Enter \"display\" to display the whole tree." << endl;
    cout << "Enter \"insert n\" to insert number n." << endl;
    cout << "Enter \"insert-r n\" to insert number n with redistribution." << endl;
    cout << "Enter \"bulk\" for bulk loading." << endl;
    cout << "Enter \"delete n\" to delete number n." << endl;
    cout << "Enter \"find a b\" to list all numbers between a and b(where a<b)." << endl;
    cout << "Enter \"restart\" to delete current tree and build a new one." << endl;
    cout << "Enter \"quit\" for quit." << endl;
    cout << "----------------------------------------------------------------" << endl;
    return;
}

int main(int argc,char**argv){
    string str_value;
    int value;
    int order;
    string option;
    vector<int>arr;
    int a;
    int b;

    BPlusTree*tree = new BPlusTree();
    tree->root = nullptr;

    while(1){
        cout << "Enter the order of B+Tree : ";
        cin >> str_value;
        if(is_number(str_value)){
            order = stoi(str_value);
            MAX_SIZE = order*2;
            cout << "A B+Tree with order " << order << " , capacity " << MAX_SIZE << " is built." << endl;
            usage();
            break;
        }else{
            cout << str_value << " is not a number, please enter again." << endl;
        }
    }


    while(1){
        cout << "Enter mode : ";
        cin >> mode;

        if(mode == "insert" || mode == "insert-r"){
            //cout << "Insert key : ";
            cin >> str_value;
            if(is_number(str_value)){
                value=stoi(str_value);
            }else{
                cout << str_value << " is not number, please enter again." << endl;
                cout << "Enter \"help\" for usage." << endl;
                continue;
            }
            tree->insertValue(value);
            tree->traverse();
            cout << endl;
        }else if(mode == "delete"){
            //cout << "Delete key : ";
            cin >> str_value;
            if(is_number(str_value)){
                value=stoi(str_value);
            }else{
                cout << str_value << " is not number, please enter again." << endl;
                continue;
            }
            tree->deleteValue(value);
            tree->traverse();
            cout << endl;
        }else if(mode == "bulk"){
            if(tree->root != nullptr){
                cout << "Doing bulk loading now will delete current tree and build a new one, are you sure to continue? (y/n)" << endl;
                cin >> option;
                if(option == "y"){
                    tree->root = nullptr;
                    cout << "A  new B+Tree with order " << order << " , capacity " << MAX_SIZE << " is built." << endl;
                    cout << "Please use number -1 for the end of sequence." << endl;
                    cout << "Please enter a sequence of numbers: ";
                    while(1){
                        cin >> str_value;
                        if(str_value == "-1") break;
                        if(is_number(str_value)){
                            value=stoi(str_value);
                        }else{
                            cout << str_value << " is not number, please enter again." << endl;
                            continue;
                        }
                        arr.push_back(value);
                    }
                    sort(arr.begin(),arr.end());
                    for(int i=0;i<arr.size();i++){
                        tree->insertValue(arr[i]);
                    }
                    tree->traverse();
                    arr.clear();
                }else{
                    continue;
                }
            }else{
                tree->root = nullptr;
                cout << "Please use number -1 for the end of sequence." << endl;
                cout << "Please enter a sequence of numbers: ";
                while(1){
                    cin >> str_value;
                    if(str_value == "-1") break;
                    if(is_number(str_value)){
                        value=stoi(str_value);
                    }else{
                        cout << str_value << " is not number, please enter again." << endl;
                        continue;
                    }
                    arr.push_back(value);
                }
                sort(arr.begin(),arr.end());
                for(int i=0;i<arr.size();i++){
                    tree->insertValue(arr[i]);
                }
                tree->traverse();
                arr.clear();
            }
        }else if(mode == "restart"){
            tree->root = nullptr;
            cout << "Enter the order of B+Tree : ";
            cin >> order;
            MAX_SIZE = order*2;
            cout << "A B+Tree with order " << order << " , capacity " << MAX_SIZE << " is built." << endl;
        }else if(mode == "find"){
            cin >> a;
            cin >> b;
            tree->find(tree->root,a,b);
        }else if(mode == "help"){
            usage();
        }else if(mode == "display"){
            tree->traverse();
            cout << endl;
        }else if(mode == "quit"){
            break;
        }else{
            cout << mode << " not exists, please enter again." << endl;
            cout << "Enter \"help\" for usage." << endl;
        }
    }
    return 0;
}