import java.util.Arrays;

/**
 * printBinary
 */
public class printBinary {

    static void print(int n,int i, char ch[])
    {
        if(i==n) 
        {
            for(char c: ch)
            System.out.print(c);
            System.out.println();
            return;
        }
        
        if(ch[i]=='?')
        {
            ch[i]='0';
            print(n, i+1,  ch);
            ch[i]='1';
            print(n, i+1, ch);
            ch[i]='?'; //back-track
        }
    }
    public static void main(String[] args) {
        int n=2;
        char ch[]=new char[n];
        Arrays.fill(ch,'?');
        print(n,0,ch);
    }
}