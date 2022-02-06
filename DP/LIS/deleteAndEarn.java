import java.util.Arrays;

public class deleteAndEarn {
    static int de_recusrion(int n, int count[]) {

        if (n <= 0)
            return 0;

        return Math.max(de_recusrion(n - 2, count) + count[n] * n, de_recusrion(n - 1, count));
    }

    static int de_memo(int n, int count[], int memo[]) {
        if (n <= 0)
            return 0;
        if (memo[n] == -1) {
            return Math.max(de_memo(n - 2, count, memo) + count[n] * n, de_memo(n - 1, count, memo));
        }
        return memo[n];
    }

    static int de_dp(int n, int count[]) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i == 1 ? 0 : i - 2] + count[i] * i, dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int nums[] = { 3, 4, 2 };
        int max = Integer.MIN_VALUE;
        for (int i : nums)
            max = Math.max(i, max);

        int count[] = new int[max + 1];

        for (int i : nums)
            count[i]++;
        System.out.println(de_recusrion(max, count));// TLE

        int memo[] = new int[max + 1];
        Arrays.fill(memo, -1);
        System.out.println(de_memo(max, count, memo));// TLE

        System.out.println(de_dp(max, count));

    }
}
