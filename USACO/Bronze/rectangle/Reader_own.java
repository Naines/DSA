import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * xyz
 */
public class Reader_own {

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int x = sc.nextInt();
        int y = sc.nextInt();
        String z = sc.next();
        System.out.println(x + " " + y + " " + z);
        int f = sc.nextInt();
        System.out.println(f);
        String str = sc.nextLine();
        System.out.println(str);
        String str1 = sc.next();
        System.out.println(str1);
    }

    static class Reader {
        static StringTokenizer st;
        static BufferedReader br;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
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
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}