public class largestBSTinTreeNaive {
    static boolean isBST(Node root, int min, int max)
    {
        if(root==null)  return true;
        if(root.data<min || root.data>max)
        return false;

        return isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max);
    }
    static int size(Node root)
    {
        if(root== null) return 0;
        return 1+size(root.left)+size(root.right);
    }
    static int largestBst(Node root)//preorder
    {   
        if(root==null)  return 0;
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
        return size(root);

        int left=largestBst(root.left);
        int right=largestBst(root.right);

        return Math.max(left, right);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(11);
        root.right = new Node(1);
        root.left.left = new Node(10);
        root.right.left = new Node(1);
        root.right.right = new Node(6);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(4);

        System.out.println(largestBst(root));
    }

    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }
}
