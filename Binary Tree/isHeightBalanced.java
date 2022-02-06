

/**
 * isHeightBalanced -application of property
 */
public class isHeightBalanced {

    static void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }

    //O(n^2) //top bottom approach
    //calculating height for each subnode again and again hence n^2
    static boolean isbalanced1(Node n) 
    {
        if(n==null) return true;
        return Math.abs(depth(n.left)-depth(n.right))>=1 && isbalanced1(n.left) && isbalanced1(n.right);
    }
    static int depth(Node n)
    {
        if(n==null) return 0;
        int left=depth(n.left);
        int right=depth(n.right);
        return Math.max(left, right)+1;
    }


    //M<ETHOD 2: bottom up approach O(n)
    static boolean isbalanced2(Node n)
    {
        if(n==null) return true;
        //func depth1 directly returns height in non negative if true else -1
        return depth1(n)!=-1;
    }
    static int depth1(Node n)
    {
        if(n==null) return 0;
        int left=depth1(n.left);
        if(left==-1)    return -1;
        int right=depth1(n.right);
        if(right==-1)   return -1;

        //condition for -1
        if(Math.abs(left-right)>1)  return -1;

        return Math.max(left, right)+1;
    }
    public static void main(String args[]) {

        Node root = null, root2 = null;

        // BALANCED
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(isbalanced1(root));
        System.out.println(isbalanced2(root));
        

        // UNBALANCED
        root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        root2.left.left.left = new Node(5);
        System.out.println( isbalanced1(root2));
       

    }

    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }
}