import java.util.Arrays;

class last_stone {
    static int minDiff(int n, int arr[], int set1, int total) {
        if (n == 0)
            return Math.abs((total - set1) - set1);
        return Math.min(minDiff(n - 1, arr, set1 + arr[n - 1], total), minDiff(n - 1, arr, set1, total));
    }

    static int minDiff1(int n, int arr[], int set1, int total, int memo[][]) {
        if (n == 0)
            return memo[n][set1] = Math.abs((total - set1) - set1);
        if (memo[n][set1] != -1)
            return memo[n][set1];
        memo[n][set1 + arr[n - 1]] = minDiff1(n - 1, arr, set1 + arr[n - 1], total, memo);
        memo[n - 1][set1] = minDiff1(n - 1, arr, set1, total, memo);
        return memo[n][set1] = Math.min(memo[n][set1 + arr[n - 1]], memo[n - 1][set1]);
    }

    static int minDiff2(int n, int arr[]) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][sum] = false;
        }
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int arr[] = { 26, 31, 33, 21, 40 };
        // , 33, 21, 40
        int n = arr.length;
        // to find minimum difference sum bw two subsets
        int sum = 0;
        for (int i : arr)
            sum += i;
        System.out.println(minDiff(n, arr, 0, sum));

        // n=0...n
        // set1= 0...sumtotal
        int memo[][] = new int[n + 1][sum + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(minDiff1(n, arr, 0, sum, memo));

        System.out.println(minDiff2(n, arr));

    }
}