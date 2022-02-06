import java.util.Arrays;

public class maxSumNoConsecutives {
    static int maxSum(int arr[], int n) {
        if (n == 1)
            return arr[0];
        if (n == 2)
            return Math.max(arr[0], arr[1]);
        return Math.max(arr[n - 1] + maxSum(arr, n - 2), maxSum(arr, n - 1));
    }

    static int maxSum1(int arr[], int n, int memo[]) {
        if (n == 1)
            return memo[0] = arr[0];
        if (n == 2)
            return Math.max(arr[0], arr[1]);
        if (memo[n] != -1)
            return memo[n];
        return memo[n] = Math.max(arr[n - 1] + maxSum1(arr, n - 2, memo), maxSum1(arr, n - 1, memo));
    }

    static int maxSum2(int arr[], int n) {
        int dp[] = new int[n + 1];
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(arr[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = { 8, 7, 6, 10 };
        System.out.println(maxSum(arr, arr.length));

        int memo[] = new int[arr.length + 1];
        Arrays.fill(memo, -1);
        System.out.println(maxSum1(arr, arr.length, memo));

        System.out.println(maxSum2(arr, arr.length));
    }
}
