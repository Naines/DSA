import java.util.Stack;

public class maxHistogramArea2 {
    public static void main(String[] args) {
        int arr[]={6,2,5,4,5,1,6};
        int n=arr.length;

        Stack<Integer> stk=new Stack<>();
        int maxArea=0;
        int area=0;
        int i;

        for(i=0;i<n;){

            if(stk.isEmpty() || arr[i]>=arr[stk.peek()]){
                stk.push(i++);
            }else{
                int top=stk.pop();
                area=stk.isEmpty()? arr[top]*i: arr[top]*(i-stk.peek()-1);
                maxArea=Math.max(area, maxArea); 
            } 
        }
        while(!stk.isEmpty()){
            int top=stk.pop();
             area=stk.isEmpty()? arr[top]*i: arr[top]*(i-stk.peek()-1);
                maxArea=Math.max(area, maxArea);
        }
        System.out.println(maxArea);
    }
}
