/**
 * largestBstinBT
 */
public class largestBstinBT {
    static int largestBst(Node root) {
        MinMax m = largest(root);
        // System.out.println(m.isBst + " " + m.size + " " + m.min + " " + m.max);
        return m.size;
    }

    static MinMax largest(Node root) {
        if (root == null)
            return new MinMax();
        MinMax left = largest(root.left);
        MinMax right = largest(root.right);
        // System.out.println("AT node "+root.data);
        MinMax m = new MinMax();
        // if either of left or right subtree says its not BST or the data
        // of this node is not greater/equal than max of left and less than min of right
        // then subtree with this node as root will not be BST.
        // Return false and max size of left and right subtree to parent.
        if (left.isBst == false || right.isBst == false || (left.max >= root.data || right.min <= root.data)) {
            m.isBst = false;
            m.size = Math.max(left.size, right.size);
            // System.out.println(m.isBst + " " + m.size + " " + m.min + " " + m.max);
            return m;
        }

        // reaching here means the subtree is valid BST
        m.isBst = true;
        // System.out.println("here");
        m.size = left.size + right.size + 1;
        m.min = root.left != null ? left.min : root.data;
        m.max = root.right != null ? right.max : root.data;
        // System.out.println(m.isBst + " " + m.size + " " + m.min + " " + m.max);
        return m;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(11);
        root.right = new Node(2);
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

    static class MinMax {
        int min, max, size;
        boolean isBst;

        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            size = 0;
            isBst = true;
        }
    }
}