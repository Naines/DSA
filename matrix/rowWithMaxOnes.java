public class rowWithMaxOnes 
{
    static void countNaive(int arr[][])
    {
        int r=arr.length;
        int c=arr[0].length;
        int max=Integer.MIN_VALUE;
        int rowNumber=-1;
        for(int i=0;i<r;i++)
        {
            int count=0;
            for(int j=0;j<c;j++)
            {
                if(arr[i][j]==1)
                count++;
            }
            if(count> max)
            {
                rowNumber=i;
                max=count;
            }
            
        }
        if(max==0)
        rowNumber=-1;
        System.out.println("Maximum number of ones contained in row "+rowNumber+" = "+max);
    }
    
    static void countBinary(int arr[][])
    {
        int r=arr.length;
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0; i<r; i++)
        {
            int count=countOcc(arr[i], 1);
            if(count> max)
            {
                max=count;
                index=i;
            }
        }
        if (max == 0)
            index = -1;
        System.out.println("Maximum number of ones contained in row " +index + " = " + max);
    }
    static void countonesOptimized(int arr[][])//O(m+n)
    {
        int c=arr[0].length;
        int r=arr.length;
        int j=first(arr[0],1);
        int index_max=0;
        if(j==-1)//no ones in first row
        j=c-1;    //we begin from rightmost in second row

        for(int i=0;i<r;i++)
        {
            while(j>=0 && arr[i][j]==1)
            {
                j--;
                index_max = i;
            }
        }
        if((c-j-1)==0)
        index_max=-1;
        System.out.println("Maximum number of ones contained in row " + index_max+ " = " + (c-j-1));
    }
    public static void main(String[] args) {
       // int arr[][]={{0,1,1,1},{0,0,1,1},{0,1,1,1},{0,0,0,0}};
       int arr[][]={{0,0,0,0}};
        countNaive(arr);//m*n
        countBinary(arr);//nlogn
        countonesOptimized(arr);//m+n
    }
    
    ////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    static int first(int arr[], int k) {
        int lb = 0, ub = arr.length - 1;
        int ans = -1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] >= k)// ele >=k found now best possibel found but we continue looking to the left
            {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return ans;
    }
    static int firstOcc(int arr[], int k) {
        int lb = 0, ub = arr.length - 1;
        int ans = arr.length;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] >= k)// ele >=k found now best possibel found but we continue looking to the left
            {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return ans;
    }

    static int countOcc(int arr[], int k) {
        int first = firstOcc(arr, k);
        int last = firstOcc(arr, k + 1);
        return (last - first);
    }
}
