package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class combSum {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        Collections.sort(arr);
        findSets(arr, sum, 0, new ArrayList<>());
        return list;
    }

    static void findSets(ArrayList<Integer> arr, int target, int index, List<Integer> temp) {
        if (target < 0)
            return;
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            // pruning
            if (i > index && arr.get(i) == arr.get(i - 1))
                continue;
            if (arr.get(i) > target)
                continue;

            // add
            temp.add(arr.get(i));

            findSets(arr, target - arr.get(i), i, temp);

            // delete
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1,3};
        int sum = 4;
        Arrays.sort(arr);
        ArrayList<Integer> l=new ArrayList<>();
       
        for(int i: arr)
        l.add(i);
        combinationSum(l, sum);
        for(var x: list)
        System.out.println(x);
    }

    
    
}
