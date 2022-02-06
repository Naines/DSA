import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BridgeBucket {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner("buckets");
        char mat[][] = new char[10][10];
        int bi = 0, bj = 0, ri = 0, rj = 0, li = 0, lj = 0;
        for (int i = 0; i < 10; i++) {
            char chs[] = fs.next().toCharArray();
            for (int j = 0; j < 10; j++) {
                mat[i][j] = chs[j];

                if (mat[i][j] == '.')
                    continue;
                else if (mat[i][j] == 'B') {
                    bi = i;
                    bj = j;
                } else if (mat[i][j] == 'L') {
                    li = i;
                    lj = j;
                } else {
                    ri = i;
                    rj = j;
                }
            }
        }
        int cows = Math.abs(bi - li) + Math.abs(bj - lj) - 1;
        // row check
        if (bi == li && bi == ri && ((lj < rj && rj < bj) || (bj < rj && rj < lj))) {
            cows += 2;
        }
        // col check
        else if (bj == lj && bj == rj && ((li < ri && ri < bi) || (bi < ri && ri < li))) {
            cows += 2;
        }
        fs.println(cows);
        fs.close();
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