import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class twoTables {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int W = fs.nextInt(), H = fs.nextInt();
            int x1 = fs.nextInt(), y1 = fs.nextInt(), x2 = fs.nextInt(), y2 = fs.nextInt();
            int w2 = fs.nextInt(), h2 = fs.nextInt();
            int w1 = x2 - x1, h1 = y2 - y1;

            boolean flag = false;
            int res = Integer.MAX_VALUE;
            if (H - h2 >= h1) {
                flag = true;
                int dist = Math.max(y1, H - y2);
                res = Math.min(res, h2 - dist);
            }
            if (W - w2 >= w1) {
                flag = true;
                int dist = Math.max(x1, W - x2);
                res = Math.min(res, w2 - dist);
            }
            res = Math.max(res, 0);
            if (flag == false)
                fs.println(-1);
            else
                fs.println(res);
        }
        fs.close();
    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    static class FastScanner extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        // standard input
        FastScanner() {
            this(System.in, System.out);
        }

        public FastScanner(InputStream i, OutputStream o) {
            super(o);
            br = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        FastScanner(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            br = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}