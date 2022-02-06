import java.util.Scanner;
import java.util.Stack;

/**
 * parenthesis
 */
public class parenthesis 
{
    static boolean isValid(String str) 
    {
        char ch[] = str.toCharArray();
        Stack<Character> s = new Stack<>();
        int len = ch.length;
        int i = 0;
        while (i < len) 
        {
            switch (ch[i]) 
            {
                case '{':
                    s.push(ch[i]);
                    break;
                case '(':
                    s.push(ch[i]);
                    break;
                case '[':
                    s.push(ch[i]);
                    break;
                case ']':
                    if (s.isEmpty() ||s.peek() != '[')
                        return false;
                    else
                        s.pop();
                    break;
                case ')':
                    if (s.isEmpty() ||s.peek() != '(')
                        return false;
                    else
                        s.pop();
                    break;
                case '}':
                    if (s.isEmpty() ||s.peek() != '{')
                        return false;
                    else
                        s.pop();
                    break;
                default:
                    break;
            }
            i++;
        }
        if (s.isEmpty())
            return true;
        return false;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(isValid(str));
        sc.close();
    }
}