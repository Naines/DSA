import java.util.HashSet;

public class INCOMPLETE_firstNonRepeatitiveCharFormStream {
    public static String FirstNonRepeating(String str) {
        HashSet<Character> s = new HashSet<>();
        int n = str.length();
        String newStr = "";
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (s.contains(ch))
                newStr += '#';
            else
            {
                newStr += ch;
                s.add(ch);
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        String str="hrqcvsvszpsjammdrw";
        System.out.println(FirstNonRepeating(str));
    }
}
