import java.util.Arrays;

public class dijsktra {
    static void dijkstra(int graph[][], int n, int src) {
        int dist[] = new int[n];

        // finalized distance
        boolean fin[] = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        for (int k = 0; k < n - 1; k++) {

            int u = -1;
            for (int i = 0; i < n; i++) {
                if (fin[i] == false && (u == -1 || dist[i] < dist[u]))
                    u = i;
            }

            // System.out.println("Min" + u);

            // mark final
            fin[u] = true;

            // relax neighbours
            for (int v = 0; v < n; v++) {
                if (fin[v] == false && graph[u][v] != 0)
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
            }

        }
        printDist(dist, src);
    }

    static void printDist(int dist[], int src) {
        System.out.println("MIN DISTANCE FROM " + src);
        System.out.println("VERTEX\tDISTANCE");
        for (int i = 0; i < dist.length; i++) {
            if (i == src)
                continue;
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        // int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0,
        // 0, 0, 11, 0 },
        // { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9,
        // 0, 10, 0, 0, 0 },
        // { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0,
        // 0, 0, 0, 1, 0, 7 },
        // { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        int graph[][] = { { 0, 5, 10, 0 }, { 5, 0, 3, 20 }, { 10, 3, 0, 2 }, { 0, 20, 2, 0 } };

        int n = graph.length;
        dijkstra(graph, n, 1);
    }
}
