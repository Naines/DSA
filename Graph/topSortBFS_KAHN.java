import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class topSortBFS_KAHN {

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        // METHOD 1: BFS

        int inorder[] = inorder(adj);
        int top[] = new int[V];
        int k = 0;
        Deque<Integer> q = new ArrayDeque<>();

        // adding all nodes with inorder 0
        for (int i = 0; i < V; i++) {
            if (inorder[i] == 0) {
                top[k++] = i;
                q.addLast(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.pollFirst();
            for (int next : adj.get(curr)) {
                inorder[next]--;
                if (inorder[next] == 0) {
                    q.addLast(next);
                    top[k++] = next;
                }
            }
        }
        return top;
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

}
