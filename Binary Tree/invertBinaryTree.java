import java.util.LinkedList;
import java.util.Queue;

class invertBinaryTree
{
    static Node insert(Node n, int v)
    {
        if(n==null) return new Node(v);

        //insert in bfs fashion
        Queue<Node> q=new LinkedList<>();
        q.add(n);

        while(!q.isEmpty())
        {
                Node temp=q.poll();
                
                if(temp.left!=null) q.add(temp.left);
                else{
                    temp.left=new Node(v);
                    break;
                }
                if(temp.right!=null)    q.add(temp.right);
                else{
                    temp.right=new Node(v);
                    break;
                }
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
    static void mirror(Node n)
    {
        if(n!=null)
        {
            mirror(n.left);
            mirror(n.right);

            Node temp=n.left;
            n.left=n.right;
            n.right=temp;
        }
    }
    static Node invert(Node root)
    {
        if(root==null)  return root;
        Node left=invert(root.left);
        Node right=invert(root.right);

        root.right=left;
        root.left=right;
        return root;
    }

    static Node invert2(Node root)
    {
        if(root==null)  return root;

        //first invert and then go inside
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;

        invert2(root.left);
        invert2(root.right);

        return root;
    }
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5,6,7};
        Node root=null;
        for(int i: arr)
        root=insert(root, i);
        inorder(root);
        System.out.println();

        root=invert(root);
        inorder(root);
        System.out.println();

        root=invert2(root);
        inorder(root);

    }
    static class Node{
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
        }
    }
}