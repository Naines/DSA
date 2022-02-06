/**
 * Mirror
 */
public class Mirror
{
    static void mirror(Node n)
    {
        if(n!=null)
        {
            mirror(n.right);
            mirror(n.left);

            Node temp=n.right;
            n.right=n.left;
            n.left=temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 40, 30, 20, 50, 60, 55, 65 };
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        inorder(root);
        System.out.println();
        mirror(root);
        inorder(root);
        System.out.println();
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