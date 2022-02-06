public class maxproductSubsequence
{
    static long solve(int arr[], int n)
    {
        long ans=1;
        long temp=1;
        for(int i: arr)
        {
            if(i==0)    continue;
            ans*=i;
            temp=Math.max(ans,temp);
        }
        return temp;
    }
    public static void main(String[] args) 
    {
        int arr[]={ 8 ,-2, -2 ,0 ,8 ,0 ,-6 ,-8 ,-6, -1};
        System.out.println(solve(arr,arr.length));
    }
}
