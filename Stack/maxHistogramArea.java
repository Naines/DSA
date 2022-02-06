import java.util.Stack;

/**
 * maxHistogramArea
 */
public class maxHistogramArea {

    public static void main(String[] args) {
        int arr[]={6,2,5,4,5,1,6};
        int n=arr.length;
        int nsl[]=new int[n];
        int nsr[]=new int[n];
        int width[]=new int[n];

        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            if(stk.isEmpty()){
                nsl[i]=-1;
            }else{
                while(stk.size()>0 && arr[stk.peek()]>=arr[i]) stk.pop();
                if(stk.size()==0)
                nsl[i]=-1;
                else 
                nsl[i]=stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for(int i=n-1;i>=0;i--){
            if(stk.isEmpty()){
                nsr[i]=n;
            }else{
                while(stk.size()>0 && arr[stk.peek()]>=arr[i]) stk.pop();
                if(stk.size()==0)
                nsr[i]=n;
                else 
                nsr[i]=stk.peek();
            }
            stk.push(i);
        }

        // for(int i: arr) System.out.print(i+" ");
        // System.out.println();
        // for(int i: nsl) System.out.print(i+" ");
        // System.out.println();
        // for(int i: nsr) System.out.print(i+" ");
        // System.out.println();

        int maxArea=0;
        for(int i=0;i<n;i++){
            width[i]=nsr[i]-nsl[i]-1;
            // System.out.print(width[i]+" ");
            maxArea=Math.max(maxArea, width[i]*arr[i]);
        }
        // System.out.println();
        System.out.println(maxArea);
    }
}