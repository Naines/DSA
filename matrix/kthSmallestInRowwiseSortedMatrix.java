public class kthSmallestInRowwiseSortedMatrix 
{
    static int kthSmallestBinary(int arr[][], int k) {
        int n = arr.length;
        int lb = arr[0][0];
        int ub = arr[n - 1][n - 1];
        while (lb < ub) {
            int mid = lb + (ub - lb) / 2;
            int count = countSmallerThanMid(mid, arr);
            if (count < k)
                lb = mid + 1; // search more
            else
                ub = mid - 1; // search less elements
        }
        return lb;
    }

    private static int countSmallerThanMid(int mid, int arr[][]) {
        int n = arr.length;
        int j = n - 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (j >= 0 && arr[i][j] > mid)
                j--;
            count += (j + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2,3 }, { 4,5,6}, { 7,8,9 } };
        System.out.println(kthSmallestBinary(arr, 4));
    }
    
}
