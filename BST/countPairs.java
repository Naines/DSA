import java.util.Stack;

/**
 * m1:- inorder of 1st and then for every node search x-node.data in second
 * tree. time: n*logn
 * 
 * m2:- iterative inorder and reverse ingterative inorder of another tree
 */
public class countPairs
{
    static int count(Node root1, Node root2, int x)
    {
        int count=0;
        if(root1==null || root2==null)  return 0;
        Stack<Node> stk1=new Stack<>();
        Stack<Node> stk2=new Stack<>();

        Node top1=null,top2=null;
        while(true)
        {
            while(root1!=null)
            {
                stk1.push(root1);
                root1=root1.left;
            }
            while (root2!= null) {
                stk2.push(root2);
                root2 = root2.right;
            }
            if(stk1.empty()|| stk2.isEmpty())
            break;
            top1=stk1.peek();
            top2=stk2.peek();

            //if equal-----count++  go left and right ahead
            if((top1.data+top2.data)==x)
            {
                count++;
                stk1.pop();
                stk2.pop();

                //go ahead
                root1=top1.right;
                root2=top2.left;
            }
            //sum<x =---go left ahead
            else if((top1.data+top2.data)<x)
            {
                stk1.pop();
                root1=top1.right;
            }
            //sum>x ----go right ahead
            else{
                stk2.pop();
                root2=top2.left;
            }
        }
        return count;
    }
    public static void main(String[] args) {

        Node root1 = new Node(5);               /* 5 */
        root1.left = new Node(3);         /* / \ */
        root1.right = new Node(7);        /* 3 7 */
        root1.left.left = new Node(2);  /* / \ / \ */
        root1.left.right = new Node(4); /* 2 4 6 8 */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        // formation of BST 2
        Node root2 = new Node(10);         /* 10 */
        root2.left = new Node(6);          /* / \ */
        root2.right = new Node(15);       /* 6 15 */
        root2.left.left = new Node(3);   /* / \ / \ */
        root2.left.right = new Node(8); /* 3 8 11 18 */
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
        
        int x=16;
        System.out.println("NUmber of pairs that sum upto 16 is :"+count(root1, root2, x));
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
