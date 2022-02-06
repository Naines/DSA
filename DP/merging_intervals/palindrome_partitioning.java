import java.util.Arrays;

public class palindrome_partitioning {
    static int pp(char chs[], int i, int j) {
        if (isPalin(chs, i, j))
            return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            res = Math.min(res, 1 + pp(chs, i, k) + pp(chs, k + 1, j));
        }
        return res;
    }

    static int pp1(char chs[], int i, int j, int memo[][]) {
        if (isPalin(chs, i, j))
            return memo[i][j] = 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            res = Math.min(res, 1 + pp1(chs, i, k, memo) + pp1(chs, k + 1, j, memo));
        }
        return res;
    }

    static int pp2(char chs[], int n) {
        int dp[][] = new int[n][n];
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (isPalin(chs, i, j))
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + 1);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    static int pp3(char chs[], int n) {
        int dp[][] = new int[n][n];
        boolean isPalin[][] = new boolean[n][n];
        for (int i = 0; i < n; i++)
            isPalin[i][i] = true;
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (chs[i] == chs[j] && (isPalin[i + 1][j - 1] || gap == 1)) {
                    dp[i][j] = 0;
                    isPalin[i][j] = true;
                } else {
                    isPalin[i][j] = false;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + 1);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "geek";
        char chs[] = str.toCharArray();
        System.out.println(pp(chs, 0, chs.length - 1));

        int n = str.length();
        int memo[][] = new int[n][n];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(pp1(chs, 0, n - 1, memo));

        System.out.println(pp2(chs, n));
        System.out.println(pp3(chs, n));
    }

    static boolean isPalin(char chs[], int i, int j) {
        while (i <= j) {
            if (chs[i] != chs[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
