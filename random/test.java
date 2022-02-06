import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static int anagram(String s) {
        char chs[] = s.toCharArray();
        if (chs.length % 2 != 0)
            return -1;
        int hash1[] = new int[26];
        int hash2[] = new int[26];
        int n = chs.length;
        for (int i = 0; i < n / 2; i++) {
            hash1[chs[i] - 'a']++;
            hash2[chs[n - i - 1] - 'a']++;
        }
        int ca = 0, cb = 0;
        // System.out.println(Arrays.toString(hash));
        for (int i = 0; i < 26; i++) {
            int min = Math.min(hash1[i], hash2[i]);
            if (hash1[i] != 0 && hash2[i] != 0) {
                hash1[i] -= min;
                hash2[i] -= min;
            }
            ca += hash1[i];
            cb += hash2[i];
        }

        return Math.min(ca, cb);
    }

    // abcx dexx
    // 1110 011

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String str = sc.next();
            System.out.println(anagram(str));
        }
        sc.close();

    }
}
