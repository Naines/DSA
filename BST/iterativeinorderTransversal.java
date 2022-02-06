import java.util.Stack;

public class iterativeinorderTransversal {
    static Node insert(Node root, int v)
    {
        if(root==null) return new Node(v);
        if(root.data>v) root.left=insert(root.left, v);
        if(root.data<v) root.right=insert(root.right, v);
        return root;
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
    static void iterative_inorder(Node root)
    {
        if(root==null)  return;
        Stack<Node> stk=new Stack<>();
        Node curr=root;
        //stk.add(curr);
        System.out.println("start");
        while(curr!=null || !stk.isEmpty())
        {
            while(curr!=null)
            {
                stk.push(curr);
                curr=curr.left;
            }
            curr=stk.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }
    public static void main(String[] args) {
        int arr[]=new int[]{10, 24,252,353,235,253,57,856,968,987};
        Node root=null;
        for(int i: arr)
        {
            root=insert(root, i);
        }
        iterative_inorder(root);
        
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
