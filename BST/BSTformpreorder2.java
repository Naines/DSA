public class BSTformpreorder2 {
    static int index=0;
    static Node construct(int pre[], int min, int max)
    {
        if(index>=pre.length)
        return null;

        //System.out.println("IN AT nODE" + pre[index] + " index= " + index);
        int val=pre[index];
        //first validate , pre[index] if pre[index] do not satisfy
        if(val <min ||val>max) return null;
        Node root=new Node(val);
        
        index++;

        root.left= construct(pre, min, val-1);
        root.right=construct(pre, val+1, max);
        return root;
    }
    static Node construct(int pre[])
    {
        index=0;
        return construct(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        //int pre[] = { 40, 30, 35, 80, 100 };
        int pre[] = { 100, 60, 34, 29, 1034, 459, 453, 415, 341, 203, 200, 153, 192, 327, 292, 252, 300, 335, 331, 389,
                413, 449, 432, 454, 675, 635, 622, 492, 563, 555, 503, 679, 803, 799, 798, 721, 702, 889, 875, 841, 885,
                887, 1033, 890, 962, 1025, 1036, 1085, 1077, 1039, 1086 };
        Node root = construct(pre);
        postorder(root);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int v) {
            data = v;
        }
    }
    
    static void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }
    
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
