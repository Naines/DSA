import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection 
{
    static void printUnion(int arr1[], int arr2[], int n1, int n2)
    {
        //simple merge using 2 ptr technique
        //instead of merge we print
        int i=0,j=0;
        while(i<n1 && j<n2)
        {
            if(arr1[i]<arr2[j])
            System.out.print(arr1[i++]+" ");
            else if(arr2[j]<arr1[i])
            System.out.print(arr2[j++]+" ");
            else{
                System.out.print(arr1[i++]+" ");
                j++;
            }
        }
        while (i < n1)
            System.out.print(arr1[i++] + " ");
        while (j < n2)
            System.out.print(arr2[j++] + " ");
    }
    static void printIntersection(int arr1[], int arr2[], int n1, int n2)
    {
        int i=0, j=0;
        while(i<n1 && j<n2)
        {
            //if(i<j) i++ else if(j<i) j++ else print
            if(arr1[i]<arr2[j])   i++;
            else if(arr2[j]< arr1[i]) j++;
            else {
            System.out.println(arr1[i++]);
            j++;
            }
        }
    }
    static void unionIntersection(int arr1[], int arr2[], int n1, int n2)
    {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();

        for(int i: arr1)
        {
            if(!s1.contains(i))
            s1.add(i);
        }
        for(int i: arr2)
        {
            if(!s1.contains(i))
            s1.add(i);
            else
            s2.add(i);
        }

        System.out.println("UNION:");
        for(int i: s1)  System.out.print(i+" ");
        System.out.println();
        System.out.println("INTERSECTION: ");
        for(int i: s2)  System.out.print(i+" ");
    }
    public static void main(String args[]) {
        int arr1[] = { 1, 2, 2, 4, 5, 6 };
        int arr2[] = { 2, 2,3, 5, 7 };
        int m = arr1.length;
        int n = arr2.length;
        printIntersection(arr1, arr2, m, n);
        printUnion(arr1, arr2, m, n);
        System.out.println();
        unionIntersection(arr1, arr2, m, n);
    }
}
