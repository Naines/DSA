import java.util.Arrays;

public class N_meetings_in_one_room
{
    public static void main(String[] args) 
    {
        int N = 6;
        int S[] = {1,3,0,5,8,5};
        int F[] = {2,4,6,7,9,9};
        //ans=4;

        // int N=8;
        // int S[]={75250, 50074, 43659, 8931, 11273,
        //             27545, 50879, 77924};

        // int F[]={112960, 114515, 81825, 93424, 54316,
        //         35533, 73383, 160252};

        room rooms[]=new room[N];
        for(int i=0;i<N;i++)
        rooms[i]=new room(S[i], F[i]);

        Arrays.sort(rooms);
        //for(room r: rooms)  System.out.println(r);

        int count=1;
        int endTime=rooms[0].f;
        for(int i=1;i<N;i++)
        {
            if(endTime<rooms[i].s)
            {
                endTime=rooms[i].f;
                count++;
            }
        }

        System.out.println(count);
    }
    static class room implements Comparable<room>
    {
        int s,f;
        room(int s, int f)
        {
            this.s=s;
            this.f=f;
        }
        public int compareTo(room o)
        {
            return this.f-o.f;
        }
        public String toString()
        {
            return this.s+" "+this.f;
        }
    }
    
}
