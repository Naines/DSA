import java.util.ArrayDeque;
import java.util.Deque;

public class nonRepeatingStream {
    public static String FirstNonRepeating(String A) {
        // code here
        int map[] = new int[26];
        StringBuffer newStr = new StringBuffer();
        Deque<Character> q = new ArrayDeque<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            map[ch - 'a']++;
            q.addLast(ch);
            while (!q.isEmpty()) {
                if (map[q.peekFirst() - 'a'] > 1)
                    q.removeFirst();
                else
                    break;
            }
            if (q.isEmpty())
                newStr.append('#');
            else
                newStr.append(q.peekFirst());
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        // String str = "hrqcvsvszpsjammdrw";// hhhhhhhhhhhhhhhhhh
        String str = "pqimpqimysf";// ppppqiiii
        System.out.println(FirstNonRepeating(str));
    }
}
