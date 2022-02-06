import java.util.LinkedList;
import java.util.Queue;

public class numberProvince {
    static int solve(int adj[][]) {
        int n = adj.length;
        boolean vis[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                bfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }

    static void bfs(int u, int adj[][], boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vis[u] = true;
        while (q.size() > 0) {
            int temp = q.poll();
            for (int i = 0; i < adj.length; i++) {
                if (adj[temp][i] == 1 && vis[i] == false) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // [[1,1,0],[1,1,0],[0,0,1]]
        int adj[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(solve(adj));
    }
}
