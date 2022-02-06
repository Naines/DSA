import java.util.ArrayList;
import java.util.Arrays;

public class min_max_exp {

    static int find_max(int i, int j, ArrayList<Integer> nums, ArrayList<Character> ops) {
        if (i == j)
            return nums.get(i);
        int res = 0;
        for (int k = i; k < j; k++) {
            int x = 0;
            if (ops.get(k) == '+') {
                x = find_max(i, k, nums, ops) + find_max(k + 1, j, nums, ops);
            } else {
                x = find_max(i, k, nums, ops) * find_max(k + 1, j, nums, ops);
            }
            res = Math.max(res, x);
        }
        return res;

    }

    static int find_min(int i, int j, ArrayList<Integer> nums, ArrayList<Character> ops) {
        if (i == j)
            return nums.get(i);
        int res = (int) 1e8;
        for (int k = i; k < j; k++) {
            int x = 0;
            if (ops.get(k) == '+') {
                x = find_min(i, k, nums, ops) + find_min(k + 1, j, nums, ops);
            } else {
                x = find_min(i, k, nums, ops) * find_min(k + 1, j, nums, ops);
            }
            res = Math.min(res, x);
        }
        return res;
    }

    static int find_max1(int i, int j, ArrayList<Integer> nums, ArrayList<Character> ops, int memo[][]) {
        if (i == j)
            return memo[i][j] = nums.get(i);
        if (memo[i][j] != -1)
            return memo[i][j];
        int res = 0;
        for (int k = i; k < j; k++) {
            int x = 0;
            if (ops.get(k) == '+') {
                x = find_max1(i, k, nums, ops, memo) + find_max1(k + 1, j, nums, ops, memo);
            } else {
                x = find_max1(i, k, nums, ops, memo) * find_max1(k + 1, j, nums, ops, memo);
            }
            res = Math.max(res, x);
        }
        return memo[i][j] = res;

    }

    static int find_min1(int i, int j, ArrayList<Integer> nums, ArrayList<Character> ops, int memo[][]) {
        if (i == j)
            return memo[i][j] = nums.get(i);
        if (memo[i][j] != -1)
            return memo[i][j];
        int res = (int) 1e8;
        for (int k = i; k < j; k++) {
            int x = 0;
            if (ops.get(k) == '+') {
                x = find_min(i, k, nums, ops) + find_min(k + 1, j, nums, ops);
            } else {
                x = find_min(i, k, nums, ops) * find_min(k + 1, j, nums, ops);
            }
            res = Math.min(res, x);
        }
        return memo[i][j] = res;
    }

    public static void main(String[] args) {
        String str = "3+4*5";
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        String temp = "";
        for (char c : str.toCharArray()) {
            if (isOperator(c)) {
                ops.add(c);
                nums.add(Integer.parseInt(temp));
                temp = "";
            } else
                temp += c;
        }
        nums.add(Integer.parseInt(temp));
        int res = find_max(0, nums.size() - 1, nums, ops);
        int res1 = find_min(0, nums.size() - 1, nums, ops);

        System.out.println(res + " " + res1);

        int n = nums.size();
        int memo1[][] = new int[n][n];
        int memo2[][] = new int[n][n];
        for (int i[] : memo1)
            Arrays.fill(i, -1);
        for (int i[] : memo2)
            Arrays.fill(i, -1);

        System.out.print(find_max1(0, n - 1, nums, ops, memo1) + " ");
        System.out.println(find_min1(0, n - 1, nums, ops, memo2));

    }

    static boolean isOperator(char c) {
        switch (c) {
            case '*':
            case '+':
                return true;
            default:
                return false;
        }
    }
}
