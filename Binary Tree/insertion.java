import java.util.LinkedList;
import java.util.Queue;

/**
 * basics
 */
public class insertion 
{
    //static Node root;
    static Node temp;
    static Node insert(Node n, int v)
    {
        if(n==null)
        {
            n = new Node(v);
            return n;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        temp=null;
        while(!q.isEmpty())
        {
             temp=q.poll();
            
            if (temp.left == null)
            {
                temp.left=new Node(v);
                break;
            }    
            else
                q.add(temp.left);

            if (temp.right == null)
            {
                temp.right=new Node(v);
                break;
            }
            else
                q.add(temp.right);
        }
        return n;
    }
    static void levelorder(Node n)
    {
        if(n==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int i=0;i<l;i++)
            {
                Node temp=q.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            System.out.println();
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
    public static void main(String[] args) 
    {
        int arr[]={1,2,3,4,5,6,7};
        Node root=null;
        for(int i: arr) 
        root= insert(root, i);

        inorder(root);
        System.out.println();
        levelorder(root);
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