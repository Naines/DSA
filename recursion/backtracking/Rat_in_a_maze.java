

import java.util.Scanner;

public class Rat_in_a_maze {


    static int solve(int maze[][], int n)
    {
        boolean vis[][]=new boolean[n][n];
        
        backtrack(maze, vis, n, 0,0);
        return ans;
    }
    static int xdir[]={0,1,0,-1};
    static int ydir[]={-1,0,1,0};
    static int ans=0;
    static void backtrack(int maze[][], boolean vis[][], int n, int x, int y)
    {
        //end reached
        if(x==n-1 && y==n-1)
        {
            ans++;
            return;
        }

        for(int k=0;k<4;k++)
        {
            int cx = x + xdir[k];
            int cy = y + ydir[k];

            if(isLegal(maze, vis, n, cx, cy))
            {
                vis[cx][cy]=true;
                backtrack(maze, vis, n, cx, cy);
                vis[cx][cy]=false;
            }
        }
    }
    static boolean isLegal(int maze[][], boolean vis[][], int n, int x, int y)
    {
        return x>=0 && y>=0 && x<n && y<n && vis[x][y]==false && maze[x][y]==1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int maze[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                maze[i][j]=sc.nextInt();
            }
        }
        System.out.println(solve(maze,n));
        sc.close();
    }
}
