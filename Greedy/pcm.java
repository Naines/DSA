import java.util.Arrays;

public class pcm {
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        Student students[]=new Student[N];
        for(int i=0;i<N;i++)
            students[i]=new Student(phy[i], chem[i], math[i]);
        
        Arrays.sort(students);
        
        for(int i=0;i<N;i++)
        {
            phy[i]=students[i].p;
            chem[i]=students[i].c;
            math[i]=students[i].m;
        }
    }
    class Student implements Comparable<Student>
    {
        int p, c, m;
        Student(int p, int c, int m)
        {
            this.p=p;
            this.c=c;
            this.m=m;
        }
        
        public int compareTo(Student o)
        {
            if(this.p==o.p)
            {
                if(this.c==o.c)
                {
                    return this.m-o.m;
                }else return o.c-this.c;
            }else return this.p-o.p;
        }
        public String toString()
        {
            return this.p+" "+this.c+" "+this.m;
        }
    }
}
