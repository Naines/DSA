import java.util.Arrays;

public class matrix_largest_1 {
    static void printMaxSubSquare(int arr[][]){
        int r=arr.length, c=arr[0].length;
        int max=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                max=Math.max(max, helper(arr, i, j));
            }
        }
        System.out.println(max);
    }

    //dfs
    static int helper(int arr[][], int x, int y){
        if(x<0 || y<0 || x>=arr.length || y>=arr[0].length || arr[x][y]==0)
        return 0;
        
        return Math.min(helper(arr, x+1,y+1), Math.min(helper(arr, x+1, y),helper(arr, x, y+1)))+1;

    }
    static void printMaxSubSquare1(int arr[][]){
        int r=arr.length, c=arr[0].length;
        int max=0;
        int memo[][]=new int[r+1][c+1];
        for(int i[]:memo)Arrays.fill(i, -1);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                max=Math.max(max, helper1(arr, i, j,memo));
            }
        }
        System.out.println(max);
    }

    //dfs
    static int helper1(int arr[][], int x, int y,int memo[][]){
        if(x<0 || y<0 || x>=arr.length || y>=arr[0].length || arr[x][y]==0)
        return memo[x][y]=0;
        if(memo[x][y]!=-1)return memo[x][y];
        return memo[x][y]=Math.min(helper1(arr, x+1,y+1,memo), Math.min(helper1(arr, x+1, y,memo),helper1(arr, x, y+1,memo)))+1;

    }
    static void printMaxSubSquare3(int arr[][]){
        int r=arr.length, c=arr[0].length;
        int max=0;
        int dp[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0||j==0)dp[i][j]=arr[i][j];
                else{
                    if(arr[i][j]==1){
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1]))+1;
                        max=Math.max(max, dp[i][j]);
                    }
                    
                }
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
         int M[][] = {{0, 1, 1, 0, 1},
                    {1, 1, 0, 1, 0},
                    {0, 1, 1, 1, 0},
                    {1, 1, 1, 1, 0},
                    {1, 1, 1, 1, 1},
                    {0, 0, 0, 0, 0}};
             
        printMaxSubSquare(M);
        printMaxSubSquare1(M);
        printMaxSubSquare3(M);
    }
}
