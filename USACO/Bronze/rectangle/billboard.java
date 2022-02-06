import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class billboard {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner("billboard");
        int b1 = fs.nextInt() + 1000, b2 = fs.nextInt() + 1000, b3 = fs.nextInt() + 1000, b4 = fs.nextInt() + 1000;
        int c1 = fs.nextInt() + 1000, c2 = fs.nextInt() + 1000, c3 = fs.nextInt() + 1000, c4 = fs.nextInt() + 1000;
        int t1 = fs.nextInt() + 1000, t2 = fs.nextInt() + 1000, t3 = fs.nextInt() + 1000, t4 = fs.nextInt() + 1000;

        int a1 = 0, a2 = 0;
        int x1 = b3 - b1, x2 = c3 - c1, y1 = b4 - b2, y2 = c4 - c2;

        // fs.println(ux1 + " " + ux2 + " " + uy1 + " " + uy2);
        // intersection-x
        int ix1 = find(b1, b3, t1, t3);
        int ix2 = find(c1, c3, t1, t3);
        // intersection-y
        int iy1 = find(b2, b4, t2, t4);
        int iy2 = find(c2, c4, t2, t4);

        // fs.println(ix1 + " " + ix2 + " " + iy1 + " " + iy2);

        a1 = x1 * (y1 - iy1) + (x1 - ix1) * (iy1);
        a2 = (y2 - iy2) * x2 + (iy2) * (x2 - ix2);
        fs.println(a1 + a2);
        fs.close();
    }

    static int find(int a, int b, int c, int d) {
        return Math.max(Math.min(b, d) - Math.max(a, c), 0);
    }
    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    // static FastScanner fs;
    // static {
    // // fs = new FastScanner();
    // try {
    // fs = new FastScanner("problemname");
    // } catch (IOException e) {
    // }
    // }

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