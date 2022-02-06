package StandardImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * ToplogicalSort
 */
public class ToplogicalSort {

    static Stack<Node> s = new Stack<>();

    /**
     * this is the dfs part of the algo Execute by the number of connected nodes in
     * a bunch overall time complexity is O(n)/ O(v+e) fails if cycle is present in
     * DAG . not if the graph is not a DAG i.e for undirected graph as u before v
     * loses its meaning.
     */
    static void dfs(Node root) {
        root.visited = true;
        for (Node n : root.list) // O(n)
        {
            if (!n.visited) {
                n.visited = true;
                dfs(n);
            }
        }
        s.push(root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Node nodes[] = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            nodes[from].add(nodes[to], false);
        }

        for (int i = 0; i < n; i++) {
            if (!nodes[i].visited)
                dfs(nodes[i]);
        }
        Collections.reverse(s);
        for (Node node : s) {
            System.out.print(node + " ");
        }
        sc.close();
    }

    static class Node {
        int val;
        boolean visited;
        List<Node> list;

        Node(int v) {
            val = v;
            list = new ArrayList<>();
        }

        void add(Node v, boolean x) {
            list.add(v);
            if (x) {
                v.list.add(this);
            }
        }

        public String toString() {
            return Integer.toString(this.val + 1);
        }
    }
}