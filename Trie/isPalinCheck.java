class isPalinCheck {
    static boolean isPalin(String a, String b) {
        String x = a + b;
        int n = x.length();
        for (int i = 0; i <= n / 2; i++) {
            if (x.charAt(i) != x.charAt(n - i - 1))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "dcba";
        System.out.println(isPalin(a, b));
    }
}