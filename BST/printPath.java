import java.util.Stack;

/**
 * printPath
 */
public class printPath {
    static Stack<Integer> stk = new Stack<>();

    static void printpath(Node n, int key) {
        if (n == null)
            return;
        if (n.data == key) {
            stk.add(n.data);
        } else if (n.data > key)// left
        {

            printpath(n.left, key);
            stk.add(n.data);

        } else if (n.data < key)// right
        {
            printpath(n.right, key);
            stk.add(n.data);
        }
        return;
    }

    public static void main(String[] args) {
        int arr[] = { 40, 30, 20, 50, 60, 55, 65 };
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        inorder(root);
        System.out.println();
        printpath(root, 20);
        if (stk.contains(20)) {
            System.out.println(stk);
        } else
            System.out.println("ELEMENT NOT IN THE TREE");
    }

    ///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }

    static Node insert(Node n, int v) {
        if (n == null)
            return new Node(v);
        if (n.data > v)
            n.left = insert(n.left, v);
        else if (n.data < v)
            n.right = insert(n.right, v);
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