
public class SubsetsWithGivenDifference {
    static int subsetSum(int arr[], int sum, int n)
    {
        if(sum==0)  return 1;
        if(n==0)    return 0;
        if(arr[n-1]<=sum)
        return subsetSum(arr, sum-arr[n-1], n-1)+subsetSum(arr, sum, n-1);
        return subsetSum(arr, sum, n-1);
    }
    public static void main(String[] args) {
        /**
         * 1 2 1 3
         * 1 1 2 - 3 = 1
         * 1 3 - 2 1 = 1
         * 1 3 - 2 1 = 1
         */
        int arr[]={1,2,1,3};
        int diff=1;

        /**Here arr can be divided into s1 and s2
         * s1 - s2 = diff
         * s1 + s2 = sum
         * s1 = (sum + diff)/2
         * we are to find #subsets_with_sum=s1
         */
        int sum=0;
        for(int i: arr) sum+=i;
        int s1=(sum+diff)/2;
        System.out.println(subsetSum(arr, s1, arr.length));
        
    }
    
}
