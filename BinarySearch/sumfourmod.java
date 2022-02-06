import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class sumfourmod {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        int a[] = new int[4005];
        int b[] = new int[4005];
        int c[] = new int[4005];
        int d[] = new int[4005];

        for (int i = 0; i < t; i++) {
            a[i] = fs.nextInt();
            b[i] = fs.nextInt();
            c[i] = fs.nextInt();
            d[i] = fs.nextInt();
        }

        int a1[] = new int[10500000];
        int b1[] = new int[10500000];
        int k = 0;

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                a1[k] = a[i] + b[j];
                b1[k++] = -1 * (c[i] + d[j]);
            }
        }
    
        Arrays.sort(a1, 0, k);
        Arrays.sort(b1, 0, k);
        // for(int i=0;i<k;i++)    System.out.print(a1[i]+" ");
        // System.out.println();
        // for(int i=0;i<k;i++)    System.out.print(b1[i]+" ");
        // System.out.println();

        int ans = 0, n1 = 0, n2 = 0, temp = -1834687;
        for (int i=0;i<k;) //nlogn
        {
            n1=0;
            temp=a1[i];
            while(a1[i]==temp && i<k)
            {
                n1++;
                i++;
            }
            n2 = numberOfOcc(b1, temp, 0, k-1);//log n
            //System.out.println(temp+" "+n2);
            //System.out.println(a1[i-1]+" "+n1+" "+n2);
            int count = n1 * n2;
            ans += count;

        }
        System.out.println(ans);
    }
    //////////////////////////////////////////////
    //////////////////////////////////////////////////
    /////////////////////////////////////////////////
    static int lower(int arr[], int k,int lb,int ub) {
        int ans = ub+1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }

        }
        return ans;
    }

    static int numberOfOcc(int arr[], int k,int lb,int ub) {
        int first = lower(arr, k, lb, ub);
        int last = lower(arr, k + 1, lb , ub);
        //System.out.println(first+" "+last);
        return last - first;
    }

    static int[] convert(ArrayList<Integer> a) {
        int n = a.size();
        int arr[] = new int[n];
        int k = 0;
        for (int i : a)
            arr[k++] = i;
        return arr;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}