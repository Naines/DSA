/**
 * PowerOfTwo
 */
public class PowerOfTwo 
{

    public static void main(String[] args) {
        for(int i=0;i<1000;i++)
        if((i&i-1)==0)
        System.out.print(i+" ");
    }
}