import java.util.HashMap;
import java.util.Map;

public class commonElementsInRow 
{
    static void findCommmons(int arr[][])
    {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr[0].length;i++)
        {
            map.put(arr[0][i], 1);
        }
        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(map.get(arr[i][j])!=null && map.get(arr[i][j])==i)
                {
                    map.put(arr[i][j],i+1);

                    if(i==arr.length-1)
                    System.out.print(arr[i][j]+" ");
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,1,4},{3,7,8,1},{8,7,3,1},{8,1,7,9}};
        findCommmons(arr);
    }
    
}
