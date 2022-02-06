import java.util.Arrays;

public class dsu_test {
    public static void main(String[] args) {
        dsu ob = new dsu(10);
        System.out.println(Arrays.toString(ob.parent));
        ob.union(1, 2);
        System.out.println(Arrays.toString(ob.parent));
        System.out.println(ob.union(1, 2));
        System.out.println(ob.union(1, 3));
        System.out.println(Arrays.toString(ob.parent));

        System.out.println(ob.union(1, 2));
        System.out.println(ob.union(1, 3));
        System.out.println(ob.union(2, 3));
        System.out.println(Arrays.toString(ob.parent));
    }

    static class dsu {
        int parent[];

        dsu(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        boolean union(int a, int b) {
            if ((a = find(a)) == (b = find(b)))
                return false;
            parent[find(a)] = parent[find(b)];
            return true;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

    }
}
