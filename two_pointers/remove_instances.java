import java.util.ArrayList;

public class remove_instances {

    static public int removeElement(ArrayList<Integer> a, int b) {
        int len = 0;
        for (int i = 0; i <= a.size() - 1; i++) {
            if ((int) a.get(i) != b) {
                a.set(len, a.get(i));
                len++;
            }
        }
        a = new ArrayList<Integer>(a.subList(0, len));
        return len;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(1);
        a.add(2);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(3);
        removeElement(a, 1);
        System.out.println(a);
    }
}
