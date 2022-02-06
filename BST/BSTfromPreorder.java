public class BSTfromPreorder {
    static Node constructNaive(int pre[], int s, int e)
    {
        if(s>e) return null;
        Node root=new Node(pre[s]);

        int i;
        for(i=s;i<=e;i++)
        {
            if(pre[i]>pre[s])
            break;
        }
        root.left=constructNaive(pre, s+1, i-1);
        root.right=constructNaive(pre, i, e);
        return root;
    }
    /** 40 30 35 80 100 */
    static void postorder(Node root)
    {
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
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
        //int pre[]={40, 30, 35, 80, 100};
        int pre[]={100 ,60 ,34,29 ,1034 ,459 ,453, 415 ,341, 203 ,200 ,153 ,192 ,327 ,292 ,
        252 ,300 ,335, 331, 389 ,413, 449, 432 ,454, 675, 635, 622, 492, 563 ,555 ,503, 679, 803 ,
        799 ,798 ,721 ,702 ,889 ,875 ,841 ,885, 887 ,1033, 890 ,962, 1025 ,1036, 1085 ,1077 ,1039 ,1086};
        
        Node root= constructNaive(pre, 0, pre.length-1);
        postorder(root);
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
