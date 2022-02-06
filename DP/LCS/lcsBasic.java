import java.util.Arrays;

/**
 * lcsBasic
 */
public class lcsBasic {

    static int lcs(char s1[], char s2[], int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (s1[m - 1] == s2[n - 1])
            return 1 + lcs(s1, s2, m - 1, n - 1);
        return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    }

    // bottom up manner
    static int lcs1(char s1[], char s2[], int m, int n, int memo[][]) {

        if (memo[m][n] != -1)
            return memo[m][n];
        if (m == 0 || n == 0)
            memo[m][n] = 0;
        else if (s1[m - 1] == s2[n - 1])
            memo[m][n] = 1 + lcs1(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs1(s1, s2, m - 1, n, memo), lcs1(s1, s2, m, n - 1, memo));

        return memo[m][n];
    }

    // top-down approach
    static int lcs2(char s1[], char s2[], int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= n; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // top-down approach
    static int lcs3(char s1[], char s2[], int m, int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 0);

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s1[i - 1] == s2[j - 1])
                    dp[j] = prev + 1;
                else
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                prev = temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // String text1 = "abcde", text2 = "ace";
        // String text1 = "bsbininm", text2 = "jmjkbkjkv";
        String text1 = "bbbab", text2 = "babbb";

        int m = text1.length();
        int n = text2.length();
        System.out.println(lcs(text1.toCharArray(), text2.toCharArray(), m, n));

        // MEMOIZATION
        int memo[][] = new int[m + 1][n + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(lcs1(text1.toCharArray(), text2.toCharArray(), m, n, memo));

        System.out.println(lcs2(text1.toCharArray(), text2.toCharArray(), m, n));
        System.out.println(lcs3(text1.toCharArray(), text2.toCharArray(), m, n));
    }
}