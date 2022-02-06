/**
 * numberOfProvince
 */
public class numberOfProvince {

    static int solve(int adj[][]) {
        int n = adj.length;
        dsu ob = new dsu(n);

        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((adj[i][j] == 1) && ob.union(i, j) == false) {
                    count++;
                }
            }
        }
        return count;
    }

    static class dsu {
        int parent[], rank[];

        dsu(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        boolean union(int a, int b) {
            int arep = find(a);
            int brep = find(b);
            if (arep == brep)
                return false;
            parent[arep] = brep;
            return true;
        }
    }

    public static void main(String[] args) {
        int adj[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        System.out.println(solve(adj));
    }
}