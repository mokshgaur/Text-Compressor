public class treenode
{
    treenode left;
    treenode right;
    treenode next;
    int id = -1;
    int sum;
    char ch;
    int posn;
    treenode(char ch, int sum, int posn)
    {
        this.sum = sum;
        this.ch = ch;
        this.posn = posn;
    }
}