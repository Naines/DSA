public class countOnes 
{
    public static int count(int arr[], int lb, int ub)
    {
        if (arr[ub] == 0) // all 0s no ones
            return 0;
        if (arr[lb] == 1) //indicating all ones
            return (ub - lb + 1);
        int mid = lb + (ub - lb) / 2;
        return count(arr, lb, mid) + count(arr, mid + 1, ub);
    }
    public static void main(String[] args) {
        int arr[]={0,0,0,0,0,1,1,1,1,1,1};
        System.out.println(count(arr, 0, arr.length-1));
    }
    
}
