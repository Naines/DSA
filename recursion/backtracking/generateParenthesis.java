import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    static List<String> generate(int n)
    {
        List<String> list=new ArrayList<>();
        go(list, new StringBuilder(), 0, 0, n);
        return list;
    }
    static void go(List<String> list, StringBuilder sb, int open, int close, int n)
    {
        if(sb.length()==2*n)
        {
            list.add(sb.toString());
            return;
        }
        if(open< n)
        {
            sb.append("(");
            go(list, sb, open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close< open)
        {
            sb.append(")");
            go(list, sb, open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(generate(n));        
    }
}
