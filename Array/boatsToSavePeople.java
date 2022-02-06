import java.util.Arrays;

public class boatsToSavePeople {

    /**
     * O(nlogn) solution -> sorts and applies two pointer method
     * i front and j rear
     * i, j changes when both front and rear included
     * j changes evertime regardless as heavy person is always included.
     */

    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            boats++;
        }
        return boats;
    }

    /**
     * O(n) solution which uses bucket sort+ two pointer technique.
     * start and end applied to while loop eveytime to ensure valid start and end
     * again start++ and end-- happens if both included else
     * end-- happens everytime regardless
     */
    static int numRescueBoats1(int[] people, int limit) {
        int bucket[] = new int[limit + 1];
        for (int p : people)
            bucket[p]++;
        int start = 0;
        int end = limit;
        int ans = 0;
        while (start <= end) {
            while (start <= end && bucket[start] <= 0)
                start++;
            while (start <= end && bucket[end] <= 0)
                end--;

            if (bucket[start] <= 0 && bucket[end] <= 0)
                break;

            ans++;
            if ((start + end) <= limit)
                bucket[start]--;
            bucket[end]--;

        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 4, 2 };
        int limit = 6;
        System.out.println(numRescueBoats(arr, limit));
        System.out.println(numRescueBoats1(arr, limit));
    }
}
