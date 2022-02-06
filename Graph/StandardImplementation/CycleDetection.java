package StandardImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleDetection {
    //// --------------DETECTING USING DFS-----------------------/////

    static void dfs(Node node) {
        node.beingvis = true;
        for (Node n : node.list) {
            if (n.beingvis) {
                System.out.println("Cycle detected due to backward edge to node" + n);
                return;
            }
            if (!n.vis) {
                n.vis = true;
                dfs(n);
            }
        }
        node.vis = true;
        node.beingvis = false;// backtarck
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Node nodes[] = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);// i will be the name of the node
        }
        for (int i = 0; i < e; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            nodes[t1].add(nodes[t2], false);
        }

        for (int i = 1; i <= n; i++) {
            if (!nodes[i].vis) {
                dfs(nodes[i]);
            }
        }
        sc.close();

    }

    static class Node {
        int val;
        boolean vis;
        boolean beingvis;
        List<Node> list;

        Node(int v) {
            val = v;
            list = new ArrayList<>();
        }

        void add(Node v, boolean flag) {
            this.list.add(v);
            if (flag) {
                v.list.add(this);
            }
        }

        public String toString() {
            return this.val + "-> ";
        }

    }
}
