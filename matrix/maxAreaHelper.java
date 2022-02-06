import java.util.Stack;

//helper function for max area 0f 1s in amatrix program
public class maxAreaHelper 
{
    static void maxarea(int arr[])
    {
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        
        int left[]=new int[n];
        int right[]=new int[n];
        
        //to find prev smallest limit
        //used to build left[] in o(n)
        for(int i=0;i<n;i++)
        {
            if(s.isEmpty())
            {
                s.push(i);
                left[i]=i;
            }
            else
            {
                //pop until nextsmaller found
                while(!s.isEmpty() && arr[s.peek()]>=arr[i])
                s.pop();
                left[i]=s.isEmpty()?0:s.peek()+1;
                s.push(i);
            }
        }

        s.clear();

        //tofind next smallest limit
        //used to build right[] in o(n)
        for(int i=n-1;i>=0;i--)
        {
            if(s.isEmpty())
            {
                right[i]=i;
                s.push(i);
            }
            else{
                while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                    s.pop();
                right[i] = s.isEmpty() ? n-1 : s.peek() - 1;
                s.push(i);
            }
        }

        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            int area=right[i]-left[i]+1;
            area=arr[i]*area;
            maxArea=Math.max(area,maxArea);
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        maxarea(arr);
    }
    
}
