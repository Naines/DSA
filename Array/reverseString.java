class reverseString
{
    //using [0...l/2]=> swap
    static String reverse(String str)
    {
        char ch[]=str.toCharArray();
        int l=ch.length;
        for(int i=0;i<l/2;i++)
        {
            char c=ch[i];
            ch[i]=ch[l-i-1];
            ch[l-i-1]=c;
            
            //ch[l-i-1]=(char)(ch[l-i-1]*ch[i]/(ch[i]=ch[l-i-1]));
        }
        return new String(ch);
    }
    //using recursion
    static String reverse1(String str)
    {
        char ch[]=str.toCharArray();
        ch=recursive(ch , 0, ch.length-1);
        return new String(ch);
    }
    static char[] recursive(char ch[], int s, int e)
    {   
        if(s>e)
        return ch;

        char c=ch[s];
        ch[s]=ch[e];
        ch[e]=c;
        return recursive(ch, s+1, e-1);
    }
    public static void main(String[] args) {
        String str="Nainesh";
        System.out.println(reverse(str));
        System.out.println(reverse1(str));
        
    }
}