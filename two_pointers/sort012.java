import java.util.ArrayList;

public class sort012 {
    static void sortColors(ArrayList<Integer> a) {
        int low = 0, high = a.size() - 1;
        int i = 0;
        while (i <= high) {
            int x = a.get(i);
            if (x == 0) {

                a.set(i, a.get(low));
                a.set(low, x);
                low++;
                i++;

            } else if (x == 2) {

                a.set(i, a.get(high));
                a.set(high, x);
                high--;

            } else {
                i++;
            }
        }
    }

    static void sortColors1(ArrayList<Integer> a) {
        int i = 0;
        int low = 0;
        int high = a.size() - 1;
        while (i <= high) {
            if (a.get(i) == 0) {

                int temp = a.get(i);
                a.set(i, a.get(low));
                a.set(low, temp);
                low++;
                i++;

            } else if (a.get(i) == 2) {

                int temp = a.get(i);
                a.set(i, a.get(high));
                a.set(high, temp);
                high--;

            } else {
                i++;
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(0);
        a.add(2);
        sortColors(a);

        System.out.println(a);
    }
}
