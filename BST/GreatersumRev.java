public class GreatersumRev {
    static int sum = 0;

    static void convert(Node root) {
        if (root == null)
            return;
        // reverse inorder
        convert(root.right);
        sum += root.data;
        root.data = sum;
        convert(root.left);

    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        inorder(root);
        System.out.println();
        convert(root);
        inorder(root);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }
}
