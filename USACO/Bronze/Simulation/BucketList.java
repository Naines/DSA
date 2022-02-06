import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BucketList {
    public static void main(String[] args) throws Exception {
        Reader sc = new Reader("blist");
        PrintWriter out = new PrintWriter(new FileWriter("blist.out"));
        int n = sc.nextInt();
        int arr[] = new int[10000];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(), e = sc.nextInt(), b = sc.nextInt();
            for (int j = s; j <= e; j++) {
                arr[j] += b;
            }
        }
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        out.println(max);
        out.close();
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String name) throws IOException {
            br = new BufferedReader(new FileReader(name + ".in"));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
