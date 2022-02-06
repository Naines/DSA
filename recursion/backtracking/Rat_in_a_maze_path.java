
import java.util.ArrayList;
import java.util.Scanner;

public class Rat_in_a_maze_path {
    static ArrayList<String> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public static ArrayList<String> findPath(int[][] maze, int n) {
        boolean vis[][] = new boolean[n][n];

        solve(maze, vis, n, 0, 0, "");
        ArrayList<String> dup=(ArrayList<String>)list.clone();
        list.clear();
        return dup;
    }

    static void solve(int maze[][], boolean vis[][], int n, int x, int y, String str) 
    {
        if(!isLegal(maze, vis, n, x, y))
        return;
        if (x == n - 1 && y == n - 1) {
            list.add(str);
            return;
        }
        
        vis[x][y] = true;
        solve(maze, vis, n, x + 1, y, str + "D");
        solve(maze, vis, n, x, y - 1, str + "L");
        solve(maze, vis, n, x, y + 1, str + "R");
        solve(maze, vis, n, x - 1, y, str + "U");
        vis[x][y] = false;

    }

    static boolean isLegal(int maze[][], boolean vis[][], int n, int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n && vis[x][y] == false && maze[x][y] == 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt=sc.nextInt();
        while(tt-->0)
        {
            int n = sc.nextInt();
            int maze[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }
            ArrayList<String> ans = findPath(maze, n);
            for (String s : ans)
                System.out.println(s);
        }
        
         sc.close();
    }
}
