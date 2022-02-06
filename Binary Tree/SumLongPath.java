public class SumLongPath 
{
   static int maxlen;
   static int maxsum;

    static int sum(Node n)
    {
        if(n==null) return 0;
         maxsum=Integer.MIN_VALUE;
         maxlen=0;
        sumUtil(n,0,0);
        return maxsum;  
    }
    static void sumUtil(Node n, int len, int sum)
    {
        //last node- 2 cases: maxlen<len => update the maxlen and maxsum
        //                                           or
        //                  if(maxlen==len) but maxsum<sum select path with more sum
        if(n==null)
        {
            if(maxlen<len)
            {
                maxlen=len;
                maxsum=sum;
            } 
            else if (maxlen == len && maxsum < sum) 
            {
                maxsum = sum;
            }
            return;
        }
        
        sumUtil(n.left, len+1, sum+n.data);
        sumUtil(n.right, len+1, sum+n.data);

    }
    public static void main(String[] args) {
        Node root = new Node(4);          /* 4 */
        root.left = new Node(2);         /* / \ */
        root.right = new Node(5);        /* 2 5 */
        root.left.left = new Node(7);   /* / \ / \ */
        root.left.right = new Node(1);  /* 7 1 2 3 */
        root.right.left = new Node(2);  /* / */
        root.right.right = new Node(3); /* 6 */
        root.left.right.left = new Node(6);

        System.out.println("Sum = " + sum(root));
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
