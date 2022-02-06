import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//level order/ BFS always
//not dfs
public class bottomview 
{
    static Node insert(Node n, int v)
    {
        if(n==null) return new Node(v);
        Queue<Node> q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            if(temp.left == null)
            {
                temp.left=new Node(v);
                break;
            }else q.add(temp.left);
            if (temp.right == null) {
                temp.right = new Node(v);
                break;
            } else
                q.add(temp.right);
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
    // static void printbottom(Node n, TreeMap<Integer, Node> m, int count)
    // {
    //     if(n==null) return;
    //     Queue<Node> q=new LinkedList<>();
    //     q.add(n);
    //     while(!q.isEmpty())
    //     {
    //         int length=q.size();
    //         for(int i=0;i<length;i++)
    //         {
    //             Node temp = q.poll();
    //             if(temp==null)  continue;
    //             if(temp.left!=null)     q.add(temp.left);
    //             if(temp.right!=null)    q.add(temp.right);
                
    //         }
    //     }
    // }
    
    public static ArrayList<Integer> bottomView(Node n) 
    {
        ArrayList<Integer> l = new ArrayList<>();
        if (n == null)
            return l;
        Queue<Node> q = new LinkedList<>();
        TreeMap<Integer, Node> m = new TreeMap<>();
        q.add(n);
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Node temp = q.poll();
                int hd = temp.hd;
                if (temp.left != null) {
                    q.add(temp.left);
                    temp.left.hd = hd - 1;
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    temp.right.hd = hd + 1;
                }

                m.put(hd, temp);
            }
        }
        for (Map.Entry<Integer, Node> map : m.entrySet()) 
        {
            l.add(map.getValue().data);
        }
        return l;
    }
    
    public static void main(String[] args) 
    {
       
        Node root=null;
       
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
       
        System.out.println(bottomView(root));
        
    }
    static class Node{
        int data,hd;
        Node left, right;
        Node(int v)
        {
            hd=0;
            data=v;
        }
    }
}
