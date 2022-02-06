public class IsSumTree {
    static boolean isSumTree(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        int leftsum = 0, rightsum = 0;
        leftsum = sum(root.left);
        rightsum = sum(root.right);
        if (((leftsum + rightsum) == root.data) && isSumTree(root.left) && isSumTree(root.right))
            return true;
        else
            return false;
    }

    static int sum(Node n) {
        if (n == null)
            return 0;
        int sum = sum(n.left) + n.data + sum(n.right);
        return sum;
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
    }
    public static void main(String[] args) {
        Node root=new Node(26);
        root.left=new Node(10);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(6);
        root.right.right=new Node(3);
        if(isSumTree(root))
        System.out.println("Sum Tree");
        else 
        System.out.println("NOT a sum tree");
    }
}
