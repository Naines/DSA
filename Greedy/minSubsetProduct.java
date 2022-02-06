import java.util.Scanner;

public class minSubsetProduct {
    public static void main(String[] args) {
        //answer can be brought easily by swapping but it manipulates the data
        //hence we go by greedy
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println(solve(arr, n));
        
        sc.close();
    }
    static int solve(int arr[], int n)
    {
        int min_pos=Integer.MAX_VALUE, max_neg=Integer.MIN_VALUE;
        int n_zero=0, n_neg=0, prod=1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0){
                n_zero++; continue;
            }
            if(arr[i]<0)
            {
                n_neg++;
                max_neg=Math.max(max_neg, arr[i]);
            }
            else if(arr[i]>0 && arr[i]<min_pos) min_pos=arr[i];
            prod*=arr[i];
        }

        //#1: atleast one zero
        if(n_zero>0 && n_neg==0 || n_zero==n)   return 0;

        //#2: all positive
        if(n_neg==0) return min_pos;

        //#3: even negative
        if(n_neg%2==0 ) return prod=prod/max_neg;

        //#4: odd negative..simply return as 0 cases has been dealt
        return prod;

    }
}
