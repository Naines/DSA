package practise;

public class permutations 
{
    static int ans=0;
    static void perm(char ch[], String s, int length, boolean vis[])
    {
        if(s.length()==length)
        {
            System.out.println(s);
            ans++;
            return;
        }
        for(int i=0;i<length;i++)
        {
            if(vis[i])  continue;
            s+=ch[i];
            
            vis[i]=true;
            perm(ch, s, length, vis);

            //backtrack
            vis[i]=false;
            s=s.substring(0, s.length()-1);
        }
    }
    public static void main(String[] args) {
        String s="1234";

        perm(s.toCharArray(), "",s.length(),  new boolean[s.length()]);
        System.out.println(ans);
    }
}
