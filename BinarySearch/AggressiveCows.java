import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * AggressiveCows
 */
public class AggressiveCows 
{
    public static boolean isValid(int arr[], int mid, int n, int c)
    {
        int count=1, prev=0;
        for(int i=1;i<n && count<c; i++)
        {
            if(arr[i]-arr[prev]>=mid)
            {
                prev=i;
                count++;
            }
        }
        //System.out.println(count+" "+mid);
        if(count>=c) return true;
        else return false;
    }
    public static int solve(int arr[], int n, int c)
    {
        
        int lb=arr[0], ub=arr[n-1], ans=0, mid;
        if(isValid(arr, ub-lb, n ,c))
        ans=ub-lb;
        while(lb<=ub)
        {
            mid=lb+(ub-lb)/2;
            //System.out.println(mid);
            if(isValid(arr, mid, n, c))
            {
                ans=Math.max(mid,ans);
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception
    {
       FastReader fs=new FastReader();
       PrintWriter out = new PrintWriter(System.out);
        int t=fs.nextInt();
        for(int i=0;i<t;i++)
        {
            int n = fs.nextInt();
            int c = fs.nextInt();
            int arr[]=fs.readArray(n);
            Arrays.sort(arr);
            out.println(solve(arr,n,c));
            out.flush();
        }
    }
    static final Random random =new Random();
    static void ruffleSort(int a[]){
        int n=a.length;//shuffle and then sort
        for(int i=0;i <n; i++){
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[1]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static class FastReader {
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