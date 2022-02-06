import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class printLeft 
{
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
        public String toString()
        {
            return this.data+" ";
        }
    }
    static Node insert(Node n, int v)
    {
        if(n==null)
        return new Node(v);

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
            }else   q.add(temp.right);
        }
        return n;    
    }
    
    static ArrayList<Integer> leftView(Node n) {
        ArrayList<Integer> l = new ArrayList<>();
        if (n == null)
            return l;
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {

                Node temp = q.poll();
                if (i == 0)
                    l.add(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return l;
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
    static void printleft(Node n,int count, TreeMap<Integer, Node> m)
    {
        if(n==null)
        return;
        if(!m.containsKey(count))
        m.put(count,n);

        if(n.left!=null)
        printleft(n.left, count-1, m);
        if(n.right!=null)
        printleft(n.right, count+1, m);
    }
    static void printMap(TreeMap<Integer, Node> m)
    {
        
        ///////////////////////////////////////////////////////////
        //////////////////////LEFT VIEW//////////////////////////
        //////////////////////////////////////////////////////////
        int min=Integer.MAX_VALUE;
        System.out.println("LEFT VIEW");
        for(Map.Entry<Integer, Node> map: m.entrySet()) 
        {
            if(map.getKey()<=0){
                System.out.println(map.getValue() + " ");
                min=Math.min(min, map.getKey());
            }
        }
        min*=-1;
        if(min>0)
        {
            for (Map.Entry<Integer, Node> map : m.entrySet()) {
                if (map.getKey() > min)
                    System.out.println(map.getValue() + " ");
            }

        }
       
        ///////////////////////////////////////////////////////////
        //////////////////////RIGHT VIEW//////////////////////////
        //////////////////////////////////////////////////////////

        int max=Integer.MIN_VALUE;
        System.out.println("RIGHT VIEW: ");
        for(Map.Entry<Integer, Node> map: m.entrySet())
        {
            if(map.getKey()>=0)
            {
                System.out.println(map.getValue() + " ");
                max=Math.max(max, map.getKey());
            }
        }
        max *= -1;
        
        if(max<0)
        {
            for (Map.Entry<Integer, Node> map : m.entrySet()) {
                if (map.getKey() < max) {
                    System.out.println(map.getValue() + " ");
                }
            }
        }

        ///////////////////////////////////////////////////////////
        ////////////////////// TOP VIEW//////////////////////////
        //////////////////////////////////////////////////////////
        System.out.println("TOP VIEW");
        for(Map.Entry<Integer, Node> map: m.entrySet())
        System.out.println(map.getValue());
    }
    public static void main(String[] args)
    {
        TreeMap<Integer, Node> m = new TreeMap<>();
        int arr[]={10,20,30,40,60};
        Node root=null;
        for(int i: arr) root=insert(root, i);

        inorder(root);
        printleft(root,0,  m);
        System.out.println("here");
        printMap(m);
        System.out.println(leftView(root));
        // System.out.println();
        //  for (Map.Entry<Integer, Node>  map: m.entrySet()) {
        //      System.out.println(map.getKey() + " " + map.getValue());
        // }
    }
}
