struct lnode{
    char*key;
    struct lnode*next;
};
struct lnode*ll_find(struct lnode*list,char*key);
struct lnode*ll_insert(struct lnode*liest,char*key);