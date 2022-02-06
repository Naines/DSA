import java.util.Arrays;

/**
 * friend_pairing
 */
public class friend_pairing {
    static int m = (int) 1e9 + 7;

    static int ways(int n) {
        if (n <= 2)
            return n;
        return ways(n - 1) + (n - 1) * ways(n - 2);
    }

    static long ways1(int n, long memo[]) {
        if (n <= 2)
            return n;
        if (memo[n] != -1)
            return memo[n];

        long a = ways1(n - 1, memo) % m;
        long b = mul(n - 1, ways1(n - 2, memo));
        memo[n] = add(a, b);
        return memo[n];
    }

    static long dp[] = new long[1000_000];

    static long ways3(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = add(dp[i - 1], mul((i - 1), dp[i - 2]));
        }
        return dp[n];
    }

    static long add(long a, long b) {
        return (a + b) % m;
    }

    static long mul(long a, long b) {
        return (a % m * b % m) % m;
    }

    public static void main(String[] args) {
        int n = 10000;
        // System.out.println(ways(n));

        long memo[] = new long[n + 1];
        Arrays.fill(memo, -1);
        // System.out.println(ways1(n, memo));
        System.out.println(ways3(n));

    }
}