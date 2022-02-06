import java.util.ArrayList;
import java.util.Scanner;

public class totalPathsTopToBottomRight 
{
    static ArrayList<Integer> path=new ArrayList<>();
    static int xdir[]={1,0};
    static int ydir[]={0,1};
    static void paths(int mat[][],boolean vis[][],int r, int c, int x, int y)
    {
        if(mat[x][y]==r*c)
        {
            path.add(mat[x][y]);
            System.out.println(path);
            path.remove(path.size()-1);
            return;
        }
        
        for(int k=0;k<2;k++)
        {
            int cx=x+xdir[k];
            int cy=y+ydir[k];
            if(isValid(cx, cy, r, c))
            {
                vis[cx][cy] = true;
                path.add(mat[x][y]);
                paths(mat, vis, r, c, cx, cy);
                vis[cx][cy]=false;
                path.remove(path.size()-1);
            }
        }

    }
    
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int mat[][]=new int[r][c];
        int count=1;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                mat[i][j]=count++;

        disp(mat, r, c);
        boolean vis[][]=new boolean[r][c];
        paths(mat, vis, r, c,0,0);

        sc.close();
    }
    static void disp(int mat[][], int r, int c)
    {
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
    static boolean isValid(int x,int y, int r, int c)
    {
        return x>=0 && y>=0 && x<r && y<c;
    }  
}
