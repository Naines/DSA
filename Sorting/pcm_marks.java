import java.util.Arrays;

/**
 * Sort the students in Ascending order of their Physics marks.
 * Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.
 * Once this is also done, sort the students having same marks in Physics and Chemistry in the ascending order of their Maths marks.
 */
class pcm_marks 
{
    public static void main(String[] args) 
    {
        int N = 10; 
        int phy[] = {4, 1, 10, 4, 4 ,4, 1, 10, 1 ,10};
        int chem[] = {5, 2, 9, 6, 3, 10 ,2, 9, 14, 10};
        int math[] = {12, 3, 6, 5 ,2 ,10 ,16, 32, 10, 4};
        custom_sort(N, phy,chem,math);
    }
    public static void custom_sort(int n, int[] phy, int[] chem, int[] maths) 
    {
        Student students[]=new Student[n];
        for(int i=0;i<n;i++)
        {
            students[i]=new Student(phy[i], chem[i], maths[i]);
        }
        Arrays.sort(students);
        for(int i=0;i<n;i++)
        {
            System.out.println(students[i]);
        }
    }
    static class Student implements Comparable<Student> 
    {
        int p, c, m;

        Student(int p, int c, int m) {
            this.p = p;
            this.c = c;
            this.m = m;
        }

        @Override
        public int compareTo(Student o) 
        {
            if (this.p == o.p) {
                if (this.c == o.c) {
                    return this.m - o.m;
                } else
                    return o.c - this.c;
            } else
                return this.p - o.p;
        }
        public String toString()
        {
            return this.p+" "+this.c+" "+this.m;
        }
    }
}
    


