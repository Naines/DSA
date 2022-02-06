import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class divfactSum 
{
    static class Reader 
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
    static boolean sieve[];
    static void sieve(int n)
    {
        sieve= new boolean[n+100];
        for(int i=2;i*i<=n;i++)
        {
            if(sieve[i]==false)
            {
                for(int j=i*i;j<=n;j+=i)
                {
                    sieve[j]=true;
                }
            }
        }
    }
    static long compute(int n,long i)
    {
        long  r=i;
        long count=0;
        while(n%r==0)
        {
            count++;
            n/=r;
        }
        //System.out.println(i+" "+count);
        return count;
    }
    
    static long exp(long x, long n) 
    {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return exp((x * x), n / 2);
        else
            return (x * exp((x * x), (n - 1) / 2));
    }
    static long gp(long count, long i)
    {
        long mult=1;
        long div=i-1;
        mult=exp(i,count+1);
        return ((mult -1)/div);

    }
    public static void main(String[] args)throws Exception 
    {
        int size=500000;
        sieve(size);
        
        Reader sc=new Reader();
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();

            long sum = 1;
            // int s=(int)Math.sqrt(n)+10;
            for(int i=2;i<=n;i++)//n
            { 
                
                if(sieve[i]==false && n%i==0)
                {
                    long count =0;
                    count= compute(n,i);//O(no. of factors)
                    sum *= gp(count , i);//log n
                }
            }
            sum-=n;
            System.out.println(sum);
        }
    
    }
}
/*
 * 1 -> 0 99999 -> 48513 500000 -> 730453 9689 -> 1 12345 -> 7431
 */