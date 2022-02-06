import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class candles {
    public static int birthdayCakeCandles(List<Integer> candles) {
        int n = candles.size();
        int count[] = new int[(int) 10e7 + 1];
        for (int i : candles)
            count[i]++;

        System.out.println(Arrays.toString(count));
        int ans = 0;
        for (int i : count)
            ans = Math.max(ans, i);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(sc.nextInt());
        System.out.println(birthdayCakeCandles(list));
        sc.close();
    }

}
