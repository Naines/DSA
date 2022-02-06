import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class topSortDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // method 2: dfs,stk
        Deque<Integer> stk = new ArrayDeque<>();
        boolean vis[] = new boolean[V];
        int top[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs(adj, i, vis, stk);
            }
        }

        for (int i = 0; i < V; i++) {
            top[i] = stk.pop();
        }
        return top;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean vis[], Deque<Integer> stk) {
        vis[i] = true;
        for (int next : adj.get(i)) {
            if (vis[next] == false) {
                dfs(adj, next, vis, stk);
            }
        }
        stk.push(i);
    }
}
