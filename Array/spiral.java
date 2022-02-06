public class spiral {
    static int[][] generateMatrix(int n) {
        int arr[][]=new int[n][n];
        
        int right=n, down=n, left=-1, top=0;
        int r=0, c=0, k=1;
        while(k<=n*n){
            
            while(c<right){
                arr[r][c]=k++;
                c++;
            }
            c=right-1;
            r++;

            while(r<down){
                arr[r][c]=k++;
                r++;
            }
            r=down-1;
            c--;

            //left
            while(c>left){
                arr[r][c]=k++;
                c--;
            }
            c=left+1;
            r--;

            
            //top
            while(r>top){
                arr[r][c]=k++;
                r--;
            }
            c++;
            r=top+1;

            
            right--;down--;left++;top++;
        }
        return arr;
    }
    public static void main(String[] args) {
        int n=7;
        int arr[][]=generateMatrix(n);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
