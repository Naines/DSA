import java.util.Arrays;

public class comb_sum_types {
    static int ways(int arr[], int sum) {
        if (sum == 0)
            return 1;
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (sum >= arr[i])
                count += ways(arr, sum - arr[i]);
        return count;
    }

    static int ways1(int arr[], int sum, int memo[]) {
        if (memo[sum] != -1)
            return memo[sum];
        if (sum == 0)
            return memo[sum] = 1;
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (sum >= arr[i])
                count += ways1(arr, sum - arr[i], memo);
        memo[sum] = count;
        return memo[sum];
    }

    static int ways2(int arr[], int sum) {
        int n = arr.length;
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= arr[j]) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 }, sum = 4;
        System.out.println(ways(arr, sum));

        int memo[] = new int[sum + 1];
        Arrays.fill(memo, -1);
        System.out.println(ways1(arr, sum, memo));
        System.out.println(ways2(arr, sum));
    }
}
