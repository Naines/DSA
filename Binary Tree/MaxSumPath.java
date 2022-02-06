public class MaxSumPath 
{
    static int maxsum=0;

    static int maxSumPath(Node n)
    {
        if(n==null)
        return 0;
        maxsum=Integer.MIN_VALUE;
        sum(n, 0);
        return maxsum;
    }
    static void sum(Node n, int sum)
    {
        if(n==null)
        {
            if(maxsum< sum)
            {
                maxsum=sum;
            }
            return;
        }
        sum(n.left, sum+n.data);
        sum(n.right, sum+n.data);
    }
    public static void main(String[] args) 
    {
        
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        System.out.println("Following are the nodes " + "on maximum sum path");
        int sum = maxSumPath(root);
        System.out.println("");
        System.out.println("Sum of nodes is : " + sum);
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
