import java.util.Scanner;

/*
 * afsnbjhaf
 * fadsDFBJHSFd
 * SFdsgbjgdSK
 */
//BAFHBFA

class add {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            // System.out.println(a);
            float f = ((a + b + c + d + e) / 500.0f) * 100;
            float g = (((float) a + b + c + d + e) / 500) * 100;
            float h = ((float) (a + b + c + d + e) / 500) * 100;
            System.out.println("percentage = " + f);
            System.out.println("percentage = " + g);
            System.out.println("percentage = " + h);
        }
    }
}