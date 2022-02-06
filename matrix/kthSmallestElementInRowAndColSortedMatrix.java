import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * kthSmallestElementInRowAndColSortedMatrix
 */
public class kthSmallestElementInRowAndColSortedMatrix 
{
    static class Cell implements Comparable<Cell>
    {
        int r;
        int c;
        int val;
        Cell(int val, int r, int c){
            this.val=val;
            this.r=r;
            this.c=c;
        }
        @Override
        public int compareTo(kthSmallestElementInRowAndColSortedMatrix.Cell o) {
            return this.val - o.val;
        }

    }
    static int kthsmallest(int arr[][], int k)
    {
        Queue<Cell> q = new PriorityQueue<>();
        
        for (int i = 0; i < arr[0].length; i++) {
            q.add(new Cell(arr[0][i], 0, i));
        }
        
        int count = 0;
        int r = 0, c = 0;
        Cell p = null;
        while (!q.isEmpty()) {
            p = q.poll();
            count++;
            if (count == k)
                break;
            r = p.r;
            c = p.c;
            if (r < arr.length - 1)
                q.add(new Cell(arr[r + 1][c], r + 1, c));
        }
        if (count != k)
            return -1;
        else
           return(arr[p.r][p.c]);

    }
    static int kthlargest(int arr[][], int k)
    {
        Queue<Cell> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = arr[0].length-1; i >=0 ; i--) 
        {
            q.add(new Cell(arr[arr.length-1][i],  arr.length - 1, i));
        }

        int count = 0;
        int r = 0, c = 0;
        Cell p = null;
        while (!q.isEmpty()) {
        p = q.poll();
        count++;
        if (count == k)
        break;
        r = p.r;
        c = p.c;
        if (r-1 >=0)
        q.add(new Cell(arr[r-1][c], r -1, c));
        }
        if (count != k)
        return -1;
        else
        return(arr[p.r][p.c]);
    }
    
    public static void main(String[] args) 
    {
        int arr[][] = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
        for(int k=1;k<arr.length*arr.length;k++)
        {
            System.out.println(kthsmallest(arr, k));
            System.out.println(kthlargest(arr, k));
            System.out.println();
        }
        
    }
}