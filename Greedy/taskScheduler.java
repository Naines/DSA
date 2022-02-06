import java.util.Arrays;

/**
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */
public class taskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        
        for(char c: tasks){
            freq[c-'A']++;
        }    
        Arrays.sort(freq);

        int max=freq[25];
        int idle=(max-1)*2;
        for(int i=freq.length-2;i>0 && idle>0 ;i--){
            idle-=Math.min(max-1, freq[i]);
        }
        return idle>0?idle+tasks.length:0+tasks.length;
    }
    public static void main(String[] args) {

        //A _b _c a _d _e A _f_g A _i _i A _i _i a 
        char ch[]={'A','A','A','A','A','A','B','C','D','E','F'};
        int n=ch.length;
        System.out.println( new taskScheduler().leastInterval(ch, n));
       ;
    }
}
