import java.util.Arrays;

public class minimum_falling_path_sum {
    static int minSum(int i, int j, int arr[][]) {
        if (i == arr.length - 1)
            return arr[i][j];

        int res = Integer.MAX_VALUE;
        if (j + 1 < arr[0].length)
            res = Math.min(res, minSum(i + 1, j + 1, arr));
        if (j - 1 >= 0)
            res = Math.min(res, minSum(i + 1, j - 1, arr));
        res = Math.min(res, minSum(i + 1, j, arr));
        return res + arr[i][j];
    }

    static int minSum1(int i, int j, int arr[][], int memo[][]) {
        if (i == arr.length - 1)
            return memo[i][j] = arr[i][j];

        if (memo[i][j] != -1)
            return memo[i][j];
        int res = Integer.MAX_VALUE;
        if (j + 1 < arr[0].length)
            res = Math.min(res, minSum1(i + 1, j + 1, arr, memo));
        if (j - 1 >= 0)
            res = Math.min(res, minSum1(i + 1, j - 1, arr, memo));
        res = Math.min(res, minSum1(i + 1, j, arr, memo));
        return memo[i][j] = res + arr[i][j];
    }

    static int minSum2(int arr[][]) {
        int m = arr.length, n = arr[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                    continue;
                }
                int res = Integer.MAX_VALUE;
                if (j + 1 < n)
                    res = Math.min(res, dp[i - 1][j + 1]);
                if (j - 1 >= 0)
                    res = Math.min(res, dp[i - 1][j - 1]);
                res = Math.min(res, dp[i - 1][j]);
                dp[i][j] = res + arr[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++)
            min = Math.min(min, dp[n - 1][i]);
        return min;
    }

    public static void main(String[] args) {

        int arr[][] = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            min = Math.min(min, minSum(0, i, arr));
        }
        System.out.println(min);

        int memo[][] = new int[arr.length + 1][arr.length + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            min1 = Math.min(min1, minSum1(0, i, arr, memo));
        }
        System.out.println(min1);

        System.out.println(minSum2(arr));
    }
}
