public class countAndSay_INCOMPLETE {
    static String countAndSay_(int A) {
        char chs[] = (A + "").toCharArray();
        int n = chs.length;
        String ans = "";
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i + 1 < n && chs[i + 1] == chs[i]) {
                i++;
                count++;
            }
            ans += count;
            ans += chs[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(countAndSay_(n));
    }
}
