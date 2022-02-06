import java.util.Stack;
/**
 * StockSpan
 */
public class StockSpan {

    /**
     * 0  ,1, 2, 3, 4, 5, 6
     * 100,80,60,70,60,75,85
     * 
     * */
    static void solve(int arr[])
    {
        int n=arr.length;
        int prev[]=new int[n];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++)
        {
           
            while(!stk.isEmpty() && arr[stk.peek()]<=arr[i])
            stk.pop();

            if(stk.isEmpty())
            prev[i]=-1;
            else
            prev[i]=stk.peek();
            
            stk.add(i);
            prev[i]=i-prev[i];
        }
        for(int i: prev)
        System.out.print(i+" ");
    }
    static void solve1(int arr[], int n){
        int a=0,flag=0;
            for(int i=0;i<n;i++){
                while(i<n-1 && arr[i+1]<=arr[i]){
                    i++;
                }
                a=i;
                while(i<n-1 && arr[i+1]>=arr[i]){
                    i++;
                }
                // if(i==n) i--;
                if(a<i){
                    flag=1;
                    System.out.print("("+a+" "+i+")"+" ");
                }
            }
            if(flag==0)
            System.out.print("NO profit");
            System.out.println();
    }
    public static void main(String[] args) {
        // int arr[]={68, 735 ,101, 770};
        int arr[]={886 ,2777, 6915 ,7793 ,8335 ,5386 ,492, 6649 ,1421, 2362, 27,8690 ,59 ,7763 };
        solve(arr);
        solve1(arr, arr.length);
    }
}