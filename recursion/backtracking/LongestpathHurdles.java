import java.util.ArrayList;

public class LongestpathHurdles 
{
    static int max_dist=Integer.MIN_VALUE;
    static int xdir[]={-1,0,1,0};
    static int ydir[]={0, -1, 0, 1};
    static ArrayList<Integer> path=new ArrayList<>();
    static ArrayList<Integer> ans=new ArrayList<>();
    
    static void longestPath(int mat[][], boolean vis[][],int score[][],int r, int c, int x, int y,int dx, int dy, int dist)
    {
        if(x==dx && y==dy)
        {
            path.add(score[x][y]);
            if(dist>max_dist)
            {
                ans=new ArrayList<>(path);
                max_dist=dist;
            }
            path.remove(path.size()-1);
            return;
        }
        vis[x][y]=true;
        path.add(score[x][y]);
        for(int k=0;k<4;k++)
        {
            int cx=x+xdir[k];
            int cy=y+ydir[k];
            if(isLegal(mat, vis, r, c, cx, cy))
            {
                longestPath(mat, vis,score, r, c, cx, cy, dx, dy, dist+1);
            }
        }
        vis[x][y]=false;
        path.remove(path.size()-1);
    }
    public static void main(String[] args) 
    {
        int r=3, c=10;
        int mat[][]=new int[][]
        {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        disp(mat, r, c);
        boolean vis[][]=new boolean[r][c];
        int score[][]=new int[r][c];
        int count = 1;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                score[i][j] = count++;
        longestPath(mat, vis,score, r, c, 0,0,2,0,0);
        System.out.println(max_dist>0?max_dist+" \n"+ans: "false");
        //System.out.println(path);
    }
    static boolean isLegal(int mat[][], boolean vis[][], int r, int c, int x, int y )
    {
        return x>=0 && y>=0 && x<r && y<c && mat[x][y]!=0 && vis[x][y]==false;
    }
    
    static void disp(int mat[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
