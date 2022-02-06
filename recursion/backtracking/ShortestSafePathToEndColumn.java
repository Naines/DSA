import java.util.Arrays;
import java.util.Scanner;

public class ShortestSafePathToEndColumn 
{
    static int min_dist=Integer.MAX_VALUE;
    static int xdir[]={-1, 0, 1, 0};
    static int ydir[]={0 , -1,0, 1};
    static int r,c;
    


    static void find(int mat[][], boolean vis[][], int x, int y, int dist)
    {
        if(y==c-1)//path reached
        {
            
            min_dist=Math.min(dist, min_dist);
            return;
        }
        if(dist>min_dist)
        {
            return;
        }
        vis[x][y]=true;
        for(int k=0;k<4;k++)
        {
            int cx=x+xdir[k];
            int cy=y+ydir[k];
            if(isSafe(mat, vis, cx, cy))
            find(mat, vis, cx, cy, dist+1);
        }
        vis[x][y]=false;
    }
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         r=sc.nextInt();
         c=sc.nextInt();
        int mat[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            mat[i][j]=sc.nextInt();
        }

        boolean vis[][]=new boolean[r][c];
        
        unmark(mat);

        
        for(int i=0;i<r;i++)
        {
            if(mat[i][0]!=1) continue;
            //make vis false
            for(int j=0;j<r;j++)
            Arrays.fill(vis[j], false);

            find(mat, vis, i, 0, 0);

            if(min_dist==c-1)
            break;
        }
        System.out.println(min_dist==Integer.MAX_VALUE?"No path exists":"shortest distance ="+min_dist);
        sc.close();
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
    static boolean isSafe(int mat[][], boolean vis[][], int x, int y)
    {
        return x>=0 && y>=0 && x<r && y<c && mat[x][y]==1 && vis[x][y]==false;
    }
    static void unmark(int mat[][]) 
    {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++)
                        if (isValid(i + xdir[k], j + ydir[k]) && mat[i + xdir[k]][j + ydir[k]]!=0 )
                            mat[i + xdir[k]][j + ydir[k]] = -1;
                }
            }
        }
       
    }
    static void disp(int mat[][])
    {
        System.out.println("DISPLAYING MATRIX:");
        int r=mat.length;
        int c=mat[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static void disp(boolean mat[][]) {
      
        int r = mat.length;
        int c = mat[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
