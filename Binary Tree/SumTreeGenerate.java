import java.util.LinkedList;
import java.util.Queue;

public class SumTreeGenerate
{
    static int SumTree(Node n)
    {
        if(n==null) return 0;
        int old=n.data;
        int left=0, right=0;

        if(n.left!=null)    left=SumTree(n.left);
        if(n.right!=null)   right=SumTree(n.right);

        n.data=left+right;

        return old + n.data;
    }
    
    static void levelorderSum(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count = 0;
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Node temp = q.poll();
                count++;
                System.out.print(temp.data + ", ");
                sum += temp.data;
                min = Math.min(min, temp.data);
                max = Math.max(max, temp.data);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }

            System.out.print("= sum=" + sum);
            System.out.print(" + avg= " + sum / count);
            System.out.print(" +min= " + min);
            System.out.print(" +max= " + max);
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
    public static void main(String[] args) {
       Node root=new Node(20);
        root.left= new Node(-2);
        root.right= new Node(6);
        root.left.left= new Node(8);
        root.left.right= new Node(-4);
        root.right.left= new Node(7);
        root.right.right= new Node(5);
        
        int x=SumTree(root);
        System.out.println(x);
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
