/**
 * SubsetSum
 */
public class SubsetSum 
{
    static boolean subset(int arr[], int sum, int index)
    {
        if(sum==0)  return true;
        if(index==0)    return false;

        System.out.println(sum + " " + index);
        if(sum>=arr[index-1])
        {
            //result of include || exclude
            return subset(arr, sum-arr[index-1], index-1) ||
                    subset(arr, sum, index-1);
        }
        else //exclude
        return subset(arr, sum, index-1);
    }

    public static void main(String[] args) {
        /**1 2 3 4 5
         * 15
         * true
        */
        int arr[]={1,2,3,4,5};
        System.out.println(subset(arr, 6, arr.length));
    }
}