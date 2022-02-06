import java.util.Arrays;

public class maximumTrainsForWhichStoppageCouldBeProvided 
{
    /**
    10:00 10:30 1
    10:10 10:30 1
    10:30 12:30 2
    12:00 12:30 3
    10:00 10:20 2
    09:00 10:05 1
     
     */
    public static void main(String[] args) {
        // int arr[][]={
        //      {1000 ,1030, 1},
        //     {1010 ,1030, 1},
        //     {1030 ,1230 ,2},
        //     {1200 ,1030, 3},
        //     {1000, 1020, 2},
        //    { 900 ,1005 ,1},
        // };//5
        //  int arr[][]={
        //      {1010 ,1030, 1},
        //     {1000 ,1030, 1},
        //     {1010 ,1020 ,1},
        // };//1
        //   int arr[][]={ {1000, 1030, 1},
        //               {1010, 1020, 1},
        //               {1025, 1040, 1},
        //               {1130, 1145, 2},
        //               {1130, 1140, 2} };//3
          int arr[][]={ {1000, 1030, 1},
                      {1110, 1130, 1},
                      {1200, 1220, 1}, 
                    };//3
        Train trains[]=new Train[arr.length];
        for(int i=0;i<arr.length;i++){
            trains[i]=new Train(arr[i][0], arr[i][1], arr[i][2]);
        }
        Arrays.sort(trains);
        for(Train t: trains){
            System.out.println(t);
        }
        
        int count=1;
        int j=0;
        for(int i=1;i<trains.length;i++){
            if(trains[i].platform==trains[j].platform && trains[i].arr>=trains[j].dept){
                count++;
                j=i;
                System.out.println("afb"+trains[i]);
            }else if(trains[i].platform!=trains[j].platform){
                count++;
                j=i;
               System.out.println("afb"+trains[i]);
            }
        }
        System.out.println(count);
    }
    static class Train implements Comparable<Train>
    {
        int arr;
        int dept;
        int platform;
        Train(int arr, int dept, int platform){
            this.arr=arr;
            this.dept=dept;
            this.platform=platform;
        }
        public int compareTo(Train o){
         if(this.platform==o.platform)
            return this.dept-o.dept;
        else return this.platform-o.platform;
        }
        public String toString(){
            return this.arr+" "+this.dept+" "+this.platform;        
        }
    }
}
