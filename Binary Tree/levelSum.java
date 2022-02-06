import java.util.Queue;
import java.util.LinkedList;

public class levelSum 
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
            }else   q.add(temp.left);

            if(temp.right==null)
            {
                temp.right=new Node(v);
                break;

            }else q.add(temp.right);
        }
        return n;
    }
    static void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    static void levelorderSum(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count=0;
            int length=q.size();
            for(int i=0;i<length;i++)
            {
                Node temp=q.poll();
                count++;
                System.out.print(temp.data+", ");
                sum+=temp.data;
                min=Math.min(min, temp.data);
                max=Math.max(max, temp.data);
                if(temp.left!=null)    q.add(temp.left);
                if(temp.right!=null)    q.add(temp.right);
            }
            
            System.out.print("= sum="+sum);
            System.out.print(" + avg= "+sum/count);
            System.out.print(" +min= "+min);
            System.out.print(" +max= "+max);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Node root=null;
        for(int i:arr)
        root=insert(root, i);
        inorder(root);
        System.out.println();
        levelorderSum(root);
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
