import java.util.HashSet;
import java.util.Set;

/**
 * nonRepeatedEle
 */
public class nonRepeatedEle 
{
    static void solve(int nums[])
    {
        Set<Integer> s1=new HashSet<>();
        for(int i: nums)
        {
            if(!s1.contains(i))
            s1.add(i);
            else
            {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,3};
        solve(arr);
    }
}