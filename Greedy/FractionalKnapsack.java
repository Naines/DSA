import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
    //    int N = 3, W = 50;
    //     int values[] = {60,100,120};
    //     int weight[] = {10,20,30};
        //240.00

        int N = 2, W = 50;
        int values[] = {60,100};
        int weight[] = {10,20};
        double profit=0.0;
        int wt=0;
        
        item items[]=new item[N];
        for(int i=0;i<N;i++)
        {
            items[i]=new item(weight[i], values[i], values[i]/weight[i]);
        }
        Arrays.sort(items);
        

        //Greedy
        int i;
        for(i=0;i<N;i++)
        {
            if(items[i].wt +wt <W)
            {
                wt+=items[i].wt;
                profit+=items[i].val;
            }else break;
        }
        
        if(i<N)
        profit+=(W-wt)*items[i].ratio;
        System.out.println(profit);
        
    }

    static class item implements Comparable<item>
    {
        int wt, val, ratio;
        item(int wt, int val, int ratio)
        {
            this.wt=wt;
            this.val=val;
            this.ratio=ratio;
        }
        public int compareTo(item o)
        {
            return Double.compare((double)o.val/o.wt , (double)this.val/this.wt);
        }
        public String toString()
        {
            return this.wt+" "+this.val;
        }
    }
}
