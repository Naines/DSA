public class maxProductSubArray1 {

    //TODO: incorrect sol, lacks corner case
    static void solve(int arr[])
    {
        long max_end=1, min_end=1, prod=1;
        //AIm should be to keep max_end to 1 or positive 
        //and to keep min_end to 1 or negative
        for(int i: arr)
        {
            if(i>0)
            {
                max_end=max_end*i; //always positive or 1
                min_end=min(min_end*i, 1); //1st part if min_end is -ve else reset to 1 if positive
                
            }
            else if(i==0)
            {
                //reset both max_end and min_end
                max_end=1;
                min_end=1;
            }
            else{
                long temp=max_end;
                max_end=max(min_end*i, 1); //if min_end is -ve max_end increases else reset to 1
                min_end=temp*i;
            }
            if(prod<max_end)
            prod=max_end;
        }
        System.out.println(prod);
    }

    //TODO: incorrect sol, lacks corner case
    static void solve2(int arr[])
    {
         long maxP=1, minP=1, res=1; 

        // Aim: keep maxP as high and positive as possible.
        // keep minP as low and negative as possible
        for(int i: arr)
        {
            if(i<0)
            {
                long temp=maxP;
                maxP=minP;
                minP=temp;
            }
            maxP=max(maxP*i, i);
            minP=min(minP*i, i);
            res=max(maxP, minP);
        }
        System.out.println(res);
    }

     public int maxProduct(int[] arr) {
     int maxP = arr[0], minP= arr[0],ans = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<0){
                int temp = maxP;
                maxP= minP;
                minP = temp;
            }
            maxP = Math.max(maxP*arr[i], arr[i]);
            minP = Math.min(minP*arr[i], arr[i]);
            ans = Math.max(maxP, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={5,-5,8,2,-1,3};
        solve(arr);
        solve2(arr);
    }
    static long max(long a, long b)
    {
        return a>b? a: b;
    }
    
    static long min(long a, long b) {
        return a < b ? a : b;
    }
}
