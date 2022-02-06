import java.util.Arrays;

/**
 * optimalStrategyGame
 */
public class optimalStrategyGame {
    static int maxSum(int arr[], int i, int j) {
        if (i + 1 == j)
            return Math.max(arr[i], arr[j]);

        return Math.max(arr[i] + Math.min(maxSum(arr, i + 2, j), maxSum(arr, i + 1, j - 1)),
                arr[j] + Math.min(maxSum(arr, i + 1, j - 1), maxSum(arr, i, j - 2)));
    }

    static int maxSum1(int arr[], int i, int j, int memo[][]) {
        if (i + 1 == j)
            return memo[i][j] = Math.max(arr[i], arr[j]);
        if (memo[i][j] != -1)
            return memo[i][j];
        return memo[i][j] = Math.max(arr[i] + Math.min(maxSum1(arr, i + 2, j, memo), maxSum1(arr, i + 1, j - 1, memo)),
                arr[j] + Math.min(maxSum1(arr, i + 1, j - 1, memo), maxSum1(arr, i, j - 2, memo)));
    }

    static int maxSum3(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }
        for (int gap = 3; gap < n; gap += 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 20, 5, 4, 6 };
        System.out.println(maxSum(arr, 0, arr.length - 1));
        int memo[][] = new int[arr.length][arr.length];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(maxSum1(arr, 0, arr.length - 1, memo));

        System.out.println(maxSum3(arr));
    }
}