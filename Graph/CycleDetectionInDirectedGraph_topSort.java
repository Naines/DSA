import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * CycleDetectionInDirectedGraph_topSort
 */
public class CycleDetectionInDirectedGraph_topSort {
    static void topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        // METHOD 1: BFS

        int inorder[] = inorder(adj);
        for (int i : inorder)
            System.out.print(i + " ");
        System.out.println();
        int top[] = new int[V];
        int k = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (inorder[i] == 0) {
                top[k++] = i;
                q.addLast(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.pollFirst();
            for (int next : adj.get(curr)) {
                inorder[next]--;
                if (inorder[next] == 0) {
                    q.addLast(next);
                    top[k++] = next;
                }
            }
            count++;
        }
        if (count != V) {
            System.out.println("CYCLE PRESENT IN THE GRAPH");
        } else {
            System.out.println("NO CYCLE DETECTED");
        }
    }

    static int[] inorder(ArrayList<ArrayList<Integer>> adj) {
        int inorder[] = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inorder[adj.get(i).get(j)]++;
            }
        }
        return inorder;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);
        printlist(adj);

        topoSort(v, adj);
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