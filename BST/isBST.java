public class isBST {
    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }

    static Node insert(Node n, int val) {
        if (n == null)
            return new Node(val);
        else if (n.data < val)
            n.right = insert(n.right, val);
        else if (n.data > val)
            n.left = insert(n.left, val);

        return n;
    }

    static void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }

    static boolean isValid(Node n, int min, int max) {
        // Idea is to check if node.data id bw min and max
        // if not it isnt valid bst and anamoly might exist
        if (n == null)
            return true;

        // i decide min or max for each node
        else if (n.data < min || n.data > max)
            return false;

        // while going left, max will change no restriction on min
        // while going right, min will change but min has
        // restriction as parent node.data is always < curr.data
        return (isValid(n.left, min, n.data - 1) && isValid(n.right, n.data + 1, max));
    }

    public static void main(String[] args) {
        int arr[] = { 1, 23, 23, 4, 1, 3, 12, 32 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();

        System.out.println(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        Node root2 = new Node(3);
        root2.left = new Node(2);
        root2.right = new Node(5);
        root2.left.left = new Node(1);
        root2.left.right = new Node(4);
        System.out.println(isValid(root2, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

}
