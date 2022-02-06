import java.util.PriorityQueue;

class bttoBST
{
    static PriorityQueue<Integer> l = new PriorityQueue<>();
    static void convert(Node root)
    {
        dfs(root);
        dfs1(root);
    }
    //makes bt to array..(sorted)
    static void dfs(Node n)
    {
        if(n==null)    return;

        dfs(n.left);
        l.add(n.data);
        dfs(n.right);
    }
    //replcae data in inorder fashion
    static void dfs1(Node n)
    {
        if(n==null) return;
        dfs1(n.left);
        n.data=l.poll();
        dfs1(n.right);
    }
    static void inorder(Node n)
    {
        if(n!=null)
        {
            inorder(n.left);
            System.out.print(n.data+" ");
            inorder(n.right);
        }
    }
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(30);
        root.right=new Node(15);
        root.left.left=new Node(20);
        root.right.right=new Node(5);
        inorder(root);
        convert(root);
        System.out.println();
        inorder(root);
    }
    static class Node{
    int data;
    Node left, right;
    Node(int v)
    {
        data=v;
    }
    }
}