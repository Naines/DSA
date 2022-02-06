

import java.util.Scanner;

class Nqueens
{
    static void solve(int n)
    {
        boolean grid[][]=new boolean[n][n];
        backtrack(grid, n, 0);
    }
    static int ans=0;
    static void backtrack(boolean grid[][], int n, int cr)
    {
        if(cr==n)
        {
            ans++;
            print(grid, n);
            return;
        }
       
        for(int i=0;i<n;i++)
        {
            if(isLegal(grid, n, cr, i))
            {
                grid[cr][i]=true;
                backtrack(grid, n, cr+1);
                grid[cr][i]=false;
            }
           
        }
    }
    static boolean isLegal(boolean grid[][], int n, int r, int c)
    {
        //overhead attack check
        for(int i=r-1;i>=0;i--)  if(grid[i][c]) return false;
        
        //upper left diagonal
        for(int i=r-1,j=c-1;j>=0 && i>=0; i--,j--) if(grid[i][j])   return false;
        //upper right diagonal
        for (int i = r - 1, j = c + 1; j < n  && i >= 0; i--,j++)
            if (grid[i][j])
                return false;
        //no need for sideways check here
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        solve(n);
        System.out.println(ans);
        sc.close();
    }
    static void print(boolean grid[][], int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==true)    System.out.print('Q'+" ");
                else System.out.print('.'+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}