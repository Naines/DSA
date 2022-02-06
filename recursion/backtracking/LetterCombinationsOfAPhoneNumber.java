import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    static List<String> solve(String str)
    {
        List<String> list=new ArrayList<>();
        if(str=="")
        return list;
        find(list, 0, str, new StringBuilder());
        return  list;
    }
    static String keypad[]={"0", "1", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
    static void find(List<String> list, int i, String str, StringBuilder sb)
    {
        if(sb.length()==str.length())
        {
            list.add(sb.toString());
            return;
        }

        String curr=keypad[str.charAt(i)-'0'];
        for(char c: curr.toCharArray())
        {
            sb.append(c);
            find(list, i+1, str, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public static void main(String[] args) {
        String str="";
        System.out.println(solve(str));
    }
}
