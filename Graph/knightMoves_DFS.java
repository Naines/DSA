public class knightMoves_DFS {
    static int ans;

    // Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        ans = Integer.MAX_VALUE;
        int i = KnightPos[0], j = KnightPos[1], ti = TargetPos[0], tj = TargetPos[1];
        boolean vis[][] = new boolean[N + 1][N + 1];
        dfs(i, j, ti, tj, N, vis, 0);
        return ans;
    }

    int dirs[][] = { { 1, 2 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 2, -1 } };

    void dfs(int i, int j, int ti, int tj, int n, boolean vis[][], int count) {

        if (i == ti && j == tj) {
            ans = Math.min(count, ans);
            return;
        }
        vis[i][j] = true;
        // System.out.println("IN AT " + i + " " + j + " " + count);
        for (int dir[] : dirs) {
            int ci = i + dir[0];
            int cj = j + dir[1];
            if (ci >= 1 && cj >= 1 && ci <= n && cj <= n && vis[ci][cj] == false) {
                dfs(ci, cj, ti, tj, n, vis, count + 1);
            }
        }
        vis[i][j] = false;

    }

    boolean isLegal(int x, int y, boolean vis[][], int n) {
        return x >= 1 && y >= 1 && x <= n && y <= n && vis[x][y] == false;
    }

    public static void main(String[] args) {
        int arr1[] = { 4, 5 };
        int arr2[] = { 1, 1 };
        int n = 6;
        knightMoves_DFS ob = new knightMoves_DFS();
        System.out.println(ob.minStepToReachTarget(arr1, arr2, n));

    }
}
