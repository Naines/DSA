import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Teleportation {

    public static void main(String[] args) throws Exception {
        // FastScanner fs = new FastScanner();
        int a = fs.nextInt();
        int b = fs.nextInt();

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int x = fs.nextInt();
        int y = fs.nextInt();
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        // travel without teleporter
        int d1 = Math.abs(b - a);

        // travel with teleporter
        int d2 = Math.abs(a - x) + Math.abs(b - y);

        int ans = Math.min(d1, d2);
        fs.println(ans);
        fs.close();
    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    static FastScanner fs;
    static {
        // fs = new FastScanner();
        try {
            fs = new FastScanner("teleport");
        } catch (IOException e) {
        }
    }

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
            return null;
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