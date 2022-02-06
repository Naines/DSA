public class countNodesinaRange {
    static int getCount(Node root, int l, int h)
    {
        if(root==null)      return 0;
        if(root.data>=l && root.data<=h)
        return 1+getCount(root.left, l, h)+ getCount(root.right, l, h);
        else if(root.data<l)    return getCount(root.left, l, h);
        else    return getCount(root.right, l, h);

    }
    static void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10); 
        root.left     = new Node(5); 
        root.right     = new Node(50); 
        root.left.left = new Node(1); 
        root.right.left = new Node(40); 
        root.right.right = new Node(100); 
        inorder(root);
        System.out.println();
        System.out.println(getCount(root, 5, 50));
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
    }
}
