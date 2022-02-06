public class flipAtoB 
{
    static int countbits[] = new int[257];

    static void initialize() {
        countbits[0] = 0;
        for (int i = 1; i <= 256; i++) {
            countbits[i] = countbits[i / 2] + (i & 1);
        }
    }

    static int count(int n) {
        return (countbits[n & 0xff] + countbits[(n >> 8) & 0xff] + countbits[(n >> 16) & 0xff] + countbits[(n >> 24)]);
    }
    public static void main(String[] args) 
    {
        initialize();
        int a=10, b=20;
        System.out.println(count(a ^ b));
    }
}
