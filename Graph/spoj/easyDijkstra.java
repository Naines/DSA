package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class easyDijkstra 
{
    static void compute(Node src)
    {
        src.dist=0;
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.add(src);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            for(Edge e: curr.adj)
            {
                Node n=e.t;
                int newdist=curr.dist+ e.wt;
                if(n.dist> newdist)
                {
                    q.remove(n);
                    n.dist=newdist;
                    n.pre=curr;
                    q.add(n);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception
    {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int tt=fs.nextInt();
        while(tt-->0)
        {
            int n = fs.nextInt();
            int e = fs.nextInt();
            Node nodes[] = new Node[n];

            for (int i = 0; i < n; i++)
                nodes[i] = new Node(i + 1); // i+1 is the name of the node

            // Note: here to and from are the index positions anf not the node names
            for (int i = 0; i < e; i++) {
                int from = fs.nextInt() - 1;
                int to = fs.nextInt() - 1;
                int wt = fs.nextInt();
                nodes[from].add(new Edge(nodes[from], wt, nodes[to]));
            }
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            compute(nodes[a]);

            if (nodes[b].pre == null)
                out.println("NO");
            else
                out.println(nodes[b].dist);
        }
        out.close();

    }
    static class Edge
    {
        Node s;
        Node t;
        int wt;
        Edge(Node s,int wt, Node t)
        {
            this.s=s;
            this.t=t;
            this.wt=wt;
        }
    }
    static class Node implements Comparable<Node>
    {
        int val;
        List<Edge> adj=new ArrayList<>();
        Node pre;
        int dist=Integer.MAX_VALUE;
        Node(int v)
        {
            val=v;
        }
        void add(Edge e)
        {
            this.adj.add(e);
        }
        public int compareTo(Node o)
        {
            return this.dist-o.dist;
        }
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    
}
