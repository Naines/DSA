import java.util.Arrays;

public class min_cost_for_travel {
    static int minDays(int days[], int cost[], int day, int n) {
        if (day >= n)
            return 0;

        int a = cost[0] + minDays(days, cost, day + 1, n);
        int i;
        for (i = day; i < n; i++) {
            if (days[i] >= days[day] + 7)
                break;
        }
        int b = cost[1] + minDays(days, cost, i, n);
        for (i = day; i < n; i++) {
            if (days[i] >= days[day] + 30)
                break;
        }
        int c = cost[2] + minDays(days, cost, i, n);
        return Math.min(a, Math.min(b, c));
    }

    static int minDays1(int days[], int cost[], int day, int n, int memo[]) {

        if (memo[day] != -1)
            return memo[day];
        if (day == n)
            return memo[day] = 0;

        int a = cost[0] + minDays1(days, cost, day + 1, n, memo);
        int i;
        for (i = day; i < n; i++) {
            if (days[i] >= days[day] + 7)
                break;
        }
        int b = cost[1] + minDays1(days, cost, i, n, memo);
        for (i = day; i < n; i++) {
            if (days[i] >= days[day] + 30)
                break;
        }
        int c = cost[2] + minDays1(days, cost, i, n, memo);
        memo[day] = Math.min(a, Math.min(b, c));
        return memo[day];
    }

    static int minDays2(int days[], int cost[]) {
        int dp[] = new int[days.length];
        int n = days.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; i++) {

            }
        }
        return dp[days.length];
    }

    public static void main(String[] args) {
        int days[] = { 1, 4, 6, 7, 8, 20 };
        int cost[] = { 2, 7, 15 };
        int n = days.length;
        System.out.println(minDays(days, cost, 0, n));

        // MEMO
        int memo[] = new int[days.length + 1];
        Arrays.fill(memo, -1);
        System.out.println(minDays1(days, cost, 0, n, memo));
    }
}
