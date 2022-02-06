import java.util.ArrayList;

/**
 * spiral
 */
public class spiral 
{
    static ArrayList<Integer> spiralPrint(int arr[][])
    {
        ArrayList<Integer> l=new ArrayList<>();

        int r=arr.length;
        int c=arr[0].length;
        int right=c-1, left=0, top=0, down=r-1;
        int x=1, n=r*c; 
        while(left<=right && top<=down && x<=n)
        {
            //left->right 
            if(x<=n)
            for(int i=left;i<=right;i++)
            {
                System.out.print(arr[top][i]+" ");
                x++;
            }
            

            //top->down
            top++;
            if (x <= n)
            for(int i=top;i<=down;i++ )
            {
                System.out.print(arr[i][right]+" ");
                x++;
            }

            //right-> left
            right--;
            if (x <= n)
            for (int i = right; i >= left; i--) {
                System.out.print(arr[down][i] + " ");
                x++;
            }
           

            //down-> top
            down--;
            if (x <= n)
            for(int i=down;i>=top;i--)
            {
                System.out.print(arr[i][left]+" ");
                x++;
            }
            left++;
        }
        return l;
    }
       
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
        int arr1[][]={{6 ,6 ,2 },
                     {28, 2 ,12,},
                     {26, 3, 28},
                      {7 ,22, 25},
                      { 3, 4 ,23}};
        System.out.println(spiralPrint(arr));
        
        System.out.println();
        System.out.println(spiralPrint(arr1));
        
    }
}