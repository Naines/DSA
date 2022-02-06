/**
 * pair_with_given_sum
 */
public class pair_with_given_sum {

    static int max = 100000;

    public static int countPairsWithDiffK(int arr[], int n, int k) {
        int count = 0;
        boolean hashmap[] = new boolean[max];
        for (int i = 0; i < n; i++)
            hashmap[arr[i]] = true;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            if (x - k >= 0 && hashmap[x - k])
                count++;
            if (x + k < max && hashmap[x + k])
                count++;
            hashmap[x] = false;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}