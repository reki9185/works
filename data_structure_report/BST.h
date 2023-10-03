struct tnode{
    char*key;
    struct tnode*left;
    struct tnode*right;
};
struct tnode*bst_insert(struct tnode*tree,char*key);
struct tnode*bst_find(struct tnode*tree,char*key);