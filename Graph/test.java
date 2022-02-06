import java.util.ArrayList;

public class test {
    static int solve(int A, int[][] B) {

        boolean vis[] = new boolean[A];
        boolean alive[] = new boolean[A];
        int n = B.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++)
            adj.add(new ArrayList<Integer>());
        for (int i = 0; i < n; i++) {
            adj.get(B[i][0] - 1).add(B[i][1] - 1);
        }

        for (int i = 0; i < A; i++) {
            if (vis[i] == false && dfs(adj, i, vis, alive)) {
                return 1;
            }
        }
        return 0;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int start, boolean vis[], boolean isAlive[]) {
        vis[start] = true;
        isAlive[start] = true;
        for (int next : adj.get(start)) {
            System.out.println("from " + start + " to " + next);

            if (vis[next] == false)
                return dfs(adj, next, vis, isAlive);
            if (isAlive[next])
                return true;
        }

        isAlive[start] = false;
        return false;
    }

    public static void main(String[] args) {
        int A = 5, B[][] = { { 1, 3 }, { 1, 2 }, { 2, 3 }, { 1, 4 }, { 4, 3 }, { 4, 5 }, { 3, 5 } };
        System.out.println(solve(A, B));
    }
}
