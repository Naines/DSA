public class knapsack_0_1 {
    static int kp(int n, int arr[], int cost[], int W) {
        if (W == 0 || n == 0)
            return 0;
        if (arr[n - 1] <= W)
            return Math.max(cost[n - 1] + kp(n - 1, arr, cost, W - arr[n - 1]), kp(n - 1, arr, cost, W));
        else
            return kp(n - 1, arr, cost, W);
    }

    static int kp_dp(int n, int arr[], int cost[], int W) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1]] + cost[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int cost[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int n = wt.length;
        int W = 50;
        System.out.println(kp(n, wt, cost, W));
        System.out.println(kp_dp(n, wt, cost, W));
    }
}
