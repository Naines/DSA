import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class kosaraju {
    public int kosaraju_(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == false)
                dfs(adj, i, vis, stk);
        }

        adj = transpose(adj);

        Arrays.fill(vis, false);

        int count = 0;
        while (stk.size() != 0) {
            int v = stk.poll();
            if (vis[v] == false) {
                dfs2(adj, v, vis);
                count++;
            }

        }
        return count;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean vis[], Deque<Integer> stk) {
        vis[i] = true;
        for (int v : adj.get(i)) {
            if (vis[v] == false) {
                dfs(adj, v, vis, stk);
            }
        }
        stk.push(i);
    }

    ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj1.add(new ArrayList<Integer>());
        for (int i = 0; i < n; i++) {
            for (int v : adj.get(i)) {
                adj1.get(v).add(i);
            }
        }
        return adj1;

    }

    void dfs2(ArrayList<ArrayList<Integer>> adj, int i, boolean vis[]) {
        vis[i] = true;
        for (int v : adj.get(i)) {
            if (vis[v] == false) {
                dfs2(adj, v, vis);
            }
        }
    }
}
