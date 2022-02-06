public class kthLargest {
    static Node insert(Node n, int v)
    {
        if(n==null) return new Node(v);
        if(n.data<v)    n.right=insert(n.right,v);
        else if(n.data>v)   n.left=insert(n.left,v);
        return n;
    }
    static void inorder(Node n)
    {
        if(n!=null)
        {
            inorder(n.right);
            System.out.print(n.data+" ");
            inorder(n.left);
        }
    }
    static int ans=0,k=0;
    static void KthLargest(Node n)
    {
        if(n!=null)
        {
            KthLargest(n.right);
            if(k==0)
            {
                System.out.println("here at node"+n.data);
                ans=n.data;
            }
            System.out.println(n.data+" "+k);
            k--;
            KthLargest(n.left);
        }
    }
    public static void main(String[] args) {
        int arr[]={43,324,2,42,4,1,1,1332,21,12};
        Node root=null;
        for(int i: arr)
        root=insert(root, i);
        inorder(root);
        k=6;
        KthLargest(root);
        System.out.println(ans);
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
