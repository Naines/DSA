import java.util.Arrays;

public class longest_palindromic_subsequence {
    public int longestPalindromeSubseq(String s) {
        StringBuffer rev = new StringBuffer(s);
        char s1[] = s.toCharArray();
        char s2[] = rev.reverse().toString().toCharArray();

        return lcs(s1, s2, s1.length);
    }

    int lcs(char s1[], char s2[], int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 0);

        for (int i = 1; i <= n; i++) {
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
