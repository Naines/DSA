public class equalSumpartition {
    static boolean equalSumPartition(int arr[])
    {
        int sum=0;
        for(int i: arr) sum+=i;
        if(sum%2!=0)    return false;
        return subsetSum(arr, sum/2, arr.length);
    }
    static boolean subsetSum(int arr[], int sum, int n)
    {
        if(sum==0)  return true;
        if(n==0)    return false;
        if(arr[n-1]<=sum)
        return subsetSum(arr, sum-arr[n-1], n-1) || subsetSum(arr, sum, n-1);
        return subsetSum(arr, sum, n-1);
    }
    public static void main(String[] args) {
        int arr[]={2,2,3,1};
        System.out.println(equalSumPartition(arr));
        
    }
}
