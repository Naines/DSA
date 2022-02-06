public class countNodesinaRangemod 
{
    //use morris inorder transversal
    static void inorder(Node root, int l, int h)
    {
        Node curr=root;
        while(curr!=null)
        {
            //if curr.left is null then visit curr and goto right
            if(curr.left==null)
            {
                if(curr.data>=l && curr.data<=h)
                System.out.println(curr.data+" ");
                curr=curr.right;
            }
            else{
                //else find inorder pred of curr.
                Node pred=curr.left;
                while(pred.right!=null && pred.right!=curr)
                pred=pred.right;
            
                //if pred is null, pred.right=curr and goto curr.left
                if(pred.right==null)
                {
                    pred.right=curr;
                    curr=curr.left;
                }else{
                    //else pred.right=null , then pred.right=null, visit curr and goto right
                    pred.right=null;
                    if (curr.data >= l && curr.data <= h)
                        System.out.println(curr.data + " ");
                    curr=curr.right;
                }

            }
        }
    }

    public static void main(String[] args) {
        // Node root = new Node(10);
        // root.left = new Node(5);
        // root.right = new Node(50);
        // root.left.left = new Node(1);
        // root.right.left = new Node(40);
        // root.right.right = new Node(100);
        // inorder(root, 5, 40);


        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        inorder(root, 4, 12);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }
}
