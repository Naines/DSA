import java.util.Arrays;

/**
 * dice_roll_target_sum
 */
public class dice_roll_target_sum {
    final static int mod = (int) 1e9 + 7;

    static int ways(int d, int f, int sum) {
        if (sum == 0 && d == 0)
            return 1;
        if (d == 0 || sum == 0)
            return 0;

        int count = 0;
        for (int i = 1; i <= f; i++) {
            if (i <= sum) {
                count += ways(d - 1, f, sum - i);
            } else
                break;
        }
        return count;
    }

    static int ways1(int d, int f, int sum, int memo[][]) {
        if (sum == 0 && d == 0)
            return 1;
        if (d == 0 || sum == 0)
            return 0;
        if (sum < 0)
            return 0;
        if (memo[d][sum] != -1)
            return memo[d][sum];

        int count = 0;
        for (int i = 1; i <= f; i++)
            count = (count + ways1(d - 1, f, sum - i, memo)) % mod;

        return memo[d][sum] = count;
    }

    static int ways2(int d, int f, int sum) {
        int dp[][] = new int[d + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= sum; j++) {
                for (int k = 1; k <= f; k++) {
                    if (k > j)
                        break;
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                }
            }
        }
        return dp[d][sum];

    }

    public static void main(String[] args) {
        // int d = 2, f = 6, sum = 7;// 6
        int d = 30, f = 30, sum = 500;// 1
        // System.out.println(ways(d, f, sum));
        System.out.println(ways2(d, f, sum));

        int memo[][] = new int[d + 1][sum + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(ways1(d, f, sum, memo));

        // THIS CAN BE OPTIMIZED TO 1D array
    }
}