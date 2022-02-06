public class missingEle 
{
    static int missing(int arr[], int n, int k)
    {
        int x1=0,x2=0;
        for(int i=0; i<n;i++)
        {
            x1=x1^arr[i];
        }
        for(int i=arr[0];i<=k;i++)
        x2^=i;
        return x1^x2;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,6,7,8,9,10};
        int n=arr.length;
        int k=10;
        System.out.println(missing(arr,n,k));
    }
}
