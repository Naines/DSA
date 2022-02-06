public class getMiddleOfThreeElements 
{

    //3 comparisons
    static int middle(int a, int b, int c)
    {

        if ((a - b) * (b - c) > 0)
            return b;
        if ((b - c) * (c - a) > 0)
            return c;
        return a;
    }

    //3 swaps
    static int middle1(int a, int b, int c)
    {
        if(a>b) 
        {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        if(b>c)
        {
            b=b^c;
            c=b^c;
            b=b^c;
        } 
        if(a>b){
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;  
        } 
        return b;
    }
   
    public static void main(String[] args) {
        System.out.println(middle(900, 300, 518));
        System.out.println(middle1(900, 300, 518));
    }
}
