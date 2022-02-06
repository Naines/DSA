import java.util.ArrayList;

public class AllPathToSumK 
{
   static void print(Node n, int k, int sum, ArrayList<Integer> path)
   {
       if(n==null)  return;
        sum+=n.data;
        path.add(n.data);
        if(sum==k)
        {
            //print arraylist
            for(int i: path)
            System.out.print(i+"->");
            System.out.println();
        }
        if(n.left!=null)
        print(n.left, k, sum, path);
        if(n.right!=null)
        print(n.right, k, sum, path);
        path.remove(path.size()-1);

   }
    static void printpaths(Node n ,int k)
    {
        ArrayList<Integer> l=new ArrayList<>();
        print(n, k, 0, l);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);
        int k=4;
        printpaths(root, k);
    }
    static class Node{
        int data;
        Node left, right;
        Node(int v){
            data=v;
        }
    }
}
