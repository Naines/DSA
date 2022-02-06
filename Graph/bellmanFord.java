import java.util.Arrays;

public class bellmanFord {

    static Edge edges[];

    static void bellman(int n, int e, int src) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < e; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int wt = edges[j].wt;
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + wt)
                    dist[v] = dist[u] + wt;
            }
        }
        for (int j = 0; j < e; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int wt = edges[j].wt;
            if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + wt) {
                System.out.println("NEGATIVE EDGE WEIGHT CYCLE DETECTED!");
                return;
            }
        }
        System.out.println("NODE\tDIST FROM SOURCE");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int e = 8, n = 5;
        edges = new Edge[e];

        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        long start = System.nanoTime();
        bellman(n, e, 0);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000_000_000.0);

    }

    static class Edge implements Comparable<Edge> {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }

        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }
}
