import java.util.Arrays;

public class houseRobber {
    static int rob(int n, int arr[]) {
        if (n <= 0)
            return 0;
        return Math.max(rob(n - 2, arr) + arr[n - 1], rob(n - 1, arr));
    }

    static int rob_memo(int n, int arr[], int memo[]) {
        if (n <= 0)
            return 0;
        if (memo[n] == -1) {

            return Math.max(rob_memo(n - 2, arr, memo) + arr[n - 1], rob_memo(n - 1, arr, memo));
        }
        return memo[n];
    }

    static int rob_dp(int n, int arr[]) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i == 1 ? 0 : i - 2] + arr[i - 1], dp[i - 1]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(arr.length, arr));

        int memo[] = new int[arr.length + 1];
        Arrays.fill(memo, -1);
        System.out.println(rob_memo(arr.length, arr, memo));
        System.out.println(rob_dp(arr.length, arr));

    }
}
