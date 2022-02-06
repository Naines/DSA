public class countSubsetsWithGivenSum {
    static int countsubsets(int arr[], int sum, int n)
    {
        if(sum==0)  return 1;
        if(n==0)    return 0;

        //include or exclude-take 2 paths
        if(sum >= arr[n-1])
        return countsubsets(arr, sum-arr[n-1], n-1)+countsubsets(arr, sum, n-1);
        else return countsubsets(arr, sum, n-1);
    }
    public static void main(String[] args) {
        /** 1 2 3a 3b
         * sum=6
         * 1 2 3a
         * 1 2 3b
         * 3 3
         * 
         */
        int arr[]={1,2,3,3};
        System.out.println(countsubsets(arr, 6, arr.length));
        
    }
}
