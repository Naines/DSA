import java.util.ArrayList;

public class cycleDetectUndirectedDFS {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);

        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        // addEdge(adj, 5, 3);
        printlist(adj);

        System.out.println(dfs(adj, v));
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

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (vis[i] == false && dfsRec(adj, i, vis, -1)) {
                return true;
            }
        }
        return false;
    }

    static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent) {

        vis[s] = true;
        for (int next : adj.get(s)) {
            if (vis[next] == true && parent != next)
                return true;
            if (vis[next] == false && dfsRec(adj, next, vis, s))
                return true;
        }
        return false;
    }
}
