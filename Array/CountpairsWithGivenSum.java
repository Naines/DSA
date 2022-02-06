import java.util.HashMap;
import java.util.Map;

public class CountpairsWithGivenSum 
{
    static void solve(int arr[], int k , int n)
    {
        Map<Integer, Integer> m=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!m.containsKey(arr[i]))
            m.put(arr[i],0);

            m.put(arr[i], m.get(arr[i])+1);
        }
       for(int i=0;i<n;i++)
       {
           if(m.get(k-arr[i])!=null)
           count+=m.get(k-arr[i]);

           if((k-arr[i]) == arr[i])
           count--;
       }
       System.out.println(count/2);
    }

    //compressing code
    //operates on one transversal
    static void solve2(int arr[], int k ,int n)
    {
        HashMap<Integer, Integer> mp=new HashMap<>();
        int count=0;
        for(int i: arr)
        {
            int req=k-i;
            if(mp.containsKey(req))
            count+=mp.get(req);    //count on the basis of already present elements' frequency
            
            mp.put(i, mp.get(i)==null? 1 : mp.get(i)+1);//update frequency count
        }
        System.out.println(count);
    }
    public static void main(String[] args) 
    {
        int arr[]={1,5,1,7};
        int k=2;
        solve(arr, k, arr.length);
        solve2(arr, k, arr.length);

    }
}
