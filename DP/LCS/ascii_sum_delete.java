import java.util.Arrays;

public class ascii_sum_delete {
    static int mds(int w1[], int w2[], int m, int n) {

        if (m == 0)
            return sum(pre2, n);
        if (n == 0)
            return sum(pre1, m);
        if (w1[m - 1] == w2[n - 1])
            return mds(w1, w2, m - 1, n - 1);
        else
            return Math.min(mds(w1, w2, m - 1, n) + w1[m - 1], mds(w1, w2, m, n - 1) + w2[n - 1]);
    }

    static int mds1(int w1[], int w2[], int m, int n, int memo[][]) {

        if (memo[m][n] != -1)
            return memo[m][n];
        else if (m == 0)
            memo[m][n] = sum(pre2, n);
        else if (n == 0)
            memo[m][n] = sum(pre1, m);
        else if (w1[m - 1] == w2[n - 1])
            memo[m][n] = mds1(w1, w2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.min(mds1(w1, w2, m - 1, n, memo) + w1[m - 1], mds1(w1, w2, m, n - 1, memo) + w2[n - 1]);
        return memo[m][n];
    }

    static int sum(int arr[], int n) {
        return arr[n];
    }

    static int pre1[];
    static int pre2[];

    public static void main(String[] args) {
        // String s1 = "sea", s2 = "eat";
        // String s1 = "delete", s2 = "leet";
        String s1 = "a", s2 = "at";
        int m = s1.length(), n = s2.length();
        int w1[] = new int[m];
        int w2[] = new int[n];
        for (int i = 0; i < m; i++) {
            w1[i] = (int) s1.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            w2[i] = (int) s2.charAt(i);
        }
        pre1 = new int[m + 1];
        pre2 = new int[n + 1];
        pre1[0] = 0;
        pre2[0] = 0;
        for (int i = 1; i <= m; i++)
            pre1[i] = w1[i - 1] + pre1[i - 1];
        for (int i = 1; i <= n; i++)
            pre2[i] = w2[i - 1] + pre2[i - 1];

        System.out.println(mds(w1, w2, m, n));

        int memo[][] = new int[m + 1][n + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(mds1(w1, w2, m, n, memo));

    }
}
