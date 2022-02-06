import java.util.HashMap;

public class treeFromPreAndIn 
{
    static HashMap<Integer, Integer> mp=new HashMap<>(); 
    static Node build(int pre[], int in[])
    {
        for (int i = 0; i < in.length; i++)
            mp.put(in[i], i);
        return builder(pre,0, in, 0, in.length-1,mp);
    }
    //in: left root right
    //pre: root, left right
    static Node builder(int pre[] ,int preLow, int in[], int inLow, int inHigh, HashMap<Integer, Integer>mp)
    {
        if(preLow > pre.length-1 || inLow> inHigh)   return null;
        Node root=new Node(pre[preLow]);

        int inRoot=mp.get(root.data);

        root.left= builder(pre, preLow+1,in, inLow, inRoot-1, mp);
        root.right=builder(pre, preLow+inRoot-inLow+1, in , inRoot+1, inHigh, mp);

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
        int pre[]={3,9,20,15,7};
        int in[]={9,3,15,20,7};
        Node root=build(pre, in);
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
