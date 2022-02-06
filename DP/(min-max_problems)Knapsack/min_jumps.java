import java.util.Arrays;

public class min_jumps {
    static int count(int n, int arr[]) {

        if (n == 1)
            return 0;
        int ans = Integer.MAX_VALUE - 1;
        for (int i = 1; i <= n - 1; i++) {

            if (arr[i - 1] + i >= n) {
                ans = Math.min(ans, count(i, arr) + 1);
            }
        }
        return ans;
    }

    static int count1(int n, int arr[], int memo[]) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1) {
            return memo[n] = 0;
        }
        // System.out.println("in at " + arr[n - 1]);
        memo[n] = Integer.MAX_VALUE - 1;
        for (int i = 1; i <= n - 1; i++) {

            if (arr[i - 1] + i >= n) {
                memo[n] = Math.min(memo[n], count1(i, arr, memo) + 1);
            }
        }
        // System.out.println("returning " + memo[n]);
        return memo[n];
    }

    static int count2(int n, int arr[]) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[1] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if (arr[j - 1] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];// denotes the min jumps needed to reach point n
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int arr[] = { 1, 1, 0, 1, 0, 7 };
        System.out.println(count(arr.length, arr));

        int memo[] = new int[arr.length + 1];
        Arrays.fill(memo, -1);
        System.out.println(count1(arr.length, arr, memo));
        for (int i : memo)
            System.out.print(i + " ");
        System.out.println();
        System.out.println(count2(arr.length, arr));
    }
}
