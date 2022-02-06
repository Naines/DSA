/**
 * kthPermOfASequence
 */
public class kthPermOfASequence {
/**
 * 3 4551711527 
 * 7755511124
 */
    static String max="-99"; 
    public static void main(String[] args) 
    {
        String str="1234567";
        findPerm(str.toCharArray(),3, 0);
        System.out.println(max);
    }
    static boolean findPerm(char ch[], int k, int index)
    {
        if(k==0)
        return true;

        int maxdex=index;
        for(int i=index;i<ch.length;i++)
        {
            if(ch[i]-'0' > ch[maxdex]-'0') maxdex=i;
        }

        for(int i=index;i<ch.length;i++)
        {
            if(i>index && ch[i]==ch[maxdex])
            {
                swap(ch, index, i);
                
                if(Long.parseLong(max)< Long.parseLong(String.valueOf(ch)))
                max=String.valueOf(ch);

                if(findPerm(ch, k-1, index+1))
                return true;
                swap(ch, index, i);
            }

        }
        return false;
    }
    static void swap(char ch[], int a, int b)
    {
        System.out.println(String.valueOf(ch)+" "+a+" "+b);
        char t=ch[a];
        ch[a]=ch[b];
        ch[b]=t;
    }
}