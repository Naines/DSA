package StandardImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Kruskal 1. sort all the edge in edgelist 2. in non decreasing order take all
 * the edge wts and make a new list depending on whether items are present in
 * same set or not. hence if in same set they form a cycle
 * 
 * NOTE: though kruskal necessarily works on undir graph but the algo is so
 * designed that it is edge based algo and hence doesnt matter whether graph is
 * defined two way or not answer remains the same. While if garph is not defined
 * two way(undirected) in prims it throws Null Pointer Exception
 */
public class Kruskal {
    static Vertex vertices[];
    static Node nodes[];
    static List<Edge> edges = new ArrayList<>();
    static int nodecount = 0;
    static int setcount = 0;

    static void makeSets(Vertex vertices[]) {
        int i = 0;// counter to initialize nodes[i]
        for (Vertex v : vertices) {

            Node n = new Node(i, vertices.length, null);
            v.node = n;
            nodes[i++] = n;
            setcount++;
            nodecount++;
        }
    }

    static int find(Node n) {
        Node curr = n;
        while (curr.parent != null)
            curr = curr.parent;
        Node root = curr;

        // primary objective to find parent achieved, now
        // path compression for future O(1) ops

        curr = n;
        while (curr != root) // assign all nodes' parent to root
        {
            Node temp = curr.parent;
            curr.parent = root;
            curr = temp;
        }
        return root.id;
    }

    static void unite(Node n1, Node n2) {
        int i1 = find(n1);
        int i2 = find(n2);
        if (i1 == i2)
            return; // i.e dont unite as it will form cycle

        // id is same as array index
        // rank is same as level of tree assigned
        Node p1 = nodes[i1];
        Node p2 = nodes[i2];

        if (p1.rank < p2.rank)
            p1.parent = p2;
        else if (p1.rank > p2.rank)
            p2.parent = p1;
        else {
            p2.parent = p1;
            p1.rank++;
        }
        setcount--;
    }

    static void spanning(Vertex vertices[], List<Edge> edges) {
        Collections.sort(edges);
        List<Edge> mst = new ArrayList<>();
        for (Edge e : edges) {
            Vertex u = e.s;
            Vertex v = e.t;
            if (find(u.node) != find(v.node)) {
                mst.add(e);
                unite(u.node, v.node);
            }
        }

        int wt = 0;
        for (Edge e : mst) {
            wt += e.wt;
            // System.out.print(e.s.name+""+e.t.name+"--");
        }
        // System.out.println("mst weight= :"+wt);
        System.out.println(wt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        vertices = new Vertex[n];
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);// is is the name of the node
        }
        makeSets(vertices);

        for (int i = 0; i < e; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int wt = sc.nextInt();
            edges.add(new Edge(wt, vertices[from], vertices[to]));
            // edges.add(new Edge(wt, vertices[to], vertices[from]));
        }

        spanning(vertices, edges);
        sc.close();
    }

    static class Edge implements Comparable<Edge> {
        int wt;
        Vertex s;
        Vertex t;

        Edge(int wt, Vertex s, Vertex t) {
            this.wt = wt;
            this.s = s;
            this.t = t;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.wt, o.wt);
        }
    }

    static class Vertex {
        int name;
        Node node;

        Vertex(int val) {
            name = val;
        }
    }

    static class Node {
        int id;
        int rank;
        Node parent;

        Node(int id, int rank, Node parent) {
            this.id = id;
            this.rank = rank;
            this.parent = parent;
        }
    }

}