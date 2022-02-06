package StandardImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Prims //used in case of dense graph // vertex based...type of dijkstra //sort
 * edges and take e.t only if e.t dont form cycle works only on undirected graph
 */
public class Prims {
    static List<Node> unvis = new ArrayList<>(); // array of nodes unvisited helps to find cycle
    static List<Edge> mst = new ArrayList<>();
    static PriorityQueue<Edge> q = new PriorityQueue<>();
    static int cost = 0;

    static void prims(Node node) {
        unvis.remove(node);
        while (!unvis.isEmpty()) {
            for (Edge e : node.adj) {
                // unvis contains target i.e, next node, going to it is safe
                // else reject the edge as it forms cycle
                if (unvis.contains(e.t)) {
                    q.add(e);
                }
            }
            // to this point node visited and edges added now hop to next target by finding
            // suitable edge
            Edge min = q.poll();
            mst.add(min);

            // visit target
            node = min.t;
            unvis.remove(node);
            cost += min.wt;
        }
    }

    static void getpath() {
        for (Edge e : mst) {
            System.out.print(e.s + "" + e.t + "-->");
        }
        System.out.print("\nTotal cost = " + cost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), e = sc.nextInt();
        Node nodes[] = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            unvis.add(nodes[i]);
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int wt = sc.nextInt();
            nodes[from].add(new Edge(wt, nodes[from], nodes[to]), false);
        }
        int root = 0;
        prims(nodes[root]);
        getpath();
        sc.close();

    }

    static class Edge implements Comparable<Edge> {
        int wt;
        Node s;
        Node t;

        public Edge(int wt, Node s, Node t) {
            this.wt = wt;
            this.s = s;
            this.t = t;
        }

        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    static class Node {
        int name;
        List<Edge> adj = new ArrayList<>();

        Node(int val) {
            name = val;
        }

        void add(Edge e, boolean flag) {
            this.adj.add(e);
            if (flag) {
                e.t.adj.add(new Edge(e.wt, e.t, e.s));
            }
        }

        public String toString() {
            return Integer.toString(this.name);
        }
    }
}