public class SqrootCheck 
{
    public static boolean check(int n)
    {
        int lb=1,ub=n;
        while(lb<=ub)
        {
            int mid=(lb+ub)/2;
            if(mid*mid < n){
                if(lb==mid)
                return false;
                lb=mid;
            }
            else if(mid*mid > n){
                if(lb==mid)
                return false;
                ub=mid;
            }
            else 
            return true;

        }
        return false;


    }
    public static void main(String[] args) 
    {
        for(int i=1;i<=1000;i++)
        if(check(i))
        System.out.print(i+" ");
    }
}
