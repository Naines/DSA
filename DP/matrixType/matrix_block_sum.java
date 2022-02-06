class matrix_block_sum{
    public static void main(String[] args) {
        int r=3,c=3;
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        int sum[][]=new int[r+1][c+1];
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]+arr[i-1][j-1]-sum[i-1][j-1];
            }
        }
        int k=1;
        int ans[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int r1 = Math.max(0, i - k), c1 = Math.max(0, j - k);
                int r2 = Math.min(r-1, i + k), c2 = Math.min(c-1, j + k);
                r1++;r2++;c1++;c2++;//1 -based indexing in sum
                ans[i][j] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        }

        disp(sum);
        disp(ans);
    }
    static void disp(int arr[][]){
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}