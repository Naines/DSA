import java.util.Arrays;

public class collectWood_ {
    public static  int solve(int[] A, int B) {
        int n=A.length;
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int low=0, high=A[n-1];
        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            
            int collected=collectWood(A,n, mid);
            System.out.println(mid+" wood Collected= "+collected);
            if(collected>=B){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
        
    }
     static int collectWood(int arr[], int n, int k){
        int sum=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]<=k)break;
            sum+=arr[i]-k;
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[]={117, 84, 50, 119, 74, 128 };
        int B=58;
        System.out.println(solve(arr, B));
    }
}
