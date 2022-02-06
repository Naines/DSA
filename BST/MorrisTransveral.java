public class MorrisTransveral {
    static void inorder(Node root)
    {
        Node curr=root;
        while(curr!=null)
        {
            // if left dont exist , visit and goto right
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                Node pred = curr.left;
                while (pred.right != curr && pred.right != null)
                    pred = pred.right;
               
                // if pred.right==null, set pred.right and goto left
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else // delete pred.right and visit curr and goto right
                {
                    pred.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
       
    }
    
    static void preorder(Node root) {
        Node curr = root;
        while (curr != null) {
            // if left dont exist , visit and goto right
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                Node pred = curr.left;
                while (pred.right != curr && pred.right != null)
                    pred = pred.right;

                // if pred.right==null, set pred.right and goto left
                if (pred.right == null) {
                    pred.right = curr;
                    System.out.print(curr.data + " ");
                    curr = curr.left;
                } else // delete pred.right and visit curr and goto right
                {
                    pred.right = null;
                    
                    curr = curr.right;
                }
            }
        }

    }
    public static void main(String[] args) {
        Node root=null;
        root=new Node(20);
        root.left=new Node(8);
        root.right=new Node(22);
        root.left.left=new Node(4);
        root.left.right=new Node(12);
        root.left.right.right=new Node(14);
        root.left.right.left=new Node(10);
        inorder(root);
        System.out.println();
        preorder(root);
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
