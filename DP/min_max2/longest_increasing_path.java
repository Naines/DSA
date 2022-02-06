public class longest_increasing_path {
    static int dfs(int arr[][], int i, int j, int last) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] <= last)
            return 0;

        int ans = 0;
        ans = Math.max(ans, dfs(arr, i + 1, j, arr[i][j]) + 1);
        ans = Math.max(ans, dfs(arr, i, j + 1, arr[i][j]) + 1);
        ans = Math.max(ans, dfs(arr, i - 1, j, arr[i][j]) + 1);
        ans = Math.max(ans, dfs(arr, i, j - 1, arr[i][j]) + 1);
        return ans;
    }

    static int dfs1(int arr[][], int i, int j, int last, int memo[][]) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] <= last)
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        int ans = 0;
        ans = Math.max(ans, dfs1(arr, i + 1, j, arr[i][j], memo) + 1);
        ans = Math.max(ans, dfs1(arr, i, j + 1, arr[i][j], memo) + 1);
        ans = Math.max(ans, dfs1(arr, i - 1, j, arr[i][j], memo) + 1);
        ans = Math.max(ans, dfs1(arr, i, j - 1, arr[i][j], memo) + 1);
        return memo[i][j] = ans;
    }

    public static void main(String[] args) {
        int arr[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ans = Math.max(ans, dfs(arr, i, j, Integer.MIN_VALUE));
            }
        }
        System.out.println(ans);

        int memo[][] = new int[arr.length + 1][arr[0].length + 1];
        ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ans = Math.max(ans, dfs1(arr, i, j, Integer.MIN_VALUE, memo));
            }
        }
        System.out.println(ans);

    }

}
