import java.util.ArrayList;

public class median_two_array {
    
    static double findMedianSortedArrays(final ArrayList<Integer> a, final ArrayList<Integer> b) {
	     int n=a.size(), m=b.size();
	     if(n>m)return findMedianSortedArrays(b, a);
	     int low=0, high=n;
	     while(low<=high){
	         int p1=(low+high)/2;
	         int p2=(m+n+1)/2 - p1; //ceil value
	         
	         int maxX=(p1==0)?Integer.MIN_VALUE: a.get(p1-1);
	         int maxY=(p2==0)?Integer.MIN_VALUE:b.get(p2-1);
	         int minX=(p1==n)?Integer.MAX_VALUE:a.get(p1);
	         int minY=(p2==m)?Integer.MAX_VALUE:b.get(p2);
	         if(maxX<=minY && maxY<=minX){
	             if((n+m)%2==0){
	                 return (((double)(Math.max(maxX, maxY))+(double)(Math.min(minX, minY))) /2);
	             }else{
	                 return Math.max(maxX,maxY);
	             }
	         }else if(maxX>minY){
                  
	             //go left
	             high=p1-1;
	         }else{
                  
	             //go right
	             low=p1+1;
	         }
	     }
	     return 0.0;
	     
	}
  public static void main(String[] args) {
      int arr[]={1,4,5};
      int brr[]={2,3};
      ArrayList<Integer> a=new ArrayList<>();
      for(int i: arr)a.add(i);
      
      ArrayList<Integer> b=new ArrayList<>();
     for(int i: brr)b.add(i);
    //   System.out.println(median(arr, brr));
      System.out.println(findMedianSortedArrays(a,b));
  }
}
