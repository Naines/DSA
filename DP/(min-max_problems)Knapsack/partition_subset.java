public class partition_subset {
    static boolean subset(int n, int arr[], int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        if (arr[n - 1] <= sum)
            return subset(n - 1, arr, sum - arr[n - 1]) || subset(n - 1, arr, sum);
        else
            return subset(n - 1, arr, sum);
    }

    static boolean subset1(int n, int arr[], int sum) {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 5, 11, 5 };
        int arr[] = { 478, 757, 314, 471, 729, 100, 459, 618 };
        int n = arr.length;
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 != 0)
            System.out.println(false);
        else
            System.out.println(subset(n, arr, sum / 2));

        if (sum % 2 != 0)
            System.out.println(false);
        else
            System.out.println(subset1(n, arr, sum / 2));
    }
}
