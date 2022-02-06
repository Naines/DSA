import java.util.Scanner;
/**
 * 
 * 5 3 0 0 7 0 0 0 0
    6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 1 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9


answer:
534678912
672195348
198342567
859761423
426853791
713924856
961537284
287419635
345286179
 */
public class suduko {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int board[][]=new int[9][9];
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                board[i][j]=sc.nextInt();
        

        solve(board, 0,0);
        sc.close();
    }
    static void solve(int board[][], int x, int y)
    {
        if(x==board.length)
        {
            print(board);
            return;
        }
        
        int cx=0,cy=0;
        if(y==board[0].length-1)
        {
            cx=x+1;
            cy=0;
        }else{
            cx=x;
            cy=y+1;
        }

        if(board[x][y]!=0)
        {
            //solve next..this is already marked
            solve(board, cx, cy);
        }else{
            for(int k=1;k<=9;k++)
            {
                if(isValid(board,x,y,k))
                {
                    board[x][y]=k;
                    solve(board, cx, cy);
                    board[x][y]=0;//backtarcking
                }
            }
        }

    }
    static boolean isValid(int board[][], int x, int y, int k)
    {
        //check column
        for(int j=0;j<9;j++)    if(board[x][j]==k)  return false;

        //check row
        for(int i=0;i<9;i++)    if(board[i][y]==k)  return false;

        //check grid
        int gridx=x/3*3, gridy=y/3*3;
        for(int i=0;i<9;i++)
        {
            if(board[gridx+i/3][gridy+i%3]==k)
            return false;
        }
        return true;
    }
    static void print(int board[][])
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
