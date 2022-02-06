import java.util.ArrayList;

/** Can be from any node to any node */
public class PrintAllKSumpath 
{
    static ArrayList<Integer> path=new ArrayList<>();
    static void print(Node n, int k)
    {
        if(n==null) return;
        path.add(n.data);

        //check if k sum occurs in left tree
        print(n.left, k);
        //check if k sum occurs in right tree
        print(n.right, k);

        //if terminating node found, print list
        int f=0;
        for(int i=path.size()-1;i>=0;i--)
        {
            f+=path.get(i);
            if(f==k)
            {
                printarr(path, i);
            }
        }
        //remove last node and return to parent
        path.remove(path.size()-1);
    }   
    static void printKPath(Node n, int k)
    {
        path=new ArrayList<>();
        print(n, k);
    }
    static void printarr(ArrayList<Integer> arr, int i)
    {
        for(int j=i;j<arr.size();j++)
        {
            System.out.print(arr.get(j)+"->");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        printKPath(root, k);
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
