/**
 * sort012:= to sort arr of zeros ones and twos in ascs order
 * without using any sorting algo
 */
public class sort012 {

    //this method is not recommended but it saves unnecessary swaps
    static void sort(int arr[])
    {
        int n=arr.length;
        int z=0, o=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)   z++;
            else if(arr[i]== 1) o++;
        }
        int i=0;
        while(i<n && z-->0)
            arr[i++]=0;
        while(i<n && o-->0)
            arr[i++]=1;
        while(i<n)
        arr[i++]=2;

    }
    //solves in single transversal and inplace with O(n)
    static void sort1(int arr[])
    {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int mid = 0;

        while(mid<=high)
        {
           switch (arr[mid])
            {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++; 
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

   
    public static void main(String[] args) {
        int arr[]={0,1,2,0,1,1,1,0,2};
        // sort(arr);
        // print(arr);
        sort1(arr);
        print(arr);
    }
    /////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    static void swap(int arr[], int a, int b)
    {
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
}