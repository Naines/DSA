import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
    static String name = "xyz";

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));
        Reader sc = new Reader("xyz");
        int x = sc.nextInt();
        char ch = sc.next().charAt(0);
        int y = sc.nextInt();
        out.println(x + " " + ch + " " + y);
        String str = sc.nextLine();
        out.println(str);
        int arr[] = new int[4];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        out.println(Arrays.toString(arr));
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
