import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class wordbreak {
    static ArrayList<String> list = new ArrayList<>();

    static List<String> wordBreak(int n, List<String> dict, String s) 
    {
        list.clear();
        HashSet<String> hs = new HashSet<>();
        for (String t : dict)
            hs.add(t);

            
        solve(s, hs, "");
        
        return list;
    }

    static void solve(String str, HashSet<String> dict, String ans) 
    {
        if (str.length() == 0) {
            list.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dict.contains(left)) 
            {
                String right=str.substring(i+1);
               solve(right, dict, ans+left+" ");
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();
        ArrayList<String> dict=new ArrayList<>();
        for(int i=0;i<n;i++)    dict.add(sc.next());
        System.out.println(wordBreak(n, dict, str));
        sc.close();
    }
}
