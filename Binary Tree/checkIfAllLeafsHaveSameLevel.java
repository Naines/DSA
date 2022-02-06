import java.util.LinkedList;
import java.util.Queue;

class checkIfAllLeafsHaveSameLevel
{
   
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
    static boolean checker(Node n)
    {
        if(n==null)return true;
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        int res=Integer.MAX_VALUE;
        int ht=0;
        while(!q.isEmpty())
        {
            int length=q.size();
            ++ht;
            for(int i=0;i<length;i++)
            {
                Node temp=q.poll();
                if (temp.left != null) 
                {
                    q.add(temp.left);
                    //if temp.left is leaf node
                    if (temp.left.left == null && temp.left.right == null) 
                    {
                        if (res == Integer.MAX_VALUE)
                            res = ht;
                        else if (res != ht)
                            return false;
                    }
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    //if temp.right is a leaf node
                    if (temp.right.left == null && temp.right.right == null) 
                    {
                        if (res == Integer.MAX_VALUE)
                            res = ht;
                        else if (res != ht)
                            return false;
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        Node root=new Node(0);
        root.left=new Node(1);
        root.right=new Node(2);
        root.left.left=new Node(3);
        root.left.left.left=new Node(4);
        
        levelorder(root);
        if(checker(root)==true)
        System.out.println("leaves at same level");
        else 
        System.out.println("leaves not at same level");
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