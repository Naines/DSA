public class checkifpowersofn {
    static int num=4;
    public static boolean checkPowersOfThree(int n) 
    {
        if (n < 0)
            return false;
        if (n == 0)
            return true;
        int last = (int) Math.pow(num, (int) (Math.log10(n) / Math.log10(num)));
        if (n >= (num-1) * last)
            return false;
        return checkPowersOfThree(n - last);
    }
    public static void main(String[] args) 
    {
        System.out.println(checkPowersOfThree(68));
    }
}

/**
 * // Method 1: brute force to check all subsets // public boolean
 * checkPowersOfThree(int n) { // int arr[]=new int[20]; // arr[0]=1; // for(int
 * i=1;i<20;i++) // // arr[i]=3*arr[i-1];
 * 
 * // return subsetsum(arr, n, 20); // } // boolean subsetsum(int arr[], int
 * sum, int n) // { // if(sum==0) return true; // if(n==0) return false;
 * 
 * // if(arr[n-1]<=sum) // return subsetsum(arr, sum-arr[n-1], n-1) ||
 * subsetsum(arr, sum, n-1); // else return subsetsum(arr, sum,n-1); // } public
 * b
 */