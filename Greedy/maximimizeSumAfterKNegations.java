import java.util.Arrays;

public class maximimizeSumAfterKNegations {
    public static long maximizeSum(long a[], int n, int k)
    {
         Arrays.sort(a);
        long smallest=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<n;i++){
            if(k>0 && a[i]<0){
                a[i]*=-1;
                k--;
            }
            smallest=Math.min(a[i], smallest);
            sum+=a[i];
        }
        if(k%2==1){//odd
            sum-=2*smallest;
        }
        return sum;
        
    }
    public static void main(String[] args) {

        long arr[]={-1,-2,-3,-4,-5};
        int n=arr.length, k=10;
        System.out.println(maximizeSum(arr, n, k));
        
    }
}
