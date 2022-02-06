import java.util.ArrayList;
import java.util.Collections;

public class three_sum_zero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        // int num[] = new int[A.size()];
        // for (int i = 0; i < A.size(); i++)
        // num[i] = A.get(i);

        // Arrays.sort(num);
        // int n = num.length;
        // ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // for (int i = 0; i < n - 2; i++) {
        // if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
        // int low = i + 1, high = n - 1;
        // long sum = 0 - num[i];
        // while (low < high) {
        // if (sum(num[low], num[high]) == sum) {
        // ArrayList<Integer> temp = new ArrayList<>();
        // temp.add(num[i]);
        // temp.add(num[low]);
        // temp.add(num[high]);

        // res.add(temp);

        // while (low < high && num[low] == num[low + 1])
        // low++;
        // while (low < high && num[high] == num[high - 1])
        // high--;
        // low++;
        // high--;
        // } else if (sum(num[low], num[high]) < sum) {
        // low++;
        // } else {
        // high--;
        // }
        // }
        // }
        // }
        // return res;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (a.size() < 3)
            return res;
        Collections.sort(a);
        for (int i = 0; i < a.size() - 1; i++) {
            if (i == 0 || (i > 0 && (long) a.get(i) != (long) a.get(i - 1))) {
                int low = i + 1, high = a.size() - 1;
                long sum = (long) (0 - (long) a.get(i));
                while (low < high) {
                    if (((long) a.get(low)) + ((long) a.get(high)) == sum) {
                        ArrayList<Integer> a1 = new ArrayList<>();
                        a1.add(a.get(i));
                        a1.add(a.get(low));
                        a1.add(a.get(high));
                        res.add(a1);
                        while (low < high && (long) a.get(low) == (long) a.get(low + 1))
                            low++;
                        while (low < high && (long) a.get(high) == (long) a.get(high - 1))
                            high--;
                        low++;
                        high--;
                    } else if (((long) a.get(low)) + ((long) a.get(high)) < sum)
                        low++;
                    else
                        high--;
                }
            }
        }
        return res;
    }

    long sum(long a, long b) {
        return a + b;
    }
}
