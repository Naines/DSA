import java.util.HashMap;

public class treeFromPostAndIn {
    static HashMap<Integer, Integer> mp = new HashMap<>();

    static Node buildTree(int in[], int post[], int n) {
        for (int i = 0; i < in.length; i++)
            mp.put(in[i], i);
        return builder(post, post.length - 1, in, 0, in.length - 1, mp);
    }

    // in: left root right
    // post: left right root
    static Node builder(int post[], int postHigh, int in[], int inLow, int inHigh, HashMap<Integer, Integer> mp) {
        if (inLow > inHigh || postHigh < 0)
            return null;
        Node root = new Node(post[postHigh]);

        int inRoot = mp.get(root.data);
        int rightlen = inHigh - inRoot;
        root.left = builder(post, postHigh - rightlen - 1, in, inLow, inRoot - 1, mp);
        root.right = builder(post, postHigh - 1, in, inRoot + 1, inHigh, mp);
        return root;
    }
    static void preorder(Node n)
    {
        if(n!=null)
        {
            System.out.print(n.data+" ");
            preorder(n.left);
            preorder(n.right);
        }
    }
    public static void main(String[] args) {
        int in[]={4 ,8 ,2 ,5 ,1 ,6, 3 ,7};
        int post[]={8 ,4 ,5, 2 ,6 ,7 ,3 ,1};
        Node root=buildTree(in, post, 0);
        preorder(root);
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
