import java.util.Stack;
/**
 * Uses 2 functions : find(): finds index of last ')'
 *                    build(): builds tree by divide and conquer
 * Find last index of ')' and go recursively on two sides
 * as build(str, start+2, index-1)
 * and build(str, index+2, end-1) .
 * 
 * Base : start<end return null
 */
public class TreeFromPreorderString 
{
    public static void main(String[] args) {
        String str="4(2(3)(1))(6(5))";
        Node root=buildTree(str);
        preorder(root);
    }
    static Node buildTree(String str)
    {
        Node root=null;
        root=build(str, 0, str.length());
        return root;
    }
    static Node build( String str, int start, int end)
    {
        //1((2),(3))
        if(start>end)
        return null;

        //func
        Node root=new Node(str.charAt(start)-'0');
        int index=-1;
        if(start+1<end &&  str.charAt(start+1)=='(')
        index=find(str, start+1, end);//start+1 because ( starts from start +1
        //left
        //right
        if(index!=-1)
        {
            root.left=build(str, start+2, index-1);
            root.right=build(str, index+2, end-1);
        }
        return root;
    }
    static int  find(String str, int start, int end)
    {
        if(start>end)   return -1;
        Stack<Character> stk=new Stack<>();
        for(int i=start; i<=end;i++)
        {
            char ch=str.charAt(i);
            if(ch=='(')
            stk.push(ch);
            else if(ch==')')
            {
                if(stk.peek()=='(')
                stk.pop();
                if(stk.isEmpty())
                return i;
            }
        }

        return -1;
    }
    static void preorder(Node n)
    {
        if(n!=null)
        {
            System.out.print(n.data+" ");
            preorder(n.left);
            preorder(n.right);
        }
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
