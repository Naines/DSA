import java.util.LinkedList;
import java.util.Queue;

public class BoundaryTrans 
{
    //here one trans for left side
    //1 for right boundary
    //1 for leaf nodes of the tree
    static Node insert(Node n, int v)
    {
        if(n==null) return new Node(v);
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            if(temp.left==null)
            {
                temp.left=new Node(v);
                break;
            }else 
            q.add(temp.left);

            if(temp.right==null)
            {
                temp.right=new Node(v);
                break;
            }else q.add(temp.right);
        }
        return n;
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
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
    static void left(Node n)
    {
        if(n==null)return;
        if(n.left==null && n.right==null)return;
        System.out.print(n.data+" ");
        if(n.left!=null)    left(n.left);
        else left(n.right); 
    }
    static void right(Node n)
    {
        if(n==null )return;
        if(n.left== null && n.right==null )return;
       
        if(n.right!=null)   right(n.right);
        else   right(n.left);
        System.out.print(n.data + " ");
    }
    static void leaf(Node n)
    {
        if(n==null) return;
        if(n.left==null && n.right==null)
        System.out.print(n.data+" ");
        if(n.left!=null) leaf(n.left);
        if(n.right!=null) leaf(n.right);
    }
    static void print(Node n)
    {
        System.out.println();
        if(n==null) return;
        System.out.print(n.data+" ");
        left(n.left);
        leaf(n);
        right(n.right);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Node root=null;
        for(int i: arr)
        root=insert(root, i);
        root=new Node(0);
        root.left=new Node(1);
        root.right=new Node(2);
        root.left.left=new Node(3);
        inorder(root);
        print(root);
    }
}
