import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * minTimeForJobsCompletionDAG
 */
public class minTimeForJobsCompletionDAG {

    // Similar to shortest dist..BFS used
    void find_time(ArrayList<ArrayList<Integer>> adj, int v) {
        int inorder[] = new int[v];
        int time[] = new int[v];
        Arrays.fill(time, 1);
        // make inorder
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inorder[adj.get(i).get(j)]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inorder[i] == 0) {
                q.add(i);
            }

        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj.get(curr)) {
                inorder[next]--;
                if (inorder[next] == 0) {
                    q.add(next);
                    time[next] = time[curr] + 1;
                }

            }
        }
        for (int i : time)
            System.out.print(i + " ");
        System.out.println();
    }

    // int[] topoSort(ArrayList<ArrayList<Integer>> adj, int v) {
    // int inorder[] = new int[v];
    // int top[] = new int[v];
    // int k = 0;

    // // make inorder
    // for (int i = 0; i < adj.size(); i++) {
    // for (int j = 0; j < adj.get(i).size(); j++) {
    // inorder[adj.get(i).get(j)]++;
    // }
    // }

    // Deque<Integer> q = new ArrayDeque<>();
    // for (int i = 0; i < v; i++) {
    // if (inorder[i] == 0) {
    // q.add(i);
    // top[k++] = i;
    // }

    // }
    // while (!q.isEmpty()) {
    // int curr = q.poll();
    // for (int next : adj.get(curr)) {
    // inorder[next]--;
    // if (inorder[next] == 0) {
    // q.add(next);
    // top[k++] = next;
    // }

    // }
    // }
    // return top;
    // }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 10;
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 1, 5);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 8);
        addEdge(adj, 2, 9);
        addEdge(adj, 3, 6);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 8);
        addEdge(adj, 5, 8);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 8);
        addEdge(adj, 8, 10);
        // printlist(adj);
        minTimeForJobsCompletionDAG o = new minTimeForJobsCompletionDAG();
        o.find_time(adj, v);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int a, int b) {
        adj.get(a - 1).add(b - 1);
    }

    static void printlist(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + "->");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}