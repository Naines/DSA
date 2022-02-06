package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//use print writer
public class BBsearch1 
{
    public static int FirstOccurence(int arr[], int k) 
    {

        int lb = 0, ub = arr.length - 1;
        int res = -1;
        if(arr[ub]>=k)
        {
            while (lb <= ub) {
                int mid = lb + (ub - lb) / 2;

                if (arr[mid] > k)
                    ub = mid - 1;
                else if (arr[mid] < k)
                    lb = mid + 1;
                else {
                    // continue searching and find the
                    // first coocurance by searching in left half
                    res = mid;
                    ub = mid - 1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException 
    { 
        PrintWriter out=new PrintWriter(System.out);
        FastReader fs=new FastReader();
        int n=fs.nextInt();
        int q=fs.nextInt();
        int arr[]=fs.readArray(n);
        
        for(int i=0;i<q;i++)
        {
            int k=fs.nextInt();
           out.println(FirstOccurence(arr,k));
        }
        out.close();
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
