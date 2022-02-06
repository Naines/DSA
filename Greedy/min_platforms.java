import java.util.Arrays;

public class min_platforms {
    public static void main(String[] args) {
        int n = 6 ;
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        Arrays.sort(arr);
        Arrays.sort(dep);
        int p = 1;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= dep[j])
                p++;
            else
                j++;
        }
        System.out.println(p);
    }
}
