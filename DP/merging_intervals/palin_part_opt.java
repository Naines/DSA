public class palin_part_opt {
    static int minCut(String s) {
        if (s.length() == 0)
            return 0;
        int[] c = new int[s.length() + 1]; // number of cuts for the first k characters
        for (int i = 0; i < s.length(); i++)
            c[i] = Integer.MAX_VALUE;
        c[s.length()] = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int a = i, b = i; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) // odd length
                                                                                                     // palindrome
                c[a] = Math.min(c[a], 1 + c[b + 1]);
            for (int a = i, b = i + 1; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) // even length
                                                                                                         // palindrome
                c[a] = Math.min(c[a], 1 + c[b + 1]);
        }
        return c[0];
    }

    public static void main(String[] args) {
        String str = "geek";
        System.out.println(minCut(str));
    }

}
