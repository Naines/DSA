

public class countBitsBinaryString 
{
    public int hammingWeight(int n) 
    {
        int count = 0;
        if (n < 0) { // meaning n is overflowed!
            count++; // leading bit must be 1 for negative value
            n = n & Integer.MAX_VALUE; // and this value -> 01111111111111111111111111111111, to mask off the leading 1
        }
        while (n > 0) 
        {
            if (n % 2 != 0)
                count++;
            n /= 2;
        }
        return count;
    }
    static void solve(int n)
    {
        //when n is negative number, n overflows ans has 32 bits which 
        //cant be stored in normal int
        //since java uses 2s complement , result stored as negative
        //hence n=-1 implies n= 111111111111111111...1 => 32 ones 
        int count=0;
        while(n!=0)
        {
            count+= n&1;
            n=n>>>1;
            System.out.println(Integer.toBinaryString(n));
        }
        System.out.println(count);
    }
    public static void main(String[] args) 
    {
        solve(-1);
    }
    
}
