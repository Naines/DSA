import java.util.Arrays;

public class triangle {

    // 2 dir= down // right
    static int dfs(int i, int j, int triangle[][]) {
        // Out of bounds so just return sum previous value must be leaf node
        if (i + 1 >= triangle.length)
            return triangle[i][j];

        return triangle[i][j] + Math.min(dfs(i + 1, j, triangle), dfs(i + 1, j + 1, triangle));
    }

    static int dfs2(int i, int j, int arr[][], int memo[][]) {
        if (arr.length <= i + 1)
            return arr[i][j];

        if (memo[i][j] != -1)
            return memo[i][j];

        memo[i][j] = arr[i][j] + Math.min(dfs2(i + 1, j, arr, memo), dfs2(i + 1, j + 1, arr, memo));
        return memo[i][j];
    }

    static int dfs3(int arr[][], int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < n; i++)
            dp[m - 1][i] = arr[m - 1][i];

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int arr[][] = { { 1 }, { 2, 3 }, { 5, 4, 7 }, { 4, 1, 7, 9 } };

        System.out.println(dfs(0, 0, arr));

        int memo[][] = new int[arr.length][arr.length];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        System.out.println(dfs2(0, 0, arr, memo));

        System.out.println(dfs3(arr, arr.length, arr.length));

    }
}
