import java.util.HashMap;
import java.util.Map;

public class PrintAllDuplicateSubtrees 
{
    static Map<String, Integer> m=new HashMap<>();
    static String printAllDups(Node n)
    {
        if(n==null) return"";

        //inorder transversal to generate String
        //as null cannot be detected easily

        String str="(";
        str+=printAllDups(n.left);
        str+=Integer.toString(n.data);
        str+=printAllDups(n.right);
        str+=")";

        System.out.println(str);
        if(m.get(str)!=null && m.get(str)==1)
        System.out.println(n.data+" ");

        if(m.containsKey(str))
        m.put(str, m.get(str)+1);
        else 
        m.put(str, 1);

        return  str;
    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
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
