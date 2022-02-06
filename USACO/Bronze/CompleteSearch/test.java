public class test {
    public static void main(String[] args) {
        int[] students = { 4, 9, 5, 3, 2, 10 };
        int n = students.length;

        System.out.println(solve(students, n));

    }

    static int[] solve(int arr[], int n) {
        int rank[] = new int[n];
        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    counter++;
                }
            }
            rank[i] = counter;
            // System.out.print(counter + " ");
        }
        return rank;
    }
}