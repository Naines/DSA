import java.util.ArrayList;

public class allsubsets {
    static void subsets(int arr[], int index, ArrayList<Integer> ans)
    {
        if(index==arr.length)
        {
            for(var i: ans )    System.out.print(i+" ");
            System.out.println();
            return;
        }

        //inclusion
        ans.add(arr[index]);
        subsets(arr, index+1, ans);

        //exclusion
        ans.remove(ans.size()-1);
        subsets(arr, index+1, ans);

    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        subsets(arr, 0, new ArrayList<Integer>());
    }
}
