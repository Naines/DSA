public class backtracking_basics {
    static void permString(char ch[], int index)
    {
        if(index==ch.length-1)
        {
            System.out.println(new String(ch));
            return;
        }

        System.out.println(new String(ch)+" "+index+"----");
        for(int i=index;i<ch.length;i++)
        {
            swap(ch,i, index);
            permString(ch, index+1);
            swap(ch, i, index);
        }
    }
    public static void main(String[] args) 
    {
        char ch[]="ABC".toCharArray();
        permString(ch,0);
    }
    static void swap(char ch[], int a, int b)
    {
        
        char t=ch[a];
        ch[a]=ch[b];
        ch[b]=t;
    }
}
