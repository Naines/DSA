import java.util.PriorityQueue;

public class minimumSumFromDigits {
    static String solve(int[] arr, int n) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        int a[] = new int[(n + 1) / 2];
        int b[] = new int[(n) / 2];
        int x = 0, y = 0;
        while (!pq.isEmpty()) {
            a[x++] = pq.poll();
            if (pq.size() != 0)
                b[y++] = pq.poll();
        }
        String as = "", bs = "";
        for (int i : a)
            as += i;
        // System.out.println();
        for (int i : b)
            bs += i;
        return findSum(as, bs);
    }

    static String findSum(String str1, String str2) {
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty String for storing result
        String str = "";

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both Strings
        for (int i = n1 - 1; i >= 0; i--) {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((int) (str1.charAt(i) - '0') + (int) (str2.charAt(i + diff) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining digits of str2[]
        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((int) (str2.charAt(i) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            str += (char) (carry + '0');

        // reverse resultant String
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        int digits[] = { 1, 1, 5, 2, 7, 6, 1, 4, 2, 3, 2, 2, 1, 6, 8, 5, 7, 6, 1, 8, 9, 2, 7, 9, 5, 4, 3, 1 };
        System.out.println(solve(digits, digits.length));
    }
}
