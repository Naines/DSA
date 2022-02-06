import java.util.ArrayList;

public class pascalTriangle {
    static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> ar;
        for (int i = 0; i < A; i++) {
            ar = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    ar.add(1);
                else
                    ar.add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j));
            }
            arr.add(ar);
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(solve(n));
    }
}
