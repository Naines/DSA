import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class longestPathDAG {
    static void findLongest(ArrayList<ArrayList<Node>> adj, int src) {
        int top[] = topSort(adj);
        int dist[] = new int[adj.size()];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;
        for (int i : top) {
            if (dist[i] == Integer.MIN_VALUE)
                continue;
            for (Node next : adj.get(i)) {
                int v = next.v;
                int w = next.wt;
                if (dist[v] < dist[i] + w) {
                    dist[v] = dist[i] + w;
                }
            }
        }
        System.out.println("VERTEX\tDISTANCE");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    static int[] topSort(ArrayList<ArrayList<Node>> adj) {
        int n = adj.size();
        int inorder[] = new int[n];
        int top[] = new int[n];
        int k = 0;
        Deque<Integer> q = new ArrayDeque<>();

        // finding inorder
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inorder[adj.get(i).get(j).v]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (inorder[i] == 0) {
                q.add(i);
                top[k++] = i;
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Node next : adj.get(u)) {
                int v = next.v;
                inorder[v]--;
                if (inorder[v] == 0) {
                    q.add(v);
                    top[k++] = v;
                }
            }
        }

        return top;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        int v = 7;
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Node>());
        addEdge(adj, 0, 1, 5);
        addEdge(adj, 0, 2, 3);
        addEdge(adj, 1, 3, 6);
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 2, 4, 4);
        addEdge(adj, 2, 5, 2);
        addEdge(adj, 2, 3, 7);
        addEdge(adj, 3, 5, 1);
        addEdge(adj, 3, 4, -1);
        addEdge(adj, 4, 5, -2);

        // src vertex: 1
        findLongest(adj, 1);
    }

    static void addEdge(ArrayList<ArrayList<Node>> adj, int a, int b, int w) {
        adj.get(a).add(new Node(b, w));
    }

    static class Node {
        int v;
        int wt;

        Node(int v, int w) {
            this.v = v;
            ;
            this.wt = w;
        }
    }

}
