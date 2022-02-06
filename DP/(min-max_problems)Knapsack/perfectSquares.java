import java.util.Arrays;

public class perfectSquares {
    static int count(int n) {
        if (n <= 3)
            return n;
        int min = n;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(count(n - i * i), min);
        }
        return min + 1;
    }

    static int count1(int n, int memo[]) {
        if (memo[n] != -1)
            return memo[n];
        if (n <= 3)
            return memo[n] = n;
        int min = n;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(count1(n - i * i, memo), min);
        }
        memo[n] = min + 1;
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 13;
        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(count1(n, memo));
    }
}