public class distanceBetweenNodes {
    static Node lca(Node n, int n1, int n2)
    {
        if(n==null) return null;
        if(n.data==n1 || n.data==n2)
        return n;

        Node left=lca(n.left , n1, n2);
        Node right=lca(n.right, n1, n2);

        //if left right both !=null return n
        if(left!=null && right!=null)   return n;

        //else return whatever not null
        return  (left!=null)? left: right;
    }

    //distance between nodes=d(root, n1)+d(root, n2)-2*d(root, lca)
    //d(root, x)-actually level number of the node
    static int level(Node n,int n1)
    {
        if(n==null) return -1;

        if(n.data==n1)  return 1;

        int left=level(n.left, n1);
        int right=level(n.right, n1);
        
       if(left>0)
       return left+1;
       else if(right>0)
       return right+1;
       return -1;
    }
    static int dist2(Node root, int n1, int n2)
    {
        Node lca=lca(root, n1, n2);

        //d=d(root, n1)+d(root, n2)-2*d(root, lca)

        return level(root, n1)+level(root, n2)-2*(level(root, lca.data));

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
        System.out.println(lca(root, 8, 61));// 51
        System.out.println(lca(root, 8, 9));// 10
        System.out.println(lca(root, 1100, 8));// 5
        System.out.println(level(root, 8));//4
        System.out.println(level(root, 10));//1
        System.out.println(level(root, 9));//3
        System.out.println(level(root, 100));//-1
        System.out.println(level(root, 11));//3
        System.out.println();
        System.out.println(dist2(root,11, 9));
    }
    
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

        public String toString() {
            return this.data + "";
        }
    }
}
