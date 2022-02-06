import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 * 1 11 12 13 12 13 23
 */
public class DaisyChain {
    static void solve(int arr[], int n) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                // System.out.println(p);
                for (int k = i; k <= j; k++) {
                    if (sum == arr[k] * (j - i + 1)) {
                        // if (p == arr[k]) {
                        count++;
                        break;
                    }
                }
            }
        }
        // System.out.println(count);
        out.println(count);
    }

    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        out = new PrintWriter(System.out);

        int n = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(arr, n);
        out.close();
        br.close();
    }
}
