import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Shop_in_candy_store {
    public static void main(String[] args) {
        int k=4;
        int arr[]={3,2,1,4,5};
        Arrays.sort(arr);
        Queue<Integer> pq=new PriorityQueue<>();
        Queue<Integer> pqg=new PriorityQueue<>(Collections.reverseOrder());
        for(int i: arr) {
            pq.add(i);
            pqg.add(i);
        }
       
        int min=0, max=0;
        while(pq.size()>0)
        {
            min+=pq.poll();
            int count=k;
            while(count-->0 && pq.size()>0)
            {
                pq.poll();
            }
        }
        while(pqg.size()>0)
        {
            max+=pqg.poll();
            int count=k;
            while(count-->0 && pqg.size()>0)
            pqg.poll();
        }
        System.out.println(min+" "+max);

    }       
}
