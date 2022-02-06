import java.util.Arrays;

/**
 * kruskal
 */
public class kruskal {
    static void kruskalMST(Edge edges[], int v) {
        Arrays.sort(edges);
        Edge res[] = new Edge[v - 1];
        dsu ob = new dsu(v);
        int ans = 0;

        for (int i = 0, s = 0; s != v - 1; i++) {
            Edge e = edges[i];
            int x = ob.find(e.src);
            int y = ob.find(e.dest);
            if (x != y) {
                res[s] = e;
                ob.union(x, y);
                s++;
                ans += e.wt;
            }
        }

        System.out.println(ans);
        System.out.println("EDGE\tWEIGHT");
        for (Edge e : res) {
            System.out.println(e.src + " - " + e.dest + "\t" + e.wt);
        }
    }

    public static void main(String[] args) {
        int v = 4;
        int e = 5;
        // add edge 0-1
        Edge edges[] = new Edge[e];
        edges[0] = new Edge(0, 1, 10);
        edges[1] = new Edge(0, 2, 6);
        edges[2] = new Edge(0, 3, 5);
        edges[3] = new Edge(1, 3, 15);
        edges[4] = new Edge(2, 3, 4);
        kruskalMST(edges, v);
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

    static class dsu {
        int parent[];

        dsu(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }
    }
}