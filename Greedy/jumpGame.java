public class jumpGame {
    public static void main(String[] args) {
        int arr[]={2,3,1,1,4};

        //assumption: END is always reached
        int jumps=0, currFar=0, currEnd=0;
        int i;
        for(i=0;i<arr.length-1;i++){
            currFar=Math.max(i+arr[i], currFar);
            if(i==currEnd){
                //update currEnd
                currEnd=currFar;
                jumps++;
            }
        }
        System.out.println(jumps);
    }
}
