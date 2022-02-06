import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


//slope=same for right child
//slope +1 for left child
public class Diagonaltrans 
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
                temp.left = new Node(v);
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
    static void inorder(Node n)
    {
        if(n!=null)
        {
            inorder(n.left);
            System.out.print(n.data+" ");
            inorder(n.right);
        }
    }
    static void diagonalTrans(Node n, int slope, HashMap<Integer, LinkedList<Integer>> m)
    {
        if(n==null)return;

        LinkedList<Integer> l=m.get(slope);
        if(l==null)
        l=new LinkedList<>();
        l.add(n.data);

        m.put(slope,l);
        diagonalTrans(n.left, slope+1, m);
        diagonalTrans(n.right, slope, m);
    }
    static void diagonal(Node n)
    {
        System.out.println();
        HashMap<Integer, LinkedList<Integer>> m=new HashMap<>();
        diagonalTrans(n, 0, m);

        for(HashMap.Entry<Integer, LinkedList<Integer>> map: m.entrySet())
        {
            System.out.println(map.getValue());
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        Node root=null;
        for(int i:arr)
        root=insert(root, i);
        inorder(root);
        diagonal(root);
    }
    static class Node{
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }
    
}
