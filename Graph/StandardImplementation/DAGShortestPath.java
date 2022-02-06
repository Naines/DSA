package StandardImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 1-> Top Sort 2-> relax all edges by transversing throughout adj taking nodes
 * from stack obtined from topSortand relax all thier edges in bfs fashion and
 * relax all thier edges in bfs fashion 3->if node.dist==infinity then it is has
 * no incoming hence no shortest path.
 */
public class DAGShortestPath {
    static Node nodes[];
    static Stack<Node> s = new Stack<>();

    // topSort
    static void TopSort(Node nodes[]) {
        for (Node n : nodes) {
            if (!n.vis)
                dfs(n);
        }
        Collections.reverse(s);
    }

    static void dfs(Node root) {
        root.vis = true;
        for (Edge e : root.adj) {
            if (!e.t.vis) {
                e.t.vis = true;
                dfs(e.t);
            }
        }
        s.push(root);
    }

    // DAG algo
    static void dag(Node src, Node target) {
        src.dist = 0;
        // relaxing all edges
        for (Node n : nodes) {
            for (Edge e : n.adj) {
                Node u = e.s;
                Node v = e.t;
                int newdist = u.dist + e.wt;
                if (newdist < v.dist) {
                    v.dist = newdist;
                    v.pre = u;
                }
            }
        }

        if (target.dist == Integer.MAX_VALUE)
            System.out.println("No shortest path exists to the target node");
        else
            System.out.println("Target node shortest distance: " + target.dist);
    }

    static void getShortestPath(Node trgt) {
        List<Node> l = new ArrayList<>();
        Node curr = trgt;
        l.add(curr);
        while (curr.pre != null) {
            curr = curr.pre;
            l.add(curr);
        }
        Collections.reverse(l);
        System.out.println(l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i);// name of the node
        }

        // System.out.println("enter edges");
        for (int i = 0; i < e; ++i) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int wt = sc.nextInt();
            nodes[from].add(new Edge(nodes[from], wt, nodes[to]));
        }

        System.out.println("enter target");
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;

        TopSort(nodes);
        dag(nodes[a], nodes[b]);
        getShortestPath(nodes[b]);
        sc.close();
    }

    static class Node {
        boolean vis;
        int name;
        List<Edge> adj = new ArrayList<>();
        int dist = Integer.MAX_VALUE;
        Node pre;

        Node(int v) {
            name = v;
        }

        void add(Edge e) {
            adj.add(e);
        }

        public String toString() {
            return Integer.toString(this.name);
        }
    }

    static class Edge {
        int wt;
        Node s;
        Node t;

        Edge(Node s, int wt, Node t) {
            this.s = s;
            this.wt = wt;
            this.t = t;
        }
    }
}
