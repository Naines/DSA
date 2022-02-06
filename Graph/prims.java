import java.util.Arrays;

public class prims {
    static int minKey(int key[], boolean mset[]) {
        int u = -1;
        int n = key.length;

        // first unvis smallest key element
        for (int i = 0; i < n; i++) {
            if (mset[i] == false && (u == -1 || key[i] < key[u]))
                u = i;
        }
        return u;
    }

    static void prims_mst(int graph[][], int n) {
        boolean mset[] = new boolean[n];
        int key[] = new int[n];
        int parent[] = new int[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        int res = 0;
        key[0] = 0;
        parent[0] = -1;
        // loop runs k-1 times
        for (int k = 0; k < n; k++) {

            // find min_key
            int u = minKey(key, mset);

            // mark vis
            mset[u] = true;
            res += key[u];// included in mst

            // finding the least for all neighbour of min_Keynode
            for (int v = 0; v < n; v++) {
                if (mset[v] == false && graph[u][v] != 0 && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
            
        }
        printMST(graph, parent);
        System.out.println(res);
    }

    static void printMST(int graph[][], int parent[]) {
        System.out.println("EDGE\tWEIGHT");
        int n = parent.length;
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {

        int v = 4;
        int graph[][] = { { 0, 5, 8, 0 }, { 5, 0, 10, 15 }, { 8, 10, 0, 20 }, { 0, 15, 20, 0 } };
        prims_mst(graph, v);
    }
}
