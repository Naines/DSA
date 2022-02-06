import java.util.ArrayList;
import java.util.Arrays;

public class articulation_points {
    static int time = 0;

    static void AP(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean vis[] = new boolean[n];
        int low[] = new int[n];
        int disc[] = new int[n];
        int parent[] = new int[n];
        boolean ap[] = new boolean[n];

        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (vis[i] == false)
                dfs(adj, i, vis, low, disc, parent, ap);
        }

        for (int i = 0; i < n; i++)
            if (ap[i])
                System.out.print(i + " ");
        System.out.println();
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean vis[], int low[], int disc[], int parent[],
            boolean ap[]) {
        vis[u] = true;
        int kids = 0;
        low[u] = disc[u] = ++time;

        for (int v : adj.get(u)) {
            if (vis[v] == false) {
                parent[v] = u;
                kids++;
                dfs(adj, v, vis, low, disc, parent, ap);

                // check if subtree of v has lower low val than parent
                low[u] = Math.min(low[u], low[v]);
                // case 1
                if (parent[u] == -1 && kids >= 2)
                    ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;

            } else if (v != parent[u]) {
                low[u] = Math.min(low[v], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // addEdge(adj, 0, 2);
        // addEdge(adj, 2, 1);
        // addEdge(adj, 0, 3);
        // addEdge(adj, 1, 0);
        // addEdge(adj, 3, 4);

        // 0,3

        // addEdge(adj, 0, 1);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 2, 3);
        // 1,2

        // addEdge(adj, 0, 1);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 2, 0);
        // addEdge(adj, 1, 3);
        // addEdge(adj, 1, 4);
        // addEdge(adj, 1, 6);
        // addEdge(adj, 3, 5);
        // addEdge(adj, 4, 5);
        addEdge(adj, 1, 2);

        // 1
        printlist(adj);

        AP(adj, v);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int a, int b) {
        adj.get(a).add(b);
    }

    static void printlist(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
