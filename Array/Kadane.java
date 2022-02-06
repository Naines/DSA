public class Kadane
{
    static void solve(int arr[], int n)
    {
        int max=Integer.MIN_VALUE;
        int end=0;
        for(int i: arr)
        {
            end+=i;
            if(max< end)
            max=end;
            if(end<0)
            end=0;
        }
        System.out.println(max);
    }
    static void solve2(int arr[])
    {
        int tillnow = arr[0];
        int curr = arr[0];

        for (int i: arr) 
        {
            //updates when total sum>0 and total sum> current val
            //curr= arr[i] if total sum<0/arr[i]
            curr =Math.max(i, curr + i);


            tillnow = Math.max(tillnow, curr);
        }
        System.out.println(tillnow);
    }
    public static void main(String[] args) 
    {
        int arr[]={-2,-3,4,-1,-2,5,-3};//[...4,,,5.]
        solve(arr,arr.length);
        solve2(arr);
    }
}
