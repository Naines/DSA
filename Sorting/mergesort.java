/**
 * mergesort
 */
public class mergesort 
{
    static void merge(int arr[], int s, int e)
    {
        int temp[]=new int[e+1];

        //2 ptr technique used
        int mid=(s+e)/2;
        int i=s, k=s, j=mid+1;
        while(i<=mid && j<=e)
        {
            if(arr[i]<arr[j])
            temp[k++]=arr[i++];
            else 
            temp[k++]=arr[j++];
        }

        //copy remaining ele
        while(i<=mid)   temp[k++]=arr[i++];
        while(j<=e)     temp[k++]=arr[j++];

        for(int x=s;x<=e;x++)
        {
            arr[x]=temp[x];
        }
    }
    static void sort(int arr[], int s, int e)
    {
        //since recursive, base case
        if(s>=e)    return;

        //1. divide
        int mid=s+(e-s)/2;

        //2. sort the left and right parts
        sort(arr, s, mid);
        sort(arr, mid+1, e);

        //3. merge them
        merge(arr, s, e);
    }

    public static void main(String[] args) 
    {
        int arr[]={6,344,6534,543,52,2,6,526,-432,234525,-4325,-234};
        for(int i:arr)  System.out.print(i+" ");
        System.out.println();
        sort(arr, 0, arr.length-1);
        for(int i: arr) System.out.print(i+" ");
    }
}