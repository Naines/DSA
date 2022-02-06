package StandardImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Dijkstra {
    static void compute(Node root) {
        root.dist = 0;
        Queue<Node> q = new PriorityQueue<>(); // gets min val among all nodes to decide which node to start from
        q.add(root);
        while (!q.isEmpty()) // O(v+elogv)
        {
            Node curr = q.poll();
            for (Edge e : curr.adj) // (O(elogn))
            {
                Node n = e.target;
                int newdist = curr.dist + e.wt;
                if (newdist < n.dist) {
                    q.remove(n); // logn
                    n.dist = newdist; // updating new distance
                    n.pre = curr; // setting precursor
                    q.add(n);
                }
            }
        }
    }

    static List<Node> getPath(Node target) {
        List<Node> s = new ArrayList<>();
        for (Node n = target; n != null; n = n.pre) {
            s.add(n);
        }
        Collections.reverse(s);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        Node nodes[] = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(i + 1);

        for (int i = 0; i < e; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int wt = sc.nextInt();

            nodes[from].add(new Edge(nodes[from], wt, nodes[to]));
        }
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        compute(nodes[a]);
        if (nodes[b].pre == null)
            System.out.println("NO PATH EXISTS");
        else
            System.out.println(nodes[b].dist);
        List<Node> s = getPath(nodes[b]);
        for (Node i : s) {
            System.out.print(i.dist + " ");
        }
        sc.close();
    }

    static class Node implements Comparable<Node> {
        int val;
        List<Edge> adj;
        Node pre;
        int dist = Integer.MAX_VALUE;

        Node(int v) {
            val = v;
            adj = new ArrayList<>();
        }

        void add(Edge e) {
            this.adj.add(e);
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }

    }

    static class Edge {
        int wt;
        Node start;
        Node target;

        Edge(Node s, int wt, Node t) {
            this.wt = wt;
            this.start = s;
            this.target = t;
        }
    }
}
