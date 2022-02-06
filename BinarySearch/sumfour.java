import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class sumfour
{
    public static void main(String[] args) throws Exception
    {
       FastScanner fs=new FastScanner();
        int t=fs.nextInt();
        int a[] = new int[4005];
        int b[] = new int[4005];
        int c[] = new int[4005];
        int d[] = new int[4005];

        for(int i=0;i<t;i++)
        {
            a[i]=fs.nextInt();
            b[i]=fs.nextInt();
            c[i]=fs.nextInt();
            d[i]=fs.nextInt();
        }
        
        
        int a1[]=new int[10500000];
        int b1[]=new int[10500000];
        int k=0;

        for(int i=0;i<t;i++)
        {
            for(int j=0;j<t;j++)
            {
                a1[k]=a[i]+b[j];
                b1[k++]=-1*(c[i]+d[j]);
            }
        }
        int a2[]=new int[k];
        int b2[]=new int[k];
        for(int i=0;i<k;i++)
        {
            a2[i]=a1[i];
            b2[i]=b1[i];
        }
        Arrays.sort(a2);
        Arrays.sort(b2);
        // for(int i: a2)  System.out.print(i+" ");
        // System.out.println();
        // for(int i: b2)  System.out.print(i+" ");

        int ans=0,n1=0,n2=0,temp=-1834687;
        for(int i: a2)
        {
            if(temp!=i)
            temp=i;
            else 
            continue;
            
            n1=numberOfOcc(a2, i);
            n2=numberOfOcc(b2, i);
            //System.out.println(i+" "+n1+" "+n2);
            int count=n1*n2;
            ans+=count;
            
        }
        System.out.println(ans);
   }
   
   static int lower(int arr[], int k) {
        int lb = 0, ub = arr.length - 1;
        int ans = arr.length;
        while (lb <=ub){
            int mid = lb + (ub - lb)/2;
            if (arr[mid] >= k) {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }

        }
        return ans;
    }
    static int numberOfOcc(int arr[], int k)
    {
        int first = lower(arr, k);
        int last = lower(arr, k+1);
        // System.out.println(first+" "+last);
        return last-first;
    }
    
    static int[] convert(ArrayList<Integer> a) {
        int n = a.size();
        int arr[] = new int[n];
        int k = 0;
        for (int i : a)
            arr[k++] = i;
        return arr;
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