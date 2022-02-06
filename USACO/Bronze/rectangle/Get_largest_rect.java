import java.util.ArrayList;
import java.util.List;

public class Get_largest_rect {
    public static int get_largest(List<List<Double>> list, double th) {
        int n = list.size();
        Rect r[] = new Rect[n];
        for (int i = 0; i < n; i++) {
            r[i] = new Rect(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3));
        }
        Rect x = new Rect(0, 0, 0, 0);
        double ans = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (r[i].intersect(r[j]).area() >= th && r[i].intersect(r[j]).union(x) >= ans) {
                    ans = r[i].intersect(r[j]).union(x);
                    x = r[i].intersect(r[j]).intersect(x);
                }
            }
        }
        System.out.println(ans);
        System.out.println(x.area());
        return (int) x.area();
    }

    public static void main(String[] args) {
        List<List<Double>> list = new ArrayList<>();
        List<Double> l1 = new ArrayList<>();
        List<Double> l2 = new ArrayList<>();
        List<Double> l3 = new ArrayList<>();
        l1.add(0.0);
        l1.add(0.0);
        l1.add(4.0);
        l1.add(4.0);

        l2.add(5.0);
        l2.add(5.0);
        l2.add(7.0);
        l2.add(7.0);

        l3.add(2.0);
        l3.add(5.0);
        l3.add(6.0);
        l3.add(9.0);

        list.add(l1);
        list.add(l2);
        list.add(l3);

        double th = 2.5;
        System.out.println(get_largest(list, th));

    }

    static class Rect {
        double x1, y1, x2, y2;

        Rect(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        double area() {
            return ((x2 - x1) * (y2 - y1));
        }

        Rect intersect(Rect a) {
            Rect t = new Rect(Math.max(x1, a.x1), Math.max(y1, a.y1), Math.min(x2, a.x2), Math.min(y2, a.y2));
            return t.x2 >= t.x1 && t.y2 >= t.y1 ? t : new Rect(0, 0, 0, 0);
        }

        double union(Rect ob) {
            return this.area() + ob.area() - intersect(ob).area();
        }

        double intersect(Rect a, Rect b, Rect c) {
            double xOverlap = Math.max(Math.min(Math.min(a.x2, b.x2), c.x2) - Math.max(Math.max(a.x1, b.x1), c.x1), 0);
            double yOverlap = Math.max(Math.min(Math.min(a.y2, b.y2), c.y2) - Math.max(Math.max(a.y1, b.y1), c.y1), 0);
            return xOverlap * yOverlap;
        }

        public String toString() {
            return this.x1 + " " + this.y1 + " " + this.x2 + " " + this.y2;
        }
    }
}
