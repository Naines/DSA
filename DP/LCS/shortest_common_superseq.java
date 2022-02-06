public class shortest_common_superseq {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        String superseq = lcs(str1, str2, m, n);
        return superseq;
    }

    static String lcs(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n, l = dp[m][n];
        int sq = m + n - l;
        char chs[] = new char[sq];
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                chs[sq - 1] = s1.charAt(i - 1);
                sq--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                chs[sq - 1] = s1.charAt(i - 1);
                sq--;
                i--;
            } else {
                chs[sq - 1] = s2.charAt(j - 1);
                j--;
                sq--;
            }
        }
        // copy remaining
        while (i > 0) {
            chs[sq - 1] = s1.charAt(i - 1);
            sq--;
            i--;
        }
        while (j > 0) {
            chs[sq - 1] = s2.charAt(j - 1);
            sq--;
            j--;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String a = "abcde", b = "facem";
        System.out.println(shortestCommonSupersequence(a, b));
    }
}
