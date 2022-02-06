import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class levelorderalt {
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
    }
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
        if(n==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        Stack<Node> stk=new Stack<>();
        boolean yes=false;
        int count=0;
        while(!q.isEmpty())
        {
            count++;
            int length=q.size();
            for(int i=0;i<length;i++)
            {
                Node temp=q.poll();
                if(!yes)
                System.out.print(temp.data+" ");
                else 
                stk.push(temp);

                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null)    q.add(temp.right);
            }
            while(!stk.isEmpty())
            {
                Node temp=stk.pop();
                System.out.print(temp.data+" ");
            }
            if(count==1)
            {
                count=0;
                yes=!yes;
            }
            
            System.out.println();
        } 
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Node root=null;

        for(int i: arr)
        root=insert(root, i);

        levelorder(root);
    }
}
