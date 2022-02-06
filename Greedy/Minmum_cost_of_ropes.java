import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Minmum_cost_of_ropes
 */
public class Minmum_cost_of_ropes {

    public static void main(String[] args) {
        int arr[]={4,2,3,5};
        Queue<Integer> pq=new PriorityQueue<Integer>();
        for(int i:arr)  pq.add(i);
        int sum=0;
        while(pq.size()>1)
        {
            int x=pq.poll();
            int y=pq.poll();
            pq.add(x+y);
            sum+=(x+y);
        }
        System.out.println(sum);
    }
}