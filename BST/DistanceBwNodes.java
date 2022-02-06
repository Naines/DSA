public class DistanceBwNodes 
{
    static int distanceRoot(Node n, int a)
    {
        if(n==null || n.data==a)
        return 0;
        if(n.data<a)
        return 1+distanceRoot(n.right, a);
        else if(n.data>a)
        return 1+distanceRoot(n.left, a);
        return 0;
    }
    static int distanceNodes(Node n, int a, int b)
    {
        if(n==null)
        return 0;
        //System.out.println("AT node "+n.data);
        if(n.data<a && n.data<b)
        return distanceNodes(n.right, a, b);
        else if(n.data>a && n.data>b)
        return distanceNodes(n.left, a, b);
        return distanceRoot(n, a)+distanceRoot(n, b);
    }
    public static void main(String[] args) 
    {
        int arr[] = { 40, 30, 20, 50, 60, 55, 65 };
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        inorder(root);
        System.out.println();
       System.out.println(distanceRoot(root, 65));
       System.out.println(distanceRoot(root, 20));
       
       System.out.println(distanceNodes(root, 20, 65));
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