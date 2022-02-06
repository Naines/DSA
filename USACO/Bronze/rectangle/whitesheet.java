import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class whitesheet {
    static FastScanner fs = new FastScanner();

    public static void main(String[] args) throws Exception {
        Rect a = new Rect();
        Rect b1 = new Rect();
        Rect b2 = new Rect();
        if (b1.intersect(a).union(b2.intersect(a)) < a.area())
            fs.println("YES");
        else
            fs.println("NO");
        fs.close();
    }

    static class Rect {
        long x1, y1, x2, y2;

        Rect() {
            this.x1 = fs.nextLong();
            this.y1 = fs.nextLong();
            this.x2 = fs.nextLong();
            this.y2 = fs.nextLong();

        }

        Rect(long x1, long y1, long x2, long y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        long area() {
            return ((x2 - x1) * (y2 - y1));
        }

        Rect intersect(Rect a) {
            Rect t = new Rect(Math.max(x1, a.x1), Math.max(y1, a.y1), Math.min(x2, a.x2), Math.min(y2, a.y2));
            return t.x2 >= t.x1 && t.y2 >= t.y1 ? t : new Rect(0, 0, 0, 0);
        }

        long union(Rect ob) {
            return this.area() + ob.area() - intersect(ob).area();
        }

        long intersect(Rect a, Rect b, Rect c) {
            long xOverlap = Math.max(Math.min(Math.min(a.x2, b.x2), c.x2) - Math.max(Math.max(a.x1, b.x1), c.x1), 0);
            long yOverlap = Math.max(Math.min(Math.min(a.y2, b.y2), c.y2) - Math.max(Math.max(a.y1, b.y1), c.y1), 0);
            return xOverlap * yOverlap;
        }
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