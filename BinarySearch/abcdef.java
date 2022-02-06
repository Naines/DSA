import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
class abcdef
{
    public static void main(String[] args) throws Exception
    {
       FastScanner fs=new FastScanner();
      // PrintWriter out = new PrintWriter(System.out);
        int t=fs.nextInt();
        int arr[]=fs.readArray(t);

        int s1[]=new int[100*100*100+8];
        int s2[] = new int[100 * 100 * 100 + 8];
        int k1=0,k2=0;
        for(int a=0;a<t;a++)
        {
            for(int b=0;b<t;b++)
            {
                for(int c=0;c<t;c++)
                {
                    s1[k1++]=arr[a]*arr[b]+arr[c];
                    if(arr[a]!=0)
                    s2[k2++]=arr[a]*(arr[b]+arr[c]);
                }
            }
        }
        //System.out.println(k1+" "+k2);
        Arrays.sort(s1, 0, k1);
        Arrays.sort(s2, 0, k2);

        // for (int i = 0; i < k1; i++)
        //     System.out.print(s1[i] + " ");
        // System.out.println();
        // for (int i = 0; i < k2; i++)
        //     System.out.print(s2[i] + " ");

        //System.out.println();
        int temp=0,ans=0;
        for(int i=0;i<k1;i++)
        {
            int n1=0,n2=0;
            temp=s1[i];
            while(s1[i]==temp && i<k1 )
            {
                n1++;
                i++;
            }
            n2=numberOfOcc(s2, temp, 0, k2-1);
            //System.out.println(n1+" "+n2+" "+temp);
            i--;
            ans+=(n1*n2);
        }
        System.out.println(ans);
   }

    static int lower(int arr[], int k, int lb, int ub) {
        int ans = ub + 1;
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

    static int numberOfOcc(int arr[], int k, int lb, int ub) {
        int first = lower(arr, k, lb, ub);
        int last = lower(arr, k + 1, lb, ub);
        // System.out.println(first+" "+last);
        return last - first;
    }
    static final Random random =new Random();
    static void ruffleSort(int a[]){
        int n=a.length;//shuffle and then sort
        for(int i=0;i <n; i++){
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static class FastScanner 
    {
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
