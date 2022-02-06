import java.util.Arrays;

/**
 * coin_change
 */
public class coin_change_ways {
    static int count(int arr[], int n, int sum) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        if (arr[n - 1] <= sum) {
            return count(arr, n, sum - arr[n - 1]) + count(arr, n - 1, sum);
        } else {
            return count(arr, n - 1, sum);
        }
    }

    static int count1(int n, int arr[], int sum, int memo[][]) {
        if (memo[n][sum] != -1)
            return memo[n][sum];

        if (sum == 0)
            memo[n][sum] = 1;
        else if (n == 0)
            memo[n][sum] = 0;
        else if (arr[n - 1] <= sum)
            memo[n][sum] = count1(n, arr, sum - arr[n - 1], memo) + count1(n - 1, arr, sum, memo);
        else
            memo[n][sum] = count1(n - 1, arr, sum, memo);
        return memo[n][sum];

    }

    static int count2(int n, int arr[], int sum) {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 1; i <= sum; i++)
            dp[0][i] = 0;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    public static int count3(int sum, int[] arr) {
        int n = arr.length;
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = arr[i - 1]; j <= sum; j++) {
                dp[j] += dp[j - arr[i - 1]];

            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int coins[] = { 3, 1, 2 }, sum = 4;// 4
        // int coins[] = { 2, 3, 5, 6 }, sum = 10;// 5
        // int coins[] = {}, sum = 0; // 1
        // System.out.println(count(coins, coins.length, sum));

        // MEMO
        int memo[][] = new int[coins.length + 1][sum + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(count1(coins.length, coins, sum, memo));

        System.out.println(count2(coins.length, coins, sum));
        System.out.println(count3(sum, coins));

    }
}