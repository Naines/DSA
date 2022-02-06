import java.util.Arrays;

public class min_path_sum2 {

    // this reduces reqd number of parameter
    static int dfs(int mat[][], int i, int j) {
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
        else if (i == 0 && j == 0)
            return mat[i][j];

        return mat[i][j] + Math.min(dfs(mat, i - 1, j), dfs(mat, i, j - 1));
    }

    static int dfs1(int mat[][], int i, int j, int memo[][]) {
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        else if (i == 0 && j == 0)
            return mat[0][0];
        if (memo[i][j] != -1)
            return memo[i][j];
        return memo[i][j] = mat[i][j] + Math.min(dfs1(mat, i - 1, j, memo), dfs1(mat, i, j - 1, memo));
    }

    static int dfs2(int mat[][]) {
        int m = mat.length, n = mat[0].length;
        int dp[][] = new int[m + 1][n + 1];

        dp[1][1] = mat[1][1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++)
            dp[0][j] = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int res = Math.min(dp[i - 1][j], dp[i][j - 1]);
                if (res == Integer.MAX_VALUE)
                    dp[i][j] = mat[i - 1][j - 1];
                else
                    dp[i][j] = mat[i - 1][j - 1] + res;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        // int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        int m = mat.length, n = mat[0].length;

        System.out.println(dfs(mat, m - 1, n - 1));

        int memo[][] = new int[m + 1][n + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(dfs1(mat, m - 1, n - 1, memo));
        System.out.println(dfs2(mat));
    }
}
