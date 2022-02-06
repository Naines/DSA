import java.util.Arrays;

public class min_coins_coin_change {
    static int minWays(int n, int arr[], int sum) {
        if (sum == 0)
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE - 1;
        if (arr[n - 1] <= sum) {
            return Math.min(1 + minWays(n, arr, sum - arr[n - 1]), minWays(n - 1, arr, sum));
        } else {
            return minWays(n - 1, arr, sum);
        }
    }

    static int minWays0(int n, int arr[], int sum) {
        if (sum == 0)
            return 0;
        int res = Integer.MAX_VALUE - 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= sum) {
                res = Math.min(1 + minWays0(n, arr, sum - arr[i]), minWays0(n - 1, arr, sum));
            } else
                res = minWays0(n - 1, arr, sum);
        }
        return res;
    }

    static int minWays1(int n, int arr[], int sum, int memo[][]) {
        if (memo[n][sum] != -1)
            return memo[n][sum];
        if (sum == 0)
            memo[n][sum] = 0;
        else if (n == 0)
            memo[n][sum] = Integer.MAX_VALUE - 1;
        else if (arr[n - 1] <= sum) {
            memo[n][sum] = Math.min(1 + minWays1(n, arr, sum - arr[n - 1], memo), minWays1(n - 1, arr, sum, memo));
        } else {
            memo[n][sum] = minWays1(n - 1, arr, sum, memo);
        }
        return memo[n][sum];
    }

    static int minWays2(int n, int arr[], int sum) {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = Integer.MAX_VALUE - 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - arr[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];

            }
        }
        return dp[n][sum];
    }

    static int minWays3(int n, int arr[], int sum) {
        int dp[] = new int[sum + 1];
        dp[0] = 0;
        for (int i = 1; i <= sum; i++)
            dp[i] = Integer.MAX_VALUE - 1;

        for (int i = 1; i <= n; i++) {
            for (int j = arr[i - 1]; j <= sum; j++) {

                dp[j] = Math.min(1 + dp[j - arr[i - 1]], dp[j]);

            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        // int coins[] = { 1, 2, 5 }, amount = 11;// 3
        // int coins[] = { 2 }, amount = 3;// INT_MAX
        // int coins[] = { 1, 2, 3 }, amount = 6;// 2
        // int coins[] = { 1, 2, 3 }, amount = 3;// INT_MAX
        int coins[] = { 2, 5, 10, 1 }, amount = 27;// 4

        // Arrays.sort(coins);
        int n = coins.length;
        System.out.println(minWays(n, coins, amount));
        System.out.println(minWays0(n, coins, amount));

        int memo[][] = new int[n + 1][amount + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(minWays1(n, coins, amount, memo));
        System.out.println(minWays2(n, coins, amount));
        System.out.println(minWays3(n, coins, amount));
    }
}
