package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//relax nodes for v-1 times
//check for -ve cycle in vth time
public class BellmanFord {
    static Node nodes[];
    static List<Edge> EdgeList;

    static void compute(Node src) // O(n*e)
    {
        src.dist = 0;
        for (int i = 0; i < nodes.length - 1; i++) // n-1 times for n nodes //O(n-1)
        {
            for (Edge e : EdgeList) // O(e)
            {
                Node u = e.s;
                Node v = e.t;

                if (u.dist == Integer.MAX_VALUE)
                    continue;

                int newdist = u.dist + e.wt;
                if (newdist < v.dist) {
                    v.dist = newdist;
                    v.pre = u;
                }
            }
        }

        // now checking for the vth time for negative cycle
        for (Edge e : EdgeList) {
            if (e.s.dist != Integer.MAX_VALUE) {
                if (e.s.dist + e.wt < e.t.dist) {
                    System.out.println("Negative Cycle found");
                    return;
                }
            }
        }
    }

    static void getpath(Node t) {
        if (t == null)
            return;

        getpath(t.pre);
        System.out.print((t.name + 1) + "->");
    }

    // static void print(Node nodes[])
    // {
    // for(Node i: nodes)
    // {
    // System.out.print((i.name+1)+" ");
    // if(i.pre != null)
    // System.out.print((i.pre.name+1)+" ");
    // else System.out.print(" ");
    // System.out.print(i.dist);
    // System.out.println();
    // }
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        nodes = new Node[n];
        EdgeList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i);// name of the node
        }

        // System.out.println("enter edges");
        for (int i = 0; i < e; ++i) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int wt = sc.nextInt();
            EdgeList.add(new Edge(wt, nodes[from], nodes[to]));
        }

        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        compute(nodes[a]);
        getpath(nodes[b]);

        sc.close();
    }

    static class Node {
        int name;
        List<Edge> adj = new ArrayList<>();
        int dist = Integer.MAX_VALUE;
        Node pre;

        public Node(int val) {
            name = val;
        }

        void add(Edge e) {
            this.adj.add(e);
        }
    }

    static class Edge {
        int wt;
        Node s;
        Node t;

        public Edge(int wt, BellmanFord.Node s, BellmanFord.Node t) {
            this.wt = wt;
            this.s = s;
            this.t = t;
        }

    }

}
