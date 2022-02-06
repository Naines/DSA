public class SmallestMissingEle 
{
    public static int findSmallest(int arr[])
    {
        int lb=0, ub=arr.length-1;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(arr[mid]!=mid)//pt of 1st small or small lie to left
            {
                ans=mid;
                ub=mid-1;
            }
            else
            {
                lb=mid+1;
            }
        }
        if(ans==-1)
        return arr.length;
        else
        return ans;
    }
    public static void main(String[] args) 
    {
        int arr[]={0,1,2,3,4,5,6};
        System.out.println(findSmallest(arr));
    }
}
