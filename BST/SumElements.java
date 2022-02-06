public class SumElements {

    static int sum(Node n, int sum) {
        if (n == null)
            return 0;
        else {
            sum = sum(n.left, sum);
            sum += n.data;
            sum += sum(n.right, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = { 40, 30, 20, 50, 45, 60, 55, 65 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();

        int sum = sum(root, 0);
        System.out.println("Sum of all nodes= " + sum);
    }

    ////////////////////////////////////////////////////////////////////////
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
}
