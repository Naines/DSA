import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class divfact 
{
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
    static boolean sieve[];
    static int m=1000000007;
    static void sieve(int n)
    {
        sieve=new boolean[n+100];
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
    public static void main(String[] args)throws Exception
    {
        try{
            Reader sc=new Reader();
            int size=50000;
            sieve(size);
            //for(int i=1;i<=size;i++) if(sieve[i]==false) System.out.print(i+" ");
            int t=sc.nextInt();
            while(t-->0)
            {
                int n=sc.nextInt();
                int j=2,ans=1;
                while(j<=n)
                {
                    if(sieve[j]==false)
                    {
                        int count=0;
                        count=pow(n,j);
                        count=count+1;
                        ans=((mult(ans , count))%m);
                    }
                    j++;
                }
                System.out.println(ans);

            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static int add(int a,int b)
    {
        return ((a%m + b%m)%m);
    }
    static int mult(int a,int b)
    {
        a = a % m;
        b = b % m;
        long c = (1L * a * b) % m;
        return (int) c;
    }
    static int pow(int n,int i)
    {
        int count=0;
        int r=i;
        while((int)(n/r)>0)
        {
            count+=(int)n/r;
            r=r*i;
        }
        return count;
    }
    


    
}
