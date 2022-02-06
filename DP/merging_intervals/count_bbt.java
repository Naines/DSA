import java.util.Arrays;

public class count_bbt {
    static int mod=(int)(1e9+7);
    static long count2(int h, long memo[]){
        if(h==0||h==1)return memo[h]=1;
        if(memo[h]!=-1)return memo[h];
        return memo[h]=mul(count2(h-1,memo),(add(mul(2,count2(h-2,memo)),count2(h-1,memo))));
    }
    static long mul(long a, long b) {
		return (a*b)%mod;
	}
    static long add(long a, long b) {
		return (a+b)%mod;
	}
    
    public static void main(String[] args) {
        int h=4;
        long memo[]=new long[h+1];
        Arrays.fill(memo, -1);
        System.out.println(count2(h, memo));
    }
}
