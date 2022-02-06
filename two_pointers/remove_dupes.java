import java.util.ArrayList;

public class remove_dupes {
    static int removeDuplicates(ArrayList<Integer> a) {
        int i = 1;
        while (i < a.size()) {
            // if diff ,i++ continue;
            System.out.println(a.get(i) + " " + a.get(i - 1));
            System.out.println(a.get(i) == (a.get(i - 1)));
            if (!(a.get(i).equals(a.get(i - 1)))) {
                i++;
            } else {
                System.out.println("i=" + i);
                a.remove(i);
            }
            System.out.println(a);
        }
        return a.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5000);
        a.add(5000);
        a.add(5000);
        System.out.println(removeDuplicates(a));
        // System.out.println(a);
    }
}
