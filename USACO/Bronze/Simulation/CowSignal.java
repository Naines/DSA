import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowSignal {
    static String name = "cowsignal";
    // static String name = "xyz";

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st;
        // PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char mat[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                mat[i][j] = str.charAt(j);
            }
        }

        for (char ch[] : mat) {
            for (int j = 0; j < k; j++) {
                for (char c : ch) {
                    for (int i = 0; i < k; i++)
                        out.print(c);
                }
                out.println();
            }
        }
        out.close();
    }

}
