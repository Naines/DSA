import java.util.Arrays;

public class delete_ops_for_two_strings {
    public int minDistance(String word1, String word2) {
        char s1[] = word1.toCharArray(), s2[] = word2.toCharArray();
        int m = s1.length, n = s2.length;
        int l = lcs(s1, s2, m, n);
        return m - l + n - l;
    }

    int lcs(char s1[], char s2[], int m, int n) {
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
}
