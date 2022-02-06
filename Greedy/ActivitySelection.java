import java.util.Arrays;
/**
 Input:
N = 6
S[] = {1,3,0,5,8,5}
F[] = {2,4,6,7,9,9}
Output: 
4
Explanation:
Four meetings can be held with
given start and end timings.
 */
public class ActivitySelection {
    public static int maxMeetings(int start[], int end[], int n)
    {
        room rooms[]=new room[n];
        for(int i=0;i<n;i++)
        {
            rooms[i]=new room(start[i], end[i]);
        }
        
        Arrays.sort(rooms);
        
        int count=1;
        int endTime=rooms[0].e;
        
        for(int i=1;i<n;i++)
        {
            if(endTime< rooms[i].s)
            {
                count++;
                endTime=rooms[i].e;
            }
        }
        return count;
    }
    static class room implements Comparable<room>
    {
        int s, e;
        room(int s, int e)
        {
            this.s=s;
            this.e=e;
            
        }
        public int compareTo(room o)
        {
            return this.e-o.e;
        }
    }
}
