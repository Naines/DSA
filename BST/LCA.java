class LCA
{
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

    //if node.data> n1 and n2 , lca lies to the left
    //if node.data< n1 and n2, lca lies to the right
    //if n.data is between n1 and n2, it doesnt enter into recursion and return lca node directly
    //IDEA is to transverse from top to bottom as reqd.
    static Node ancestor(Node n, int k1, int k2)
    {
        if(n==null)
        return null;

        if(n.data<k1 && n.data<k2)
        return ancestor(n.right, k1, k2);

        else if(n.data>k1 && n.data>k2)
        return ancestor(n.left, k1, k2);


        return n;
    }
    public static void main(String[] args) 
    {
        int arr[] = { 40, 30, 20, 50, 45, 60, 55, 65 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();

        System.out.println(ancestor(root, 45,20).data); 
        
    } 
    
}