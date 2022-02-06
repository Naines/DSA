import java.util.Arrays;

/**
 * matrix_multiplication
 */
public class matrix_multiplication {
    static int mm(int arr[], int i, int j) {
        if (i + 1 == j)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {

            int a = mm(arr, i, k);
            int b = mm(arr, k, j);
            int c = arr[i] * arr[k] * arr[j];
            res = Math.min(res, a + b + c);
        }
        return res;
    }

    static int mm1(int arr[], int i, int j, int memo[][]) {
        if (i + 1 == j)
            return memo[i][j] = 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        // System.out.println("IN AT " + i + " " + j);
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {

            memo[i][k] = mm1(arr, i, k, memo);
            memo[k][j] = mm1(arr, k, j, memo);
            int c = arr[i] * arr[k] * arr[j];
            res = Math.min(res, memo[i][k] + memo[k][j] + c);
        }
        return memo[i][j] = res;
    }

    static int mm2(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 4 };
        int n = arr.length;
        System.out.println(mm(arr, 0, n - 1));

        int memo[][] = new int[n][n];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(mm1(arr, 0, n - 1, memo));

        System.out.println(mm2(arr));
    }
}