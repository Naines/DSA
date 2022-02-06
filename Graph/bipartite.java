import java.util.ArrayList;
import java.util.Arrays;

class bipartite {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(adj, i, color, 1))
                    return false;
            }
        }
        return true;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, int color[], int nextColor) {
        color[s] = nextColor ^ 0 ^ 1;

        System.out.println("IN at" + s + " colored to " + color[s]);

        for (int next : adj.get(s)) {
            System.out.println("IN at" + s + " to " + next + " " + nextColor);
            if (color[next] == -1) {
                if (dfs(adj, next, color, color[s]))
                    return true;
            } else if (color[next] != -1 && color[next] != nextColor) {
                return true;
            }

        }
        return false;
    }

    /**
     * 4 4 0 2 0 3 1 3 2 3
     */
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);

        // [[1,3],[0,2],[1,3],[0,2]]
        // addEdge(adj, 0, 1);
        // addEdge(adj, 0, 3);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 2, 3);
        printlist(adj);

        bipartite ob = new bipartite();
        System.out.println(ob.isBipartite(v, adj));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int a, int b) {
        adj.get(a).add(b);
        adj.get(b).add(a);
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