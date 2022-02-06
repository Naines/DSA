public class facf 
{
    public static void main(String[] args) {
        long fact[]=new long[101];
        fact[0]=1;
        fact[1]=1;
        for(int i=2;i<=100;i++)
        {
            fact[i]=fact[i-1]*i;
            System.out.println(fact[i]+" "+i);
        }
    }
}
