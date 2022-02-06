import java.util.ArrayDeque;
import java.util.Queue;

class rottenOrange {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int i = 0, j = 0;
        int apple = -1;
        Queue<Pair> q = new ArrayDeque<Pair>();
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    apple++;
                }
            }
        }
        if (apple == -1)
            return 0;

        int count = 0;
        while (q.size() > 0) {
            int size = q.size();
            // System.out.println(count + " --->");
            for (i = 0; i < size; i++) {
                Pair temp = q.remove();
                int r = temp.x, c = temp.y;

                // System.out.println(r + " " + c);
                if (r + 1 < n && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    q.add(new Pair(r + 1, c));
                    apple--;
                    // System.out.println(q);
                }
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    q.add(new Pair(r - 1, c));
                    apple--;
                    // System.out.println(q);
                }
                if (c + 1 < m && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    q.add(new Pair(r, c + 1));
                    apple--;
                    // System.out.println(q);
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    q.add(new Pair(r, c - 1));
                    apple--;
                    // System.out.println(q);
                }
            }
            // System.out.println(apple);
            count++;
        }
        // System.out.println(apple);
        return apple == 0 ? -1 : count - 1;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static void main(String[] args) {
        // [[2,1,1],[0,1,1],[1,0,1]]
        // [[2,1,1],[1,1,0],[0,1,1]]

        int grid[][] = { { 0 } };
        System.out.println(orangesRotting(grid));
    }
}