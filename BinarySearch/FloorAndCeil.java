public class FloorAndCeil 
{
    public static int ceil(int arr[],int x)
    {
        int lb=0, ub=arr.length-1;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(arr[mid]>=x)//find better ans in left
            {
                ans=mid;
                ub=mid-1;
            }
            else//search in right half as arr[mid]>X
            lb=mid+1;
        }
        if(ans==-1)
        return ans;
        else
        return arr[ans];
    }
    public static int floor(int arr[],int x)
    {
        //1 2 4 6 7
        int lb=0, ub=arr.length-1;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(arr[mid]<=x)
            {
                ans=mid;
                lb=mid+1;
            }
            else
            ub=mid-1;
        }
        if(ans==-1)
        return -1;
        else
        return arr[ans];
    }
        public static void main(String[] args) {
            int arr[]={ 1, 2, 4, 6, 10, 12, 14 };
            
            for(int i=-1;i<=17;i++)
            System.out.println(i+"  floor: "+(floor(arr,i)+" "+"ceil: "+ceil(arr, i)));
        }
}
