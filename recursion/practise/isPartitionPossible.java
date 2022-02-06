package practise;

public class isPartitionPossible {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int k=3;
       System.out.println( find(arr, arr.length, k));
       
    }
    
    static boolean find(int arr[], int n, int k) 
    {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if(sum%k!=0)
        return false;
        return find(arr, k, sum/k, arr.length,0, new boolean[arr.length],0);
        
    }
    static boolean find(int arr[], int k, int target, int length, int index, boolean vis[], int currSum)
    {
        if(k==1){
            //ans found
            return true;
        }
        if(currSum==target)
        {
            return find(arr, k-1, target, length, 0, vis, 0);
        }
        for(int i=index;i<length;i++)
        {
            if(vis[i]) continue;
            vis[i]=true;
            if(find(arr, k, target, length, i+1, vis, currSum+arr[i]))
            return true;
            //backtarck
            vis[i]=false;
        }
        return false;
    }

}
