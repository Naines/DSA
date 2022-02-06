import java.util.Arrays;

public class kmp {
    // static int[] make_lps(String str) {
    // int n = str.length();
    // int arr[] = new int[n];
    // int len = 0;
    // int i = 1;
    // arr[0] = 0;
    // while (i < n) {
    // if (str.charAt(i) == str.charAt(len)) {
    // len++;
    // arr[i] = len;
    // i++;
    // } else {
    // if (len != 0) {
    // len = arr[len - 1];
    // } else {
    // arr[i] = len;
    // i++;
    // }
    // }
    // }
    // return arr;
    // }

    static int[] lps(String str) {
        int n = str.length();
        int arr[] = new int[n];
        int i = 0, j = 1;
        arr[0] = 0;
        while (j < n) {
            if (str.charAt(i) == str.charAt(j)) {
                arr[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = arr[i - 1];
                } else {
                    arr[j] = 0;
                    j++;
                }
            }
        }
        return arr;
    }

    static boolean KMP(char[] text, char[] pattern) {

        int arr[] = lps(Arrays.toString(pattern));
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = arr[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length) {
            return true;
        }
        return false;
    }

    public boolean hasSubstring(char[] text, char[] pattern) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        if (j == pattern.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abcad";
        String pat = "abc";

        boolean flag = KMP(str.toCharArray(), pat.toCharArray());
        System.out.println(flag);
    }
}
