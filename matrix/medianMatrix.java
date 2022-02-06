import java.util.Arrays;

public class medianMatrix 
{
    static void findMedian(int arr[][], int r, int c)
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<r;i++)       //finds the least and greatest among the rowise sorted array
        {
            Arrays.sort(arr[i]);
            min=Math.min(arr[i][0], min);
            max=Math.max(arr[i][c-1], max);
        }

        int desired=(r*c+1)/2;
        while(min<max)                           //O(log(r*c))
        {
            int mid=min+(max-min)/2;
            int place=upperbound(arr, mid);

            if(place<desired) //lesser hence SS goes to right
            {
                min=mid+1;
            }
            else //greater hence SS goes to left
            max=mid; 
        }
        System.out.println(min);
    }
    public static void main(String[] args) 
    {
        //rowise sorted in increasing
        int arr[][]={{1,4,7},{2,5,8},{3,6,9}};
        findMedian(arr, arr.length, arr[0].length);
        int arr1[][]={{18, 13, 8 ,1 ,12, 1 ,14, 17, 15, 8, 2}};
        findMedian(arr1, arr1.length, arr1[0].length);
    }

    ////////////////////////////////////////////////
    /////////////////////////////////////////////////

    // returns number of elements in row wise and col wise sorted array[][] which are <= given number k;
    static int upperbound(int arr[][], int k) {
        int ans = 0;
        int r = arr.length;
        for (int i = 0; i < r; i++) {
            int get = Arrays.binarySearch(arr[i], k);
            if (get < 0)// element not found in row
            {
                get = Math.abs(get) - 1;
            } else // element found in array but may have dupes
            {
                while (get < arr[i].length && arr[i][get] == k)
                    get++;
            }
            // System.out.println(get);
            ans += get;
        }
        return ans;
    }
    
}
