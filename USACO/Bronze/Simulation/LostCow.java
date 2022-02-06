import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LostCow {
    static String name = "lostcow";

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader(name);
        PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));
        int x = sc.nextInt();
        int y = sc.nextInt();

        boolean fwd = true;

        int num = 1;
        int d = 0;
        while (true) {
            if ((fwd && x <= y && (x + num) >= y) || (!fwd && x >= y && (x - num) <= y)) {
                d += Math.abs(y - x);
                break;
            } else {
                d += (num * 2);
                num *= 2;
                fwd = !fwd;
            }
        }
        out.println(d);
        out.close();
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String name) {
            try {

                br = new BufferedReader(new FileReader(name + ".in"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();

            }
            return str;
        }
    }
}
