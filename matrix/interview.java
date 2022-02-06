public class interview 
{
    static void reverse(String str) {
        char ch[] = str.toCharArray();
        int l = ch.length;
        for (int i = 0; i < (l / 2); i++) {
            char t = ch[i];
            ch[i] = ch[l - i - 1];
            ch[l - i - 1] = t;
        }
        for (char c : ch)
            System.out.print(c);
    }

    static void reverse2(String str, int k) {
        if (str.length() == k)
            return;

        System.out.print(str.charAt(str.length() - k - 1));
        reverse2(str, ++k);
    }

    static void reverse3(String str) {
        char ch[] = str.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
    public static void main(String[] args) {
        reverse("My name is Nainesh Goel");
        System.out.println();
        reverse2("My name is Nainesh Goel", 0);
        System.out.println();
        reverse3("My name is Nainesh Goel");
    }
}
