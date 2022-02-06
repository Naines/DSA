package revision;

import java.util.Stack;

public class basics1 {
    static Node insert(Node n, int val)
    {
        /**n will be created if n=null
         * get to left or right acc to prop of BST
         * if val==key return the node or dont consider the situation.
         * As dupes not allowed
         */
        if(n == null) return  new Node(val);
        if(n.data< val)  n.right=insert(n.right, val);
        else if(n.data > val)  n.left=insert(n.left, val);
        return n;
    }
    static void inorder(Node root){
        if(root==null)return ;
        Node curr=root;
        Stack<Node> stk=new Stack<>();
        while(curr!=null || !stk.isEmpty()){
            while(curr!=null){
                stk.push(curr);
                curr=curr.left;
            }

            curr=stk.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
        
    }
    static void preorder(Node root){
        Stack<Node> stk=new Stack<>();
        Node curr=root;
        while (curr!=null ||stk.size()> 0){
            while(curr!=null){
                System.out.print(curr.data+" ");
                stk.push(curr);
                curr=curr.left;
            }   
            curr=stk.pop();
            curr=curr.right;
        }
    }
    public static void main(String[] args) {
       int arr[]={40,30,20,50,45,60,55,65};
        Node root=null;
        for(int i=0;i<arr.length;i++)
        {
            root=insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();
        preorder(root);
    }static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
        }
    }
}
