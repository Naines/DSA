import java.util.Arrays;

/**
 * MaximumStocksBuyInIDays
 */
public class MaximumStocksBuyInIDays {

    public static void main(String[] args) {
        // int arr[]={10,7,19};//4
        // int money=45;
        int arr[]={7,10,4};//6
        int money=100;
        Stock stocks[]=new Stock[arr.length];

        for(int i=0;i<arr.length;i++){
            stocks[i]=new Stock(i+1, arr[i]);
        }
        Arrays.sort(stocks);
        // for(Stock s: stocks)    System.out.println(s);

        int ans=0;
        for(int i=0;i<arr.length;i++){
            int buy=Math.min(stocks[i].day , money/stocks[i].price);
            money-=buy*stocks[i].price;
            ans+=buy;
            
        }
        System.out.println(ans);
    }
    static class Stock implements Comparable<Stock>
    {
        int day;
        int price;
        Stock(int day, int price){
            this.day=day;
            this.price=price;
        }
        public int compareTo(Stock o){
            if(this.price==o.price){
                return this.day-o.day;
            }return this.price-o.price;
        }
        public String toString()
        {
            return this.day+" "+this.price;
        }
    }
}