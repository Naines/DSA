public class copySetBits 
{
    static int copy(int x, int y, int l, int r)
    {
        if(l<1 || r>32)
        return -1;
        
        int masklength=(1<<(r-l+1))-1;
        System.out.println(Integer.toString(masklength,2));

        int mask=((masklength)<<(l-1))&y;

        System.out.println(Integer.toString(mask,2));

        x=x|mask;
        System.out.println(Integer.toString(x,2));
        return x;
    }
    public static void main(String[] args) {
        int x=10, y=13, l=2, r=3;
        System.out.println(Integer.toString(x,2));
        System.out.println(Integer.toString(y,2));
        x=copy(x, y, l, r);
        System.out.println("modded x="+x);
    }
    
}
