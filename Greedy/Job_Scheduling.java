import java.util.Arrays;
import java.util.Scanner;

/**
 * (1,2,100)(2,1,19)(3,2,27) (4,1,25)(5,1,15)
 */
public class Job_Scheduling {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        job jobs[]=new job[n];
        int max_deadline=-1;
        for(int i=0;i<n;i++)
        {
            jobs[i]=new job(sc.nextInt(), sc.nextInt(), sc.nextInt());
            max_deadline=Math.max(jobs[i].deadline, max_deadline);
        }
        Arrays.sort(jobs);
        System.out.println(solve(jobs , max_deadline));
        // for(job j: jobs)
        // System.out.println(j);
        sc.close();
    }
    static int solve(job jobs[], int max_deadline)
    {
        int count=0, profit=0;
        int plan[]=new int[max_deadline];

        for(int i=0;i<jobs.length;i++)
        {
            for(int j=Math.min(jobs[i].deadline-1, max_deadline-1); j>=0;j--)
            {
                if(plan[j]==0)
                {
                    plan[j]=jobs[i].rank;
                    profit+=jobs[i].cost;
                    count++;
                    break;
                }
            }
        }
        for(int i: plan)
        System.out.print(i+" ");
        System.out.println();
        System.out.println(profit);
        return count;
    }
    static class job implements Comparable<job>
    {
        int rank, deadline, cost;
        job(int rank, int deadline, int cost)
        {
            this.rank=rank;
            this.deadline=deadline;
            this.cost=cost;

        }
        public int compareTo(job o)
        {
            return o.cost-this.cost;
        }
        public String toString()
        {
            return this.rank+" "+this.deadline
            +" "+this.cost;
        }
    }
}
