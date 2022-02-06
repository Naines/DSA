package StandardImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    static void bfs(Node n) {
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        n.visited = true;
        while (!q.isEmpty()) {
            Node t = q.poll();
            System.out.println(t.val + " ");
            for (Node v : t.list) {
                if (!v.visited) {
                    v.visited = true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        System.out.println("-------------------------BFS demonstration------------------");
        int n = 8;
        int e = 7;
        Node nodes[] = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);// i would be the value of the node
        }
        for (int i = 0; i < e; i++) {
            int from = fs.nextInt();
            int to = fs.nextInt();
            nodes[from].add(nodes[to], false);
        }
        int root = 1;
        bfs(nodes[root]);
        fs.close();
    }

    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
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
    }
}