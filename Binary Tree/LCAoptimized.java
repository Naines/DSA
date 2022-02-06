/**
 * Node lca(Node root, int n1, int n2)
 * {
 *  
 * }
 */
public class LCAoptimized {
    
    static Node lca(Node n, int n1, int n2)
    {
        if(n==null) return null;
        if(n.data==n1 || n.data==n2)
        return n;

        Node left=lca(n.left, n1, n2);
        Node right=lca(n.right, n1, n2);

        //if both not null, actual val returned hence parent is lca
        if(left!=null && right!=null)
        return n;

        //else return whatever not null
        return (left!=null)? left:right;
    }

    //v1 and v2 denotes whether keys are present in the tree or not
    static boolean v1=false, v2=false;
    static Node lcaopt(Node root, int n1, int n2)
    {
        Node lca=lcaUtil(root, n1, n2);
        if(v1&&v2)
        return lca;

        //else
        System.out.println(v1+" "+v2);
        return null;
    }
    static Node lcaUtil(Node n,int n1, int n2)
    {
        if(n==null) return null;

        //System.out.println("AT node "+n.data);
        if(n.data==n1)  {
           
            v1=true;
            return n;
        }
        if(n.data==n2){
            
            v2=true;
            return n;
        }

        Node left=lcaUtil(n.left, n1, n2);
        Node right=lcaUtil(n.right, n1, n2);

        if(left!=null && right!=null)
        return n;

        //else
        return (left!=null)? left: right;

    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(11);
        root.left.right = new Node(51);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(61);
        System.out.println(lcaopt(root, 8,61));//51
        System.out.println(lcaopt(root, 8,9));//10
        System.out.println(lcaopt(root, 1100, 8));//5
    }
    static class Node{
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
        }
        public String toString()
        {
            return this.data+"";
        }
    }
}
