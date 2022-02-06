import java.util.HashMap;
import java.util.HashSet;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        
        int n=4;
        int reserved[][]={{2,1},{1,8},{2,6}};
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] seat: reserved) {
			if(seat[1] == 1 || seat[1] == 10) continue;
			map.putIfAbsent(seat[0], new HashSet<>());
            map.get(seat[0]).add(seat[1]);
		}

        int ans=(n-map.size())*2;//best case
        for(int row: map.keySet()){
            System.out.println(row);
            int groups=0;
            HashSet<Integer> set=map.get(row);
            if( !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) groups++;
            if( !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) groups++;
            if(groups==0){
                if( !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) groups++;
            }
            ans+=groups;
        }
        System.out.println(ans);
    }
    // static class Seat implements Comparable<Seat>
    // {
    //     int row;
    //     int col;
    //     Seat(int r, int c){
    //         this.row=r;
    //         this.col=c;
    //     }
    //     public int compareTo(Seat o){
    //         if(this.row==o.row){
    //             return this.col-o.col;
    //         }return this.row-o.row;
    //     }

    //     public String toString(){
    //         return this.row+" "+this.col;
    //     }
    // }
}
