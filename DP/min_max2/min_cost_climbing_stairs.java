import java.util.Arrays;

public class min_cost_climbing_stairs {
    static int minCost(int n, int cost[]) {
        if (n == 0 || n == 1)
            return 0;
        return Math.min(cost[n - 1] + minCost(n - 1, cost), cost[n - 2] + minCost(n - 2, cost));
    }

    static int minCost1(int n, int cost[], int memo[]) {
        if (n == 0 || n == 1)
            return memo[n] = 0;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = Math.min(cost[n - 1] + minCost1(n - 1, cost, memo), cost[n - 2] + minCost1(n - 2, cost, memo));
        return memo[n];
    }

    static int minCost3(int cost[]) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int cost[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        // int cost[] = { 10, 15, 20 };
        int n = cost.length;
        System.out.println(minCost(n, cost));

        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(minCost1(n, cost, memo));
        for (int i : memo)
            System.out.print(i + " ");
        System.out.println();

        System.out.println(minCost3(cost));
    }
}
