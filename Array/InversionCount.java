public class InversionCount 
{
    static void solveNaive(int arr[], int n)
    {
        int count=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]>arr[j])
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        //int arr[]={2,4,1,3,5};//3
        int arr[]={8,6,7,5,10,7,11};
        //int arr[]={10,10,10};
        solveNaive(arr, arr.length);
    }
}
