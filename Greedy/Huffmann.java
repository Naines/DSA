import java.util.ArrayList;
import java.util.PriorityQueue;
//0000 0001 00100 001010 001011 0011 0100 0101 0110 0111 
//1000 100100 100101 10011 1010 1011 1100 11010 11011 1110 111100 1111010 11110110 11110111 11111
public class Huffmann 
{
    static ArrayList<String> list;
    public static void main(String[] args) {
        // String S="abcdef";
        // int f[]= {5, 9, 12, 13, 16, 45};
        // String S="qwertyuiopasdfghjklzxcvbn";
        // int f[]={8, 9, 14 ,19 ,20, 21 ,21 ,25, 33, 45 ,50 ,50 ,66, 68 ,70 ,73, 74, 75 ,76, 82, 85, 90 ,94,97 ,100};
        String S="edlucmkz";
        int f[]={120, 42, 42, 37, 32, 24, 7, 2};
        int N=f.length;
        System.out.println(huffmanCodes(S, f, N));
    }
    
    public static ArrayList<String> huffmanCodes(String S, int f[], int N) {
       list=new ArrayList<>();

        //Make priority Queue
        PriorityQueue<Node> pq=new PriorityQueue<Node>();
        Node nodes[]=new Node[N];
        for(int i=0;i<N;i++)
        {
            nodes[i]=new Node(S.charAt(i), f[i]);
            pq.add(nodes[i]);
        }

        //make Huffmann Tree
        Node root=null;
        while(pq.size()>1)
        {
            Node x=pq.poll();
            Node y=pq.poll();
            System.out.println("x and y are"+x+","+y);
            Node temp=new Node('-',x.data+y.data);
            pq.add(temp);
            temp.left=x;
            temp.right=y;
            root=temp;
        }

        //print result
        preorder(root, list, "");
        return list;
    }
    static void preorder(Node root, ArrayList<String> list, String s)
    {
        if(root.left==null && root.right==null && Character.isLetter(root.c))
        {
            System.out.println(root.c+" : "+s +" "+root.data);
            return;
        }
        preorder(root.left, list, s+"0");
        preorder(root.right, list, s+"1");
    }
    static class Node implements Comparable<Node>
    {
        int data;
        char c;
        Node left, right;
        Node(char c, int data)
        {
            this.c=c;
            this.data=data;
            left=right=null;
        }
        public int compareTo(Node o)
        {
            if(this.data==o.data)   return 1;
            return this.data-o.data;
        }
        
        // public int compareTo(Node o) {
        //     // if (this.data == o.data)
        //     //     return 1;
        //     return this.data - o.data;
        // }
        public String toString()
        {
            return this.data+" "+this.c;
        }
    }
}
