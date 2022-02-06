import java.util.ArrayList;

public class printSum 
{
    static ArrayList<Integer> path=new ArrayList<>();
    static int sum=0;
    static int sum()
    {
        int s=0;
        for(int i: path)
        s=s*10+i;
        return s;
    }
    static void print(Node n)
    {
        if(n==null)
        {
            return;
        }
        
        path.add(n.data);
        print(n.left);
        
        print(n.right);
        if(n.left==null && n.right==null)
        {
            int x = sum();
            sum += x;
            System.out.println(x);
        }
        
        path.remove(path.size()-1);
        

        
    }
    static void treePathsSum(Node n)
    {
        path=new ArrayList<>();
        print(n);
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.right = new Node(4);
        root.left.right.left = new Node(7);


        treePathsSum(root);
        System.out.print("Sum of all paths is " + sum);
    }
    static class Node{
        int data;
        Node left,right;
        Node(int v)
        {
            data=v;
        }
    }
}
