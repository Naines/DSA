//1. O(n*m)
//2. O(n*n)
class longest_common_prefix {
    static String solve(String strs[]) {
        String x = strs[0];
        // int n1=x.length;
        int i = 1;
        int n = strs.length;
        String ans = x;
        while (i < n) {
            String temp = "";
            for (int k = 0; k < Math.min(ans.length(), strs[i].length()); k++) {
                if (ans.charAt(k) != strs[i].charAt(k))
                    break;
                else {
                    temp += ans.charAt(k);
                }
            }
            ans = temp;
            i++;
        }
        return ans;
    }

    static String solve2(String strs[]) {
        char chs[] = strs[0].toCharArray();
        String ans = "";
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            int j = 1;
            for (j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i))
                    break;
                else {
                    ans += c;
                }
            }
            if (j != strs.length) {
                break;
            }
        }
        return ans;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c)
                    return sb.toString();
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String ans[] = { "flower", "fl", "flowers" };
        System.out.println(solve(ans));
    }
}