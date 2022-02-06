import java.util.ArrayList;
import java.util.List;

/**
 * takes 2 transversals of tree to find path list
 * and 1 transversal in path lists' to get differening node.
 * O(n) but space =O(2n)
 */
public class LCAPAthMethod 
{
    static class Node{
        int data;
        Node left, right;
        Node(int v)
        {
            data=v;
        }
        
    }
    static int lca(Node n, int n1, int n2)
    {
        List<Integer> path1=new ArrayList<>();
        List<Integer> path2=new ArrayList<>();
        
        //find if both elements n1 and n2 present in the tree
        //and while check also make two path list
        if((!path(n, n1, path1))  || (!path(n, n2, path2)))//will enter only if anamoly happens
        {
            System.out.println((path1.size()>0)? "n1 present":"n1 absent");
            System.out.println((path2.size()>0)? "n2 present":"n2 absent");
            return -1;
        }

        // System.out.println(path1);
        // System.out.println(path2);
       
        int i;
        for(i=0;i<path1.size();i++)
        if(!path1.get(i).equals(path2.get(i)))
        break;
        return path1.get(i-1);
    }
    static boolean path(Node root, int n, List<Integer> path)
    {
        //if null ..backtrack
        if(root==null)  return false;

        path.add(root.data);

        if(root.data==n) return true;
        if(root.left!=null && path(root.left, n, path))
        return true;

        if(root.right!=null && path(root.right, n, path))
        return true;

        //remove if true not encountered hence element didnt backtrack 
        //which means element in path
        path.remove(path.size()-1);
        return false;
    }
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(6);
        root.left.left=new Node(11);
        root.left.right=new Node(51);
        root.right.left=new Node(7);
        root.right.right=new Node(9);
        root.left.right.left=new Node(8);
        root.left.right.right=new Node(61);

        System.out.println(lca(root, 7,11));
        System.out.println(lca(root, 7,51));
        System.out.println(lca(root, 51,11));
        System.out.println(lca(root, 8,61));
        
    }
}
