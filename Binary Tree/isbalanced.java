import java.util.LinkedList;
import java.util.Queue;

public class isbalanced 
{
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
        
        static Node insert(Node n, int v) {
            if (n == null)
                return new Node(v);

            Queue<Node> q = new LinkedList<>();
            q.add(n);
            while (!q.isEmpty()) {
                Node temp = q.poll();
                if (temp.left == null) {
                    temp.left = new Node(v);
                    break;
                } else
                    q.add(temp.left);

                if (temp.right == null) {
                    temp.right = new Node(v);
                    break;
                } else
                    q.add(temp.right);
            }
            return n;
        }
        static void inorder(Node n)
        {
            if(n!=null)
            {
                inorder(n.left);
                System.out.print(n.data+" ");
                inorder(n.right);
            }
        }
        static boolean isBalanced(Node n)
        {
            if(n==null) return true;
            int lh=height(n.left);
            int rh=height(n.right);

            //3 conditions:(overall check): 
            //1. abs(rht-lht) <=1
            //2. left and 3. right subTree balanced
            //children nodes balanced
            if(Math.abs(lh-rh)<=1 && isBalanced(n.left) && isBalanced(n.right))
            return true;

            return false;
        }
        static int height(Node root)
        {
            if(root==null)  return 0;
            return 1+Math.max(height(root.left), height(root.right));
        }
        public static void main(String[] args) {
            int arr[]={1,2,3,4,5,6,7};
            Node root=null;
            for(int i:arr)
            root=insert(root, i);
            inorder(root);
            Node root2=new Node(1);
            root2.left=new Node(2);
            root2.left.left=new Node(3);
            System.out.println(isBalanced(root2));
        }
    }
}
