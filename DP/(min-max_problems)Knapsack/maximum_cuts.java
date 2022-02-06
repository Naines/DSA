public class maximum_cuts {
    static int maxCuts(int n, int a, int b, int c) {

        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        int res = Math.max(maxCuts(n - a, a, b, c), Math.max(maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c)));
        if (res < 0)
            return res;
        return res + 1;
    }

    static int maxCuts2(int n, int a, int b, int c) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0)
                dp[i] = Math.max(dp[i], dp[i - a]);
            if (i - b >= 0)
                dp[i] = Math.max(dp[i], dp[i - b]);
            if (i - c >= 0)
                dp[i] = Math.max(dp[i], dp[i - c]);
            if (dp[i] != -1)
                dp[i]++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // int n = 23, a = 11, b = 12, c = 13;// 2
        int n = 5, a = 5, b = 2, c = 3;// 5
        // int n = 4 , a = 1, b = 1, c = 2;// 4
        System.out.println(maxCuts(n, a, b, c));
        System.out.println(maxCuts2(n, a, b, c));
    }
}
