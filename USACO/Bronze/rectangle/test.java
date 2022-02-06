import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class test {

    static int solve(int a[], int n) {
        Vector<Integer> ar = new Vector<>();
        for (int i : a)
            ar.add(i);

        // Smallest element in the array
        int small = Collections.min(ar);

        // Largest element in the array
        int large = Collections.max(ar);

        int[][] dp = new int[n][large + 1];

        // Fill the dp[]][ array for base cases
        for (int j = small; j <= large; j++) {
            dp[0][j] = Math.abs(ar.get(0) - j);
        }

        /*
         * Using results for the first (i - 1) elements, calculate the result for the
         * ith element
         */
        for (int i = 1; i < n; i++) {
            int minimum = Integer.MAX_VALUE;
            for (int j = small; j <= large; j++) {

                /*
                 * If the ith element is j then we can have any value from small to j for the
                 * i-1 th element We choose the one that requires the minimum operations
                 */
                minimum = Math.min(minimum, dp[i - 1][j]);
                dp[i][j] = minimum + Math.abs(ar.get(i) - j);
            }
        }

        /*
         * If we made the (n - 1)th element equal to j we required dp(n-1, j) operations
         * We choose the minimum among all possible dp(n-1, j) where j goes from small
         * to large
         */
        int ans = Integer.MAX_VALUE;
        for (int j = small; j <= large; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solve(arr, n));
        in.close();
    }
}