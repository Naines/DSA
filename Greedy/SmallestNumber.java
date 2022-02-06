/**
 * The task is to find the smallest number with given sum of digits as S and
 * number of digits as D.
 * S=9, N=2 : 18
 * S=20, n=3: 299
 * 
 * if not possible -1
 */
public class SmallestNumber {
    public static void main(String[] args) {
        int s=6, n=6;
        String no="";
        if(n*9<s) System.out.println("-1");
        else
        {
            s-=1;

            
            while(n>1)
            {
                //case 1: adding 9
                if(s>=9)
                {
                    no+=9;
                    s-=9;
                    n--;
                }
                //case 2: adds <9 at the end
                if(s>0 && s<9 && n>1)
                {
                    no += s;
                    n--;
                    s = 0;
                }
                
                //case 3: adds 0
                if(s==0)
                while(n>1)
                {
                    no+=0;
                    n--;
                }
            }  
            
            // case 4: add 1 at the end
            if (n == 1)
                no += (1 + s);

            char ch[]=no.toCharArray();
            for(int i=ch.length-1;i>=0;i--)
            System.out.print(ch[i]);
        }
    }
}
