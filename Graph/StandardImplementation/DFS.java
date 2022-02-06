package StandardImplementation;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    static void dfs(Node nodes[]) {
        for (Node n : nodes) {
            if (!n.visited) {
                n.visited = true;
                dfsRecursion(n);
            }
        }
    }

    static void dfsRecursion(Node n) {
        System.out.println(n);
        for (Node curr : n.list) {
            if (!curr.visited) {
                curr.visited = true;
                dfsRecursion(curr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Node nodes[] = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);// i is the node value
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            nodes[from].addEdge(nodes[to], false);
        }

        // to obtain clusters(if any) also to be printed, we print the entire list

        dfs(nodes);
        sc.close();

    }

    static class Node {
        int val;
        boolean visited;
        ArrayList<Node> list;

        Node(int v) {
            val = v;
            list = new ArrayList<>();
        }

        void addEdge(Node v, boolean flag) {
            this.list.add(v);
            if (!flag) {
                v.list.add(this);
            }
        }

        public String toString() {
            return this.val + " ";
        }
    }
}
