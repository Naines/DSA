import java.util.Arrays;

public class distinct_subsequences {
    static int ds(char s1[], char s2[], int m, int n) {
        // if (n == 0)
        // return 1;
        // if (m == 0)
        // return 0;
        if (m <= 0)
            return n <= 0 ? 1 : 0;
        if (s1[m - 1] == s2[n - 1])
            return ds(s1, s2, m - 1, n - 1) + ds(s1, s2, m - 1, n);
        else
            return ds(s1, s2, m - 1, n);
    }

    static int ds1(char s1[], char s2[], int m, int n, int memo[][]) {
        if (memo[m][n] != -1)
            return memo[m][n];
        if (n == 0)
            memo[m][n] = 1;
        else if (m == 0)
            memo[m][n] = 0;
        else if (s1[m - 1] == s2[n - 1])
            memo[m][n] = ds1(s1, s2, m - 1, n - 1, memo) + ds1(s1, s2, m - 1, n, memo);
        else
            memo[m][n] = ds1(s1, s2, m - 1, n, memo);
        return memo[m][n];
    }

    static int ds3(char s1[], char s2[], int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;
        for (int j = 0; j <= m; j++)
            dp[j][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        // String s1 = "babgbag", s2 = "bag";
        String s1 = "aab", s2 = "ab";

        char a[] = s1.toCharArray(), b[] = s2.toCharArray();
        // System.out.println(ds(a, b, a.length, b.length));

        int m = a.length, n = b.length;
        int memo[][] = new int[m + 1][n + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);

        System.out.println(ds1(a, b, a.length, b.length, memo));
        System.out.println(ds3(a, b, a.length, b.length));
    }

}
