public class TreeFromPreAndInorder {
    static Node build(int pre[], int in[])
    {
        return builder(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    //pre= root, left, right
    //in=  left, root, right
    static Node builder(int pre[], int preLow, int preHigh, int in[], int inLow, int inHigh)
    {
        if(preLow> preHigh || inLow>inHigh) return null;

        //create node by pre order first ele
        Node root=new Node(pre[preLow]);
        //search for root in inorder

        int inRoot=inLow;
        for(int i=inLow; i<inHigh;i++){
            if(in[i]==root.data)
            {
                inRoot=i;
                break;
            }
        }
        int leftLen=inRoot-inLow;  //root-left
        root.left=builder(pre, preLow+1, preLow+leftLen, in, inLow, inRoot-1);
        root.right=builder(pre, preLow+leftLen+1, preHigh, in, inRoot+1, inHigh);
        return root;
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
    public static void main(String[] args) {
        int pre[]={ 3, 9, 20, 15, 7};
        int in[]={ 9, 3, 15, 20, 7};

        Node root= build(pre, in);
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
