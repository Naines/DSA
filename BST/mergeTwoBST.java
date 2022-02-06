/**
 * mergeTwoBST
 */
import java.util.ArrayList;
public class mergeTwoBST {
    static ArrayList<Integer> storenodes(Node n, ArrayList<Integer> list)
    {
        if(n==null) return list;

        storenodes(n.left, list);
        list.add(n.data);
        storenodes(n.right, list);

        return list;
    }
    static ArrayList<Integer> mergeArray(ArrayList<Integer> l1, ArrayList<Integer> l2)
    {
        int m=l1.size(), n=l2.size();
        ArrayList<Integer> l3=new ArrayList<>();
        int i=0,j=0;
        while(i<m && j<n)
        {
            if(l1.get(i)<l2.get(j))
            l3.add(l1.get(i++));
            else 
            l3.add(l2.get(j++));
        }
        while(i<m){
            l3.add(l1.get(i++));
        }
        while(j<n){
            l3.add(l2.get(j++));
        }
        return l3;
    }
    static Node arrToBST(ArrayList<Integer> list, int s, int e)
    {
        if(s>e) return null;
        int mid=(s+e)/2;
        Node root=new Node(list.get(mid));
        root.left=arrToBST(list, s, mid-1);
        root.right=arrToBST(list, mid+1, e);
        return root;
    }
    static Node mergeBst(Node n1, Node n2)
    {
        ArrayList<Integer> l1=new ArrayList<>();
        l1=storenodes(n1,l1);
        ArrayList<Integer> l2=new ArrayList<>();
        l2=storenodes(n2,l2);
        ArrayList<Integer> l3=mergeArray(l1, l2);

        Node root3=arrToBST(l3, 0, l3.size()-1);
        return root3;

    }
    public static void main(String[] args) {
        Node root1=new Node(100);
        root1.left=new Node(50);
        root1.right=new Node(300);
        root1.left.left=new Node(20);
        root1.left.right=new Node(70);

        Node root2=new Node(80);
        root2.left=new Node(40);
        root2.right=new Node(120);

        Node root3=mergeBst(root1, root2);
        inorder(root3);
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
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
}