import java.util.Arrays;

public class count_balanced_bst {
    static int mod=(int)(1e9+7);
    static int count(int h){
        if(h==0||h==1)return 1;
        return count(h-1)*(2*count(h-2)+count(h-1));
    }
    static int count1(int h, int memo[]){
        if(h==0||h==1)return memo[h]=1;
        if(memo[h]!=-1)return memo[h];
        return memo[h]=count1(h-1,memo)*(2*count1(h-2,memo)+count1(h-1,memo));
    }
    static long count2(int h, long memo[]){
        if(h==0||h==1)return memo[h]=1;
        if(memo[h]!=-1)return memo[h];
        return memo[h]=mul(count2(h-1,memo),(2*count2(h-2,memo)+count2(h-1,memo)));
    }
    static long mul(long a, long b) {
		return (a*b)%mod;
	}
    public static void main(String[] args) {
        int h=4;
        System.out.println(count(h));

        int memo[]=new int[h+1];
        Arrays.fill(memo, -1);
        System.out.println(count1(h, memo));
    }
}
