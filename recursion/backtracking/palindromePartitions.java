public class palindromePartitions {
    static void find(String str, String ans)
    {
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        
        for(int i=0;i<str.length();i++)
        {
            String left=str.substring(0, i+1);
            String right=str.substring(i+1);
            if(!isPalin(left)) continue;
            
            find(right, ans+" "+left );
        }

    }
    static boolean isPalin(String s)
    {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str="nitin";
        //System.out.println(isPalin("itin"));
        find(str, "");
    }
}
