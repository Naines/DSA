public class printLCS {
    // top-down approach
    static void lcs(char s1[], char s2[], int m, int n) {
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
        int len = dp[m][n];
        char ch[] = new char[len];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1[i - 1] == s2[j - 1]) {
                ch[--len] = s1[i - 1];
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        for (char c : ch)
            System.out.print(c);
        System.out.println();
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        int m = text1.length();
        int n = text2.length();
        lcs(text1.toCharArray(), text2.toCharArray(), m, n);
    }
}
