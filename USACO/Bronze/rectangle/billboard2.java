import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class billboard2 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner("rectangle/asdf");
        // FastScanner fs = new FastScanner();
        int b1[] = fs.readArray(4);
        int b2[] = fs.readArray(4);

        int count = 0;
        if (covered(b1[0], b1[1], b2[0], b2[1], b2[2], b2[3]))
            count++;
        if (covered(b1[2], b1[1], b2[0], b2[1], b2[2], b2[3]))
            count++;
        if (covered(b1[0], b1[3], b2[0], b2[1], b2[2], b2[3]))
            count++;
        if (covered(b1[2], b1[3], b2[0], b2[1], b2[2], b2[3]))
            count++;

        fs.println("count= " + count);
        int ans = 0;
        if (count < 2) {
            ans = (b1[2] - b1[0]) * (b1[3] - b1[1]);
        } else if (count == 4) {
            ans = 0;
        } else {

            int xl = Math.max(b1[0], b2[0]);
            int xr = Math.min(b1[2], b2[2]);
            int yl = Math.max(b1[1], b2[1]);
            int yr = Math.min(b1[3], b2[3]);

            // int xl = Math.max(x1, x3);
            // int xr = Math.min(x2, x4);
            // int yl = Math.max(y1, y3);
            // int yr = Math.min(y2, y4);

            // subtract away the area of the intersection
            ans = (b1[2] - b1[0]) * (b1[3] - b1[1]) - (xr - xl) * (yr - yl);
            // fs.println((xr - xl) + " " + (yr - yl));
        }

        fs.println(ans);

        fs.close();
    }

    static int find(int a, int b, int c, int d) {
        return Math.max(Math.min(a, d) - Math.max(a, c), 0);
    }

    static boolean covered(int x, int y, int x1, int y1, int x2, int y2) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
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
                a[i] = nextInt() + 1000;
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