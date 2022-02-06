import java.util.Arrays;

public class burst_balloons {
    static int burst(int arr[], int i, int j){
        
        if(i>j)return 0;
        
        int res=0;
        for(int k=i;k<=j;k++){
            int a=burst(arr, i, k-1);
            int b=burst(arr, k+1, j);
            int c=arr[i-1]*arr[k]*arr[j+1];
            res=Math.max(res, a+b+c);
        }
        return res;
    }
     static int burst1(int memo[][],int arr[], int i, int j){
        if(i>j)return memo[i][j]=0;
        if(memo[i][j]!=-1)return memo[i][j];
        int res=0;
        for(int k=i;k<=j;k++){
            int a=burst1(memo,arr, i, k-1);
            int b=burst1(memo,arr, k+1, j);
            int c=arr[i-1]*arr[k]*arr[j+1];
            res=Math.max(res, a+b+c);
        }
        return memo[i][j]=res;
    }
    
    public static void main(String[] args) {
        int nums[]={3,1,5};
        int n=nums.length;
        int arr[]=new int[n+2];
        arr[0]=arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        System.out.println(burst(arr,1, n));

        int memo[][]=new int[arr.length+1][arr.length+1];
        for(int i[]:memo)Arrays.fill(i, -1);
        System.out.println(burst1(memo,arr,1, n));
    }
}
