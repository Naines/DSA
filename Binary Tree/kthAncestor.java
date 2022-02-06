import java.util.ArrayList;

public class kthAncestor 
{
    static boolean cond=false;
    static void getpath(Node n, int n1, ArrayList<Integer> path)
    {
        if(n==null || cond==true)    return;

        path.add(n.data);
        if(n.data==n1)  
        {
            cond=true;
            return;
        }

        getpath(n.left, n1, path);
       
        getpath(n.right, n1, path);
        if(cond==true)
        return;
        path.remove(path.size() - 1);
    }
    static int find(Node root, int n, int k)
    {
        ArrayList<Integer> path=new ArrayList<>();
        cond=false;
        getpath(root, n, path);
        System.out.println(path);
        int len=path.size();
        if(len-1-k<0)   return -1;
        else
        return path.get(len-1-k);

    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(11);
        root.left.right = new Node(51);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(61);

        System.out.println(find(root, 8, 2));
        System.out.println(find(root, 11, 3));
        System.out.println(find(root, 51, 2));
        System.out.println(find(root, 61, 2));
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
