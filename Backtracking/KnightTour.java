/**
 * KnightTour
 */
public class KnightTour {
   
    static int ans=0;
    static boolean solve(int mat[][], int n, int move, int r, int c)
    {
        //base case
        if(move>=n*n)
        {
            print(mat);
            ans++;
            return true;
        }
        int rdir[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int cdir[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        for(int i=0;i<8;i++)//8 possible directions from a cell at max
        {
            int next_r=r+rdir[i];
            int next_c=c+cdir[i];

            //System.out.println(next_r+" "+next_c);
            if(isSafe(mat, next_r, next_c)==true)
            {
                mat[next_r][next_c]= move+1;
                boolean future=solve(mat, n, move+1, next_r, next_c);
                if(future==true)  return true;
                else mat[next_r][next_c]=0;
            }
            //else goto next dir
        }
        return false;//coming here means no place is safe or solution cant exist
    }

    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        int n=5;
            System.out.println("for i= "+n);
            int mat[][] = new int[n][n];
            mat[0][0] = 1;
            if (solve(mat, n, 1, 0, 0) == true)
                print(mat);
            else
                System.out.println("Solution do not exist");
            System.out.println(ans);
        
    }
    static void print(int mat[][])
    {
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
        System.out.println('\n');
        
    }
    static boolean isSafe(int mat[][], int nr, int nc)
    {
        int r=mat.length;
        int c=mat[0].length;

        return nr>=0 && nr<r &&
                nc>=0 && nc<c &&
                mat[nr][nc]==0;
    }
}