import java.util.Stack;

public class maxAreaMatrix 
{
    static int histArea(int arr[])
    {
        int n=arr.length;
        int left[]=new int[n];
        int right[]=new int[n];
        int ans=0;

        Stack<Integer> s=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            //if empty insert current
            if(s.isEmpty())
            {
                left[i]=i;
                s.push(i);
            }else{
                //pop till smaller not found
                while(!s.isEmpty() && arr[s.peek()]>=arr[i])
                s.pop();

                //s.top may/ maynot have smaller ele
                left[i]=s.isEmpty()?0:s.peek()+1;

                s.push(i);
            }
        }
        s.clear();
        for (int i = n-1; i>=0; i--) {
            // if empty insert current
            if (s.isEmpty()) {
                right[i] = i;
                s.push(i);
            } else {
                // pop till smaller not found
                while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                    s.pop();

                // s.top may/ maynot have smaller ele
                right[i] = s.isEmpty() ? 0 : s.peek() -1;

                s.push(i);
            }
        }
        for(int i=0;i<n;i++)
        {
            ans=Math.max((right[i]-left[i]+1)*arr[i],ans);
        }
        return ans;
    }
    static void compute(int arr[][])
    {
        int r=arr.length;
        int c=arr[0].length;

        int maxArea=histArea(arr[0]);
        for(int i=1;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(arr[i][j]==1)
                arr[i][j]+=arr[i-1][j];
            }
            maxArea=Math.max(maxArea, histArea(arr[i]));
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        int arr[][]={{0 ,1 ,1, 0},
                     {1, 1, 1, 1},
                     {1 ,1 ,1, 1},
                     {1 ,1, 0 ,0}};

        compute(arr);
    }
}
