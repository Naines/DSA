public class RatInAMaze {
    public static void main(String[] args) {

        /** 0 - represents blocked,
         * 1-represents not blocked
         */
        int maze[][]={{1,1,1},{0,0,0},{0,0,1}};
        // int maze[][] = 
        // {{1, 0, 0, 0},
        //  {1, 0, 0, 1}, 
        //  {1, 1, 0, 0},
        //  {0, 1, 1, 1}};
        //int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
        //int maze[][] = {{1, 0},{1, 0}};
        int n=maze.length;
        int sol[][] = new int[n][n];
       // System.out.println(solve1(maze,sol, maze.length, 0, 0));
       System.out.println(solve(maze, sol, maze.length, 0, 0));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
        // RESET SOL
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = 0;
            }
        }
        System.out.println(solve1(maze, sol, maze.length, 0, 0));
    }
   
    static int rdir[]={1,0};
    static int cdir[]={0,1};
   
    static boolean solve(int maze[][],int sol[][], int n, int r, int c)
    {
        if(r==n-1 && c==n-1)    return true;
        for(int i=0;i<2;i++)
        {
            int nextr=r+rdir[i];
            int nextc=c+cdir[i];
            if(isSafe(maze, n, nextr, nextc))
            {
                sol[nextr][nextc]=1;//mark visit
                

                boolean future=solve(maze,sol, n, nextr, nextc);
                if(future)  return true;

                //else backtrack;
                sol[nextr][nextc]=1;
            }
            
        }
        return false;
    }
    private static boolean isSafe(int[][] maze, int n, int nextr, int nextc) {
        return nextr>=0 && nextr<n  
                && nextc>=0 && nextc<n &&
                maze[nextr][nextc]==1;
    }
    ///////////////////////////////////////////////////////////////////
    /**           SECOND APPROACH                                    */
    ///////////////////////////////////////////////////////////////////
    
    static boolean solve1(int maze[][], int sol[][], int n, int x, int y) {
        if (x == n - 1 && y == n - 1)
        {
            sol[x][y]=1;
            return true;
        }

        if (isSafe(maze, n, x, y)) 
        {
            if (sol[x][y] == 1)
                return false;

            sol[x][y] = 1;

            if (solve1(maze, sol, n, x + 1, y))
                return true;
            if (solve1(maze, sol, n, x, y + 1))
                return true;

            sol[x][y] = 0;
            return false;
        }
        return false;
    }
}
