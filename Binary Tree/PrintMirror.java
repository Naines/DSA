import java.util.LinkedList;
import java.util.Queue;

public class PrintMirror 
{
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
            }else q.add(temp.left);

            if(temp.right==null)
            {
                temp.right=new Node(v);
                break;
                
            }else q.add(temp.right);
        }
        return n;
    }
    static void levelorder(Node n)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            int length=q.size();
            for(int i=0;i<length;i++)
            {
                Node temp=q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null)    q.add(temp.right);
                System.out.print(temp.data+" ");
            }
            System.out.println();
        }
    }
    static Node mirror(Node n)
    {
        if(n==null) return n;
        Node left=mirror(n.left);
        Node right=mirror(n.right);
        n.left=right;
        n.right=left;
        return n;  
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Node root=null;
        for(int i: arr)
        {
            root=insert(root, i);
        }
        levelorder(root);
        Node mirror=mirror(root);
        levelorder(mirror);
        
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v){
            data=v;
        }
    }

}
