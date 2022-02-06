import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * PrimeGenSegmentSieve 11 12 13 14 15 16 17 18 19 20 <-sieve 2 3 4 <- sqrt(20),
 * primes
 * 
 * 11 12 13 14 15 16 17 18 19 20
 * 
 * 2: 11%2==false j=11+(2-(11%2))=12 then loop-> 14, 16 ,18 ,20
 * 
 * 3: 11%3==false j=11+(3-(11%3))=12 then loop: 12, 15, 18
 * 
 * 4: 11%4==false j= 11+(4- (11%4))=12 and then loop: 12 16 20
 */
public class PrimeGenSegmentSieve 
{
    static boolean sieve[];
    static ArrayList<Integer> primes=new ArrayList<>();


    ///generates sieve upto sqrt(n)
    static void sieve(int n)
    {
        sieve=new boolean[n+1];
        sieve[1]=true;
        sieve[0]=true;
        for(int i=2;i*i<=n;i++)
        {
            for(int j=i*i;j<=n;j+=i)
            {
                sieve[j]=true;
            }
        }
        for(int i=2;i<=n;i++)
        {
            if(sieve[i]==false)
            primes.add(i);
        }
    }

    //queries in range[2...n]
    static void range(int a,int b)
    {
        if(a==0)
        a+=2;
        if(a==1)
        a++;

        int range=b-a+1;
        boolean prime[]=new boolean[range];

        for(int c: primes)
        {
            if(c*c<=b)                 //(as said earlier gen sqrt(n) sieve)
            {
                int j= a;
                if(j%c!=0)              //find next number div by prime c in a..b
                {
                    j+=(c-(j%c));
                }
                for(;j<=b;j+=c)         //find nos div by c in a...b and mark those
                {
                    if(j%c!=0)
                    {
                        System.out.println("here");
                    }
                    if(j!=c)
                    {
                        prime[j-a]=true;
                    }
                }
            }
        }
        for (int i = 0; i < range; i++) {
            if (prime[i] == false)
                System.out.println(i + a);
        }

    }
    public static void main(String[] args)throws Exception
    {
        sieve(1000000);
        Reader sc=new Reader();
        int t=sc.nextInt();
        while(t-->0)
        {
            int a= sc.nextInt();
            int b = sc.nextInt();
            range(a, b);
            System.out.println();
        }
        
    }
    
    static class Reader {
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
}