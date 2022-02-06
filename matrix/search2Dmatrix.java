public class search2Dmatrix 
{
    /**this method assumes sorted array in linear way using maths
     * Drawbacks: 
     * -expensive ops: * %
     * -overflow: r*c
     * 
     * log(mn)
     */
    static boolean search1(int arr[][], int key)
    {
        int r=arr.length;
        int c=arr[0].length;
        if(r==0 || c==0)
        return false;
        int lb=0;
        int ub= r*c-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;         //lb, ub,mid are index when 2d assumed in 1d
            int midVal=arr[mid/c][mid%c]; ///logic:  let mid=i* c +j ==> hence i=mid/i and j=mid%c
            if(midVal==key)
            return true;
            else
            if(midVal>key)
            ub=mid-1;
            else lb=mid+1;
            
        }
        return false;
    }
    
    /**
     * start from top right and search row range and hence incre-drecre the i, j val
     * while() true if i<r and c>=0 (top right to down left worst case) 
     * O(m+n)
     */
    static boolean search2(int arr[][], int key)//O(m+n) 
    {
        int r=arr.length;
        int c=arr[0].length;
        if (r == 0 || c == 0)
            return false;
        int i=0, j=c-1;
        while(i<r && j>=0)
        {
            if(arr[i][j]==key)
            return true;
            else if(arr[i][j]>key)//search in same row
            j--;
            else //search in next row as arr[i][j]<key
            i++;
        }

        return false;
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(search1(arr, 6));
        System.out.println(search1(arr, 67));
        System.out.println(search1(arr, 0));
        System.out.println(search1(arr, 9));
        System.out.println(search1(arr, 1));
        System.out.println();
        System.out.println(search2(arr, 6));
        System.out.println(search2(arr, 67));
        System.out.println(search2(arr, 0));
        System.out.println(search2(arr, 9));
        System.out.println(search2(arr, 1));
    }
}
