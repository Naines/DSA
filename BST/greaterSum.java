public class greaterSum 
{
    static Node insert(Node n, int v)
    {
        if(n==null)  return new Node(v);
        if(n.data > v)  n.left=insert(n.left,v);
        if(n.data < v)   n.right=insert(n.right,v);
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
    static int sum=0;
    static void greaterTree(Node n)
    {
        //we do reverse inorder type of transversal
        if(n==null) return ;

        //n.right....is the greatest node
        greaterTree(n.right);

        //update sum
        sum+=n.data;
        //old sum in parent node
        n.data= sum - n.data;
        greaterTree(n.left);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Node root=null;
        for(int i: arr)
        root=insert(root, i);
        inorder(root);
        System.out.println();
        greaterTree(root);
        inorder(root);


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
