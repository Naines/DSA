public class max_product_subarray {
    public static void main(String[] args) {
        //int arr[]={-1,-2,-1,2,3,0};//12
        int arr[]={ -6, 4, -5, 8, -10, 0, 8};//0
        
        //n_neg, least_neg 
        int n_zero=0, n_neg=0, max_neg=Integer.MIN_VALUE;
        int prod=1;
        for(int i: arr)
        {
            if(i==0){  n_zero++; continue;}
            if(i<0){
                n_neg++;
                max_neg=Math.max(max_neg, i);
            }
            prod=prod*i;
        }
        //case 1: zero and 1 negative
        if(n_neg==1 && n_zero+n_neg==arr.length || n_zero==arr.length)    System.out.println(0);
        // case 2: product/least_neg if n_neg%2!=0
        else if(n_neg%2!=0) System.out.println(prod/max_neg);
        //case 3: product if(n_neg%2==0) 
        else System.out.println(prod);
    }
}
