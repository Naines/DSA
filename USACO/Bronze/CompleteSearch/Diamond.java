import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Diamond {
    // 1 6 4 3 1
    // 1 1 3 4 6
    // x-y<=kxx
    static void solve(int arr[], int n, int k) {
        int ans = 0;
        // System.out.println(Arrays.toString(arr));
        sort(arr);
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if ((arr[j] - arr[i]) <= k)
                    count++;
                else
                    break;
            }
            ans = Math.max(ans, count);
        }
        out.println(ans);
    }

    static void sort(int arr[]) {
        int n = arr.length;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int temp = r.nextInt(n);
            int o = arr[temp];
            arr[temp] = arr[i];
            arr[i] = o;
        }
        Arrays.sort(arr);
    }

    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("all")

        String name = "diamond";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(name + ".in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        out = new PrintWriter(new FileWriter(name + ".out"));

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(arr, n, k);
        out.close();
        br.close();
    }
}
