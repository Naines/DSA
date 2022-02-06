public class find_only_single_in_arrayOf3 {

    // method 1:
    static void solve(int arr[]) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0)
                    sum++;
            }
            if (sum % 3 != 0) {
                ans |= (1 << i);
            }
        }
        System.out.println(ans);
    }

    // method 2:
    static void solve1(int arr[]) {
        int n = arr.length;
        int ones = 0, twos = 0;

        for (int i = 0; i < n; i++) {

            ones = ones ^ arr[i];

            ones = ones & (~twos);
            twos = twos ^ arr[i];
            twos = twos & (~ones);
        }
        System.out.println(ones);

    }

    public static void main(String[] args) {
        int arr[] = { 11, 11, 11, 2, 6, 6, 6, 8, 8, 8, 2, 2, 9, 9, 9, 1 };
        solve(arr);
        solve1(arr);
    }

}
