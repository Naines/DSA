import java.util.Arrays;

public class editDistance {
    static int ed(char s1[], char s2[], int m, int n) {

        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (s1[m - 1] == s2[n - 1])
            return ed(s1, s2, m - 1, n - 1);
        return 1 + Math.min(ed(s1, s2, m, n - 1), Math.min(ed(s1, s2, m - 1, n), ed(s1, s2, m - 1, n - 1)));
    }

    static int ed1(char s1[], char s2[], int m, int n, int memo[][]) {
        if (memo[m][n] != -1)
            return memo[m][n];
        if (m == 0)
            memo[m][n] = n;
        else if (n == 0)
            memo[m][n] = m;
        else if (s1[m - 1] == s2[n - 1])
            memo[m][n] = ed1(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = 1 + Math.min(ed1(s1, s2, m, n - 1, memo),
                    Math.min(ed1(s1, s2, m - 1, n, memo), ed1(s1, s2, m - 1, n - 1, memo)));
        return memo[m][n];
    }

    static int ed2(char s1[], char s2[], int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        char s1[] = word1.toCharArray(), s2[] = word2.toCharArray();
        System.out.println(ed(s1, s2, s1.length, s2.length));

        // MEMOIZATION
        int memo[][] = new int[s1.length + 1][s2.length + 1];
        for (int i[] : memo) {
            Arrays.fill(i, -1);
        }
        System.out.println(ed1(s1, s2, s1.length, s2.length, memo));

        System.out.println(ed2(s1, s2, s1.length, s2.length));
    }
}
