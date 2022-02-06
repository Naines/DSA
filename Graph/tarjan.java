import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class tarjan {
    static int time = 0;

    static void scc(ArrayList<ArrayList<Integer>> adj, int n) {
        int disc[] = new int[n];
        int low[] = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        boolean stkMember[] = new boolean[n];
        Deque<Integer> stk = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1)
                dfs(adj, i, low, disc, stkMember, stk);
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, int low[], int disc[], boolean stkMember[],
            Deque<Integer> stk) {
        disc[u] = low[u] = ++time;
        stkMember[u] = true;
        stk.addLast(u);

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                dfs(adj, v, low, disc, stkMember, stk);
                // if subtree of v might may lesser low/ connection to ancestors
                low[u] = Math.min(low[u], low[v]);
            } else if (stkMember[v] == true) {// check for backEdge-denoted by true
                // get low from ancestors
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // after checking all neighbours..if low[x]==disc[x] keep popping
        // till that point
        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = stk.pollLast();
                stkMember[w] = false;
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Graph g1 = new Graph(5);

        // g1.addEdge(1, 0);
        // g1.addEdge(0, 2);
        // g1.addEdge(2, 1);
        // g1.addEdge(0, 3);
        // g1.addEdge(3, 4);
        // System.out.println("SSC in first graph ");
        // scc(g1.adj, g1.adj.size());

        // time = 0;
        // Graph g2 = new Graph(4);
        // g2.addEdge(0, 1);
        // g2.addEdge(1, 2);
        // g2.addEdge(2, 3);
        // System.out.println("\nSSC in second graph ");
        // scc(g2.adj, g2.adj.size());

        time = 0;
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        System.out.println("\nSSC in third graph ");
        g3.printlist();
        scc(g3.adj, g3.adj.size());

        // time = 0;
        // Graph g4 = new Graph(11);
        // g4.addEdge(0, 1);
        // g4.addEdge(0, 3);
        // g4.addEdge(1, 2);
        // g4.addEdge(1, 4);
        // g4.addEdge(2, 0);
        // g4.addEdge(2, 6);
        // g4.addEdge(3, 2);
        // g4.addEdge(4, 5);
        // g4.addEdge(4, 6);
        // g4.addEdge(5, 6);
        // g4.addEdge(5, 7);
        // g4.addEdge(5, 8);
        // g4.addEdge(5, 9);
        // g4.addEdge(6, 4);
        // g4.addEdge(7, 9);
        // g4.addEdge(8, 9);
        // g4.addEdge(9, 8);
        // System.out.println("\nSSC in fourth graph ");
        // scc(g4.adj, g4.adj.size());

        // time = 0;
        // Graph g5 = new Graph(5);
        // g5.addEdge(0, 1);
        // g5.addEdge(1, 2);
        // g5.addEdge(2, 3);
        // g5.addEdge(2, 4);
        // g5.addEdge(3, 0);
        // g5.addEdge(4, 2);
        // System.out.println("\nSSC in fifth graph ");
        // scc(g5.adj, g5.adj.size());
    }

    static class Graph {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        Graph(int n) {

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<Integer>());
            }
        }

        void addEdge(int a, int b) {
            this.adj.get(a).add(b);
        }

        void printlist() {
            for (int i = 0; i < this.adj.size(); i++) {
                System.out.print(i + " -> ");
                for (int j = 0; j < this.adj.get(i).size(); j++) {
                    System.out.print(this.adj.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }

}
