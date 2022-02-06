import java.util.ArrayList;

public class normalBSTToBalancedBST {
    /**
     * 1. Naive: DO inorder ..store in array and create tree by having some self
     * balancing structure like AVL.O(nlogn). 2. inorder,...store in array...make
     * balnaced BST from sorted array. 3. O(1) memeory: convertBST to dll and then
     * from dll back to balanced BST
     */
    static void storenodes(Node n, ArrayList<Node> l) {
        if (n == null)
            return;
        storenodes(n.left, l);
        l.add(n);
        storenodes(n.right, l);
    }

    static Node arrayToBST(ArrayList<Node> l, int s, int e) {
        if (s > e)
            return null;
        int mid = (s + e) / 2;
        Node root = l.get(mid);
        root.left = arrayToBST(l, s, mid - 1);
        root.right = arrayToBST(l, mid + 1, e);
        return root;
    }

    static Node build(Node root) {
        ArrayList<Node> l = new ArrayList<>();
        storenodes(root, l);

        int n = l.size();

        return arrayToBST(l, 0, n - 1);

    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root;
        root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(5);

        root = build(root);

        System.out.println();
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
