package spoj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
class bits
{
    static int table[]=new int[257];
    static void initialize()
    {
        table[0]=0;
        for(int i=1;i<=256;i++)
        table[i]=table[i/2]+(i&1);
    }
    static int count(int n)
    {
        return (table[n & 0xff]+ table[(n>>8)&0xff ]+ table[(n>>16)&0xff]+ table[(n>>24)]);
    }
    public static void main(String[] args) throws Exception
    {
       FastScanner fs=new FastScanner();
       PrintWriter out = new PrintWriter(System.out);
       initialize();
        int t=fs.nextInt();
        for(int i=0;i<t;i++)
        {
            int ans=0;
            int n=fs.nextInt();
            for(int x=1;x<=n;x++)
            ans+=count(x);
            out.println(ans);
            
        }
        out.flush();
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