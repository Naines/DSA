import java.util.LinkedList;
import java.util.Queue;

public class deletion 
{
    static Node insert(Node n, int v)
    {
        if(n==null)
        {
           return new Node(v);
        }
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
            if (temp.right == null) {
            temp.right = new Node(v);
            break;
            } else
            q.add(temp.right);
        }
        return n;
    }
    static Node delete(Node n, int key)
    {
        if(n==null) return n;
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        Node temp=null;
        Node keyNode=null;
        while(!q.isEmpty())
        {
            temp=q.poll();
            if(temp.data==key)
            keyNode=temp;

            if(temp.left!=null)
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);

        }
        if(keyNode!=null)
        {
            keyNode.data=temp.data;
            deleteDeep(n, temp);
        }
        return n;
    }
    static void deleteDeep(Node n, Node del)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                Node temp=q.poll();
                if(temp.left!=null)
                {
                    if(temp.left==del)
                    {
                        temp.left = null;
                        break;
                    }  
                    else
                    q.add(temp.left);
                } 
                if (temp.right != null) {
                    if (temp.right == del) {
                        temp.right = null;
                        break;
                    } else
                        q.add(temp.right);
                }
            }
        }
    }
    static void levelorder(Node n)
    {
        Queue<Node>q =new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                Node temp=q.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null)    q.add(temp.right);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) 
    {
        long start=System.currentTimeMillis();
        int arr[]={1,2,3,4,5,6,7};
        Node root=null;
        for(int i: arr)
        root=insert(root, i);

        inorder(root);
        System.out.println();
        levelorder(root);

        root=delete(root, 2);
        levelorder(root);
        root=delete(root, 1);
        levelorder(root);
        root=delete(root, 5);
        root=delete(root, 3);
        //System.out.println(root.right.right);
        //root.right.right=null;
        levelorder(root);

        long end=System.currentTimeMillis();
        System.out.println(end-start+" ms");
    }
    
    static void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }
    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }
}
