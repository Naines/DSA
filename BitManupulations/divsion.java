/**
 * divsion
 */
public class divsion {

    static int divide(long a, long b)
    {
        int ans = 0;
        int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

        a = Math.abs(a);
        b = Math.abs(b);

        long temp = 0;

        // System.out.println(b<<4);
        for (int i = 31; i >= 0; i--) {
            //System.out.println(b << i);
            // System.out.println(temp + (b << i));
            if ((temp + (b << i)) <= a) {
                temp += b << i;
                ans = ans | (1 << i);
            }
        }
        return ans * sign;
    }
    static int divide(int a, int b)// a/b
    {
        int ans=0;
        int sign=((a<0)^(b<0))?-1:1;

        a=Math.abs(a);
        b=Math.abs(b);

        long temp=0;

        //System.out.println(b<<4);
        for(int i=20;i>=0;i--)
        {
            System.out.println(b<<i);
            //System.out.println(temp + (b << i));
            if((temp + (b<<i)) <=a )
            {
                temp+=b<<i;
                ans=ans|(1<<i);
            }
        }
        return ans*sign ;
    }
    public static void main(String[] args) {
        long divd=52136513242l, divs=123;
        //System.out.println(divide(divd, divs));
        System.out.println(divide(divd, divs));
    }
}