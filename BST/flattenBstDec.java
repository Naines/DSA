class flattenBstDec
{
    static Node prev;
    static Node flatten(Node root)
    {
        if(root==null)   return null;
        //dummy node
        Node dummy=new Node(-1);
        prev=dummy;
        revinorder(root);
        prev.left=null;
        prev.right=null;
        
        //delete dummy
        Node ret=dummy.right;
        return ret;

    }
    static void revinorder(Node root)
    {
        if(root==null)  return;
        revinorder(root.right);
        prev.left=null;
        prev.right=root;
        prev=root;
        revinorder(root.left);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        root=flatten(root);
        print(root);
    }
    static class Node
    {
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
    }
    static void print(Node root)
    {
        if(root==null)  return;
        Node ptr=root;
        while(ptr!=null)
        {
            System.out.print(ptr.data+" ");
            ptr=ptr.right;
        }
    }
}