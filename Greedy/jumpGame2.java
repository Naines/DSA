public class jumpGame2 {
    public static void main(String[] args) {
        int arr[]={3,2,4,0,4};
        int j=arr.length-1;
        for(int i=arr.length-2;i>=0;i--)
        {
            if(arr[i]+i >= j)
            j=i;
           
        }
        if(j==0)
        System.out.println(true);
        else System.out.println(false);
    }
}
