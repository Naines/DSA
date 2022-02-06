import java.lang.Math;
public class specificPair 
{
    static int findMaxPair(int arr[][])
    {
        int maxVal=Integer.MIN_VALUE;
        int r=arr.length;
        int c=arr[0].length;
        int a=0, b=0, d=r-1, e=c-1, x=arr[r-1][c-1];

        int maxarr[][]=new int[r][c];

        maxarr[r-1][c-1]=arr[r-1][c-1];

        for(int i=c-2; i>=0;i--) ///last col update
        {
            maxarr[r-1][i]=Math.max(arr[r-1][i], maxarr[r-1][i+1]);
            if (x < arr[r-1][i]) 
            {
                x = arr[r-1][i];
                d = r-1;
                e = i;
            }
        }
        for(int i=r-2;i>=0;i--) ///last row update
        {
            maxarr[i][c-1]=Math.max(arr[i][c-1], maxarr[i+1][c-1]);
            if (x < arr[i][c-1]) 
            {
                x = arr[i][c-1];
                d = i;
                e = c-1;
            }
        }
        
        for(int i=r-2; i>=0; i--)
        {
            for(int j=c-2;j>=0;j--)
            {
                //find max
                if(arr[i+1][j+1]-arr[i][j]> maxVal)
                {
                    maxVal = maxarr[i + 1][j + 1] - arr[i][j];
                    a=i; b=j;
                }
                

                //update
                maxarr[i][j]=max(arr[i][j], maxarr[i+1][j], maxarr[i][j+1]);

                if(x<maxarr[i][j])
                {
                    x=arr[i][j];
                    d=i;
                    e=j;
                }
            }
        }
        System.out.println(a+" "+b);
        System.out.println(d+" "+e);
        print(maxarr);
        return maxVal;

    }

    public static void main(String[] args) 
    {
        int arr[][] = { { 1, 2, -1, -4, -20 },
                      { -8, -3, 4, 2, 1 }, 
                      { 3, 8, 6, 1, 3 }, 
                      { -4, -1, 1, 7, -6 },
                      { 0, -4, 10, -5, 1 } 
                    };

        System.out.println(findMaxPair(arr));
    }


    ///////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    static void print(int arr[][])
    {
        int r=arr.length;
        int c=arr[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int max(int a, int b, int c)
    {
        int max=Integer.MIN_VALUE;
        max=(a>b)? ((a>c) ? a : c): ((b>c)?b: c); 
        return max;
    }
}
