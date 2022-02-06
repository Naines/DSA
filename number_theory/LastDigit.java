import java.util.Scanner;

public class LastDigit 
{
    public static void main(String[] args) 
    {

        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int p = a % 10;
                int q = b % 4;
                if(b==0) System.out.println(1);
                else if(p==1 || p==0 || p==5 || p==6) 
                    System.out.println(p);
                else if (q == 1)
                   System.out.println(p);
                else if (q == 2)
                  System.out.println((p*p)%10);
                else if (q==3) 
                  System.out.println((p*p*p) % 10); 
                else if (q == 0)            
                    System.out.println((p * p * p * p) % 10);  

            }
            sc.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}