import java.util.HashSet;
import java.util.Set;

public class largestSubTree 
{
    //gets sum of the entire tree from the root node of the (sub)tree
    static int sum(Node n)
    {
        if(n==null)
        return 0;
        int l=sum(n.left);
        int r=sum(n.right);
        return l+r+n.data;
    }
    static Set<Integer> sumSet(Node root, Set<Integer> s)
    {
        if(root==null)  return null;
        sumSet(root.left, s);
        //4 -2 5 1 -6 3 2
        s.add(sum(root));
        System.out.println(s);
        sumSet(root.right, s);
        return s;
    }
    static int findLargestSubtreeSum(Node root)
    {
        Set<Integer> s=new HashSet<>();
        s= sumSet(root, s);
        int max=Integer.MIN_VALUE;
        for(int i: s)
        max=Math.max(max, i);
        return max;
    }
    /**
     *    1
     *  -2   3
     * 4 5 -6 2
     * 
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left =new Node(-6);
        root.right.right = new Node(2);
        System.out.println(findLargestSubtreeSum(root));
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v){
            data=v;
        }
    }
}
