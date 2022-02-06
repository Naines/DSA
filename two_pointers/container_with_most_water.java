public class container_with_most_water {
    public int maxArea(int[] A) {
        int i = 0;
        int j = A.length - 1;
        int area = 0;

        while (i < j) {
            area = Math.max(area, Math.min(A[i], A[j]) * (j - i));

            if (A[i] < A[j])
                i++;
            else
                j--;
        }
        return area;
    }
}
