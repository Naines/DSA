import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_Method1 {
    /**using brute force of all possibilities by iteration*/
    public static void main(String[] args) {
        int n=1;
        System.out.println(readBinaryWatch(n));
    }
    
    public static List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num)
                    ans.add(String.format("%d:%02d", i, j));
            }
        }
        return ans;

    }
}
