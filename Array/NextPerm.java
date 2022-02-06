

/**
 * NextPerm
 */
public class NextPerm {
    static void solve(int arr[], int n)
    {
        //find first non incr ele from left
        // 1 3 5 4 2 -> 3
        int i=arr.length-2;
        while(i>=0 && arr[i]>=arr[i+1])
        i--;

        //min i=-1 in case increasing array
        // 5 4 3 2 1 =>  reverse 

        //if found else ed. 1 2 3 4 5 -> i=4
        if(i>=0)
        {
            int j=arr.length-1;
            //find rightmost dig > arr[i]

            while(arr[j]<=arr[i])
            j--;

            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

        //reverse to get final ans
        //reverse from i++ to arr.length-1

        int j=arr.length-1;
        
        i++;
        System.out.println(i+" "+j);
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        for(int x: arr)
        System.out.print(x+" ");
    }
    public static void main(String[] args) {
        //int arr[]={1,3,5,4,2};
        //int arr[]={1,2,3,4,5};
        int arr[]={5,4,3,2,1};
        solve(arr, arr.length-1);
    }
}