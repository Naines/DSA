import java.util.Random;

public class quicksort 
{
    static void sort(int arr[], int s, int e)
    {
        //since recursive , base condition
        // int mid=(s+e)/2;
        //1.pivot ele
        //2.rearrange i.e, bring pivot ele to its pos
        //that is to div arr into two regions
        //3.sort the region
        //pivot doesnt need to be sorted

        if(s>=e)    return;
        int pivot=partition(arr, s, e);


        sort(arr, s, pivot-1);
        sort(arr, pivot+1, e);

    }
    static int partition(int arr[], int s, int e)
    {
        //divide into two regions on the basis of the pivot chosen
        int pivot=arr[e];
        int i=s-1, j=s;
        for(j=s;j<e;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                //swap(a[i], a[j]);
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //swap pivot to i
        int temp=arr[i+1];
        arr[i+1]=arr[e];
        arr[e]=temp;

        return i+1;
    }
    public static void main(String[] args) 
    {
        int arr[] = { 6, 344, 6534, 543, 52, 2, 6, 526, -432, 234525, -4325, -234 };
        //ruffle_sort(arr);
        ruffle_sort(arr);
        for (int i : arr)
            System.out.print(i + " ");

    }
    static void ruffle_sort(int arr[])
    {
        Random r=new Random();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int pos=r.nextInt(n);
            int temp=arr[pos];
            arr[pos]=arr[i];
            arr[i]=temp;
        }
        sort(arr, 0, n-1);
    }
}
