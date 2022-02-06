public class checkMirror 
{
    static boolean mirror(Node a, Node b)
    {
        /**
         * 1. both node data same
         * 2. a.left==b.right
         * 3. b.left==a.right
         */
        //both empty
        if(a==null && b==null )    return true;

        //one empty
        if(a==null || b==null)  return false;

        return a.data==b.data 
                && mirror(a.left, b.right)
                && mirror(a.right, b.left);
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);

        if (mirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    static class Node
    {
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
    }
    
}
