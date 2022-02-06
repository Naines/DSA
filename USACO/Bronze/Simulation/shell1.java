import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shell1 {
    static String name = "shell";

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter(new FileWriter(name + ".out"));
        int n = Integer.parseInt(st.nextToken());
        int shell[] = new int[3];
        int count[] = new int[3];

        for (int i = 0; i < 3; i++)
            shell[i] = i;
        for (int tt = 0; tt < n; tt++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1,
                    g = Integer.parseInt(st.nextToken()) - 1;
            int temp = shell[a];
            shell[a] = shell[b];
            shell[b] = temp;

            count[shell[g]]++;
        }

        out.println(Math.max(count[0], Math.max(count[1], count[2])));
        out.close();
    }
}
