import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class squareMerge {
    static ArrayList<Integer> solve(ArrayList<Integer> A) {
        // int n=A.size();
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> n = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : A) {
            if (i < 0)
                n.add(i * i);
            else
                p.add(i * i);
        }
        // System.out.println("n = " + n);
        // System.out.println("p = " + p);
        int n1 = p.size(), n2 = n.size();
        int i = 0, j = 0;
        Collections.reverse(n);
        while (i < n1 && j < n2) {
            int a = p.get(i);
            int b = n.get(j);
            if (a < b) {
                ans.add(a);
                i++;
            } else {
                ans.add(b);
                j++;
            }
        }
        System.out.println(p + " " + n);
        while (i < n1) {
            int a = p.get(i++);
            ans.add(a);
        }
        while (j < n2) {
            int a = n.get(j++);
            ans.add(a);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int arr[] = { 0, 1, -2, 3, -6, 7, -10 };
        Arrays.sort(arr);
        for (int i : arr)
            list.add(i);
        System.out.println(solve(list));
    }
}
