import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class billboard1 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner("billboard");
        int mat[][] = new int[2001][2001];
        for (int i = 0; i < 3; i++) {
            int x1 = fs.nextInt() + 1000, y1 = fs.nextInt() + 1000, x2 = fs.nextInt() + 1000, y2 = fs.nextInt() + 1000;
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    mat[x][y] = i < 2 ? 1 : 0;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 2000; i++) {
            for (int j = 0; j <= 2000; j++) {
                if (mat[i][j] == 1)
                    ans++;
            }
        }
        fs.println(ans);
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