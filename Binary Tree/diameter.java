public class diameter {
    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }

    static int diameter = 0;

    static int dia(Node root) {
        depth(root);
        return diameter + 1;
    }

    static int depth(Node n) {
        if (n == null)
            return 0;

        int l = depth(n.left);
        int r = depth(n.right);

        diameter = Math.max(diameter, l + r);
        return Math.max(l, r) + 1;

    }

    /**
     * 1 2 3 4 5
     * 
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        System.out.println(dia(root));

    }
}
