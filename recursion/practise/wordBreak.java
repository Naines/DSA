package practise;

import java.util.ArrayList;
import java.util.List;

public class wordBreak {

    public static boolean solve(String s, List<String> wordDict) {
        if (s.length() == 0)
            return true;

        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);
            if (wordDict.contains(left) && solve(s.substring(i+1), wordDict))
            return true; 
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        // list.add("cats");
        // list.add("and");
        // list.add("dogs");
        // list.add("sand");
        // list.add("cat");
        list.add("aaaa");
        list.add("aaa");

        //String str="catsanddogs";
        String str="aaaaaaa";
        System.out.println(solve(str, list));
        
    }
}
