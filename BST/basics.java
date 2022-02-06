class basics
{
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
    static void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        return;
    }
    static void min(Node n)
    {
        //using BST property
        while(n.left!=null) n=n.left;
        System.out.println("Minimum val in the tree: "+n.data);
    }
    
    static void max(Node n) 
    {
        //using BST property
        while (n.right != null)
            n = n.right;
        System.out.println("Maximum val in the tree: " + n.data);
    }
    static int count(Node n)
    {
        if(n==null) return 0;
        // System.out.println("IN AT NODE"+n.data);
        int lcount = count(n.left)+1;
        int rcount = count(n.right)+1;
        // System.out.println(lcount+" "+rcount);
        return lcount + rcount -1;
    }
    static void printLeaves(Node n)
    {
        if(n==null) return;
        if(n.left==null && n.right==null)   System.out.print(n.data+" ");
        printLeaves(n.left);
        printLeaves(n.right);
    }
    static Node delete(Node n, int key)
    {
        if(n==null)
        return null;
        //if match then del
        if(n.data==key)
        {
            Node p,p2;
            //0 child
            if(n.left==n.right) //to delete return suitable node to the parent call
            return null;

            //1 child
            else if( n.left==null)
            return n.right;

            else if(n.right==null)
            return n.left;

            //2 child
            else{
                //copy whole left BST to the inorder successor 
                //i.e, the leftmost node of right kid
                p=n.right;
                p2=n.right;//stopper at n.right soon to be parent node

                while(p.left!=null) p=p.left;

                p.left=n.left;
                return p2;
            }
        }
        else if(n.data<key)//search in right
        {
            n.right=delete(n.right, key);
        }
        else //search in left
        {
            n.left=delete(n.left, key);
        }
        return n;  //return the node to parent
    }
    public static void main(String[] args) 
    {
        int arr[]={40,30,20,50,45,60,55,65};
        Node root=null;
        for(int i=0;i<arr.length;i++)
        {
            root=insert(root, arr[i]);
        }
        // inorder(root);
        // System.out.println();

        // min(root);
        // max(root);

        System.out.println("Number of nodes in the BST: "+count(root));

        printLeaves(root);
        // System.out.println();
        // root=delete(root, 20);
        // root=delete(root, 50);
        // inorder(root);
    }
    static class Node
    {
        int data;
        Node left=null,right=null;
        Node(int v)
        {
            data=v;
        }
    }
}