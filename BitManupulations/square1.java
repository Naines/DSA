public class square1 
{
    /**
     * 
     * x=n/2;
     * n^2= 4x^2//even
     *    = 4x^2+ 4x +1
     */
    static int square(int n)
    {
        if(n==0)
        return 0;

        if(n<0)
        n=-n;
                                                  
        int x=n>>1;                               //x=n/2
        if((n&1)!=0)
        return ((square(x)<<2)+(square(x)<<2)+1);//4x^2+ 4x+1==odd
        else
        return (square(x)<<2);                   //4x^2
        
    }
    public static void main(String[] args) {
        int n=16;
        System.out.println(square(n));
    }
}
