import java.util.ArrayList;
import java.util.List;

/**
 * 
 * O(n^2*(2*k)) where n is the number of words and k is max length of the word
 */
public class PalinDromePairs_NAIVE {
    public static void main(String args[]) {
        long start = System.nanoTime();
        Solution2 ob = new Solution2();
        String words[] = { "abcd", "dcba", "lls", "s", "sssll" };
        List<List<Integer>> x = ob.palindromePairs(words);
        System.out.println(x);
        long end = System.nanoTime();
        System.out.println((end - start) / 10e9);
    }
}

class Solution2 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        int n = words.length;

        // O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                System.out.println(i + " " + j + " " + n);
                System.out.println(isPalin(words[i], words[j]));
                if (isPalin(words[i], words[j])) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }

    // O(2*k)
    boolean isPalin(String a, String b) {
        String x = a + b;
        int n = x.length();
        for (int i = 0; i <= n / 2; i++) {
            if (x.charAt(i) != x.charAt(n - i - 1))
                return false;
        }
        return true;
    }
}