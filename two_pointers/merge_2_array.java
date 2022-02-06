import java.util.ArrayList;

public class merge_2_array {
    static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                i++;
            } else {
                a.add(i, b.get(j));
                i++;
                j++;
            }
            System.out.println(a);
        }
        while (j < b.size()) {
            a.add(i++, b.get(j++));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(-4);
        a.add(3);
        a.add(5);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(-2);
        b.add(-2);
        b.add(6);
        merge(a, b);
        System.out.println(a);
    }
}
