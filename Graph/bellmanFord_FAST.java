import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class bellmanFord_FAST {
    static boolean bellman(ArrayList<ArrayList<Pair>> adj, int src) {
        int n = adj.size();
        Deque<Integer> q = new ArrayDeque<Integer>();
        int dist[] = new int[n];
        int count[] = new int[n];
        boolean inqueue[] = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        q.add(src);
        inqueue[src] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            inqueue[u] = false;
            for (Pair p : adj.get(u)) {
                int v = p.f;
                int wt = p.s;
                // System.out.println(u + " " + v + " " + wt + " " + count[v]);

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    // System.out.println("UPDATED dist" + v + " " + " TO " + dist[v]);
                    if (inqueue[v] == false) {
                        q.add(v);
                        inqueue[v] = true;
                        count[v]++;
                        if (count[v] > n - 1)
                            return false;

                    }
                }
            }
        }
        System.out.println("NODE\tDIST FROM SOURCE");
        for (int i = 0; i < n; i++)
            System.out.println(i + "\t" + dist[i]);
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Pair>());
        addEdge(adj, 0, 1, -1);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 2);
        addEdge(adj, 1, 4, 2);
        addEdge(adj, 3, 2, 5);
        addEdge(adj, 3, 1, 1);
        addEdge(adj, 4, 3, -3);
        // print(adj);

        long start = System.nanoTime();
        System.out.println(bellman(adj, 0));

        long end = System.nanoTime();
        System.out.println((end - start) / 1000_000_000.0);

    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj, int from, int to, int wt) {
        adj.get(from).add(new Pair(to, wt));
    }

    static void print(ArrayList<ArrayList<Pair>> adj) {
        int n = adj.size();
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static class Pair {
        int f;
        int s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        public String toString() {
            return "<" + this.f + " " + this.s + ">";
        }
    }
}
