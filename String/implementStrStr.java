public class implementStrStr {
    static int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        if (haystack.length() > 0 && needle.length() == 0)
            return 0;
        int n = haystack.length();
        int k = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (k < needle.length() && needle.charAt(k) == haystack.charAt(i)) {
                if (ans == -1)
                    ans = i;
                k++;
            } else {
                k = 0;
                ans = -1;
            }
            System.out.println(haystack.charAt(i) + " " + ans);
            if (k == needle.length())
                return ans;
        }
        return -1;
    }

    // "mississippi"
    // "issip"
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }
}
