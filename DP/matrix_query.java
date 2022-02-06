

/**
 * matrix_query
 */
public class matrix_query {

    public static void main(String[] args) 
    {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int up_left_sum[][]=new int[arr.length][arr[0].length];
        for(int i=1;i<up_left_sum.length;i++)
        {
            for(int j=1;j<up_left_sum[0].length;j++)
            {
                up_left_sum[i][j]=up_left_sum[i-1][j]+
                                    up_left_sum[i][j-1]+
                                    arr[i-1][j-1]-up_left_sum[i-1][j-1];   //- because it has been added twice

            }
        }

        int r1=0;
        int c1=1;
        int r2=2;
        int c2=2;
        int ans=up_left_sum[r2+1][c2+1]-up_left_sum[r1][c2+1]
                -up_left_sum[r2+1][c1]+up_left_sum[r1][c1];   //+ because extra minus happens for sum[r1][c1]

        System.out.println(ans);
    }

}