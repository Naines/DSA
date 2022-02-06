class min_path_sum {

    static int dfs(int m, int n, int mat[][], int i, int j) {

        if (i == m - 1 && j == n - 1)
            return mat[m - 1][n - 1];

        int left = 1000_000_000, right = 1000_000_000;

        if (j + 1 < n)
            left = dfs(m, n, mat, i, j + 1);
        if (i + 1 < m)
            right = dfs(m, n, mat, i + 1, j);
        return Math.min(left, right) + mat[i][j];
    }

    static int dfs1(int m, int n, int mat[][], int i, int j, int memo[][]) {

        if (i == m - 1 && j == n - 1)
            return mat[m - 1][n - 1];

        if (memo[i][j] != 0)
            return memo[i][j];

        int left = 1000_000_000, right = 1000_000_000;

        if (j + 1 < n)
            left = dfs1(m, n, mat, i, j + 1, memo);
        if (i + 1 < m)
            right = dfs1(m, n, mat, i + 1, j, memo);
        return memo[i][j] = Math.min(left, right) + mat[i][j];
    }

    public static void main(String[] args) {
        // int mat[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        int m = mat.length, n = mat[0].length;

        System.out.println(dfs(m, n, mat, 0, 0));

        int memo[][] = new int[m + 1][n + 1];
        System.out.println(dfs1(m, n, mat, 0, 0, memo));
    }

}