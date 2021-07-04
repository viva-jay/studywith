import java.util.Arrays;
import java.util.List;

public class diagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(11,2,4), Arrays.asList(4,5,6), Arrays.asList(10,8,-12));
        int result = diagonalDifference(arr);
        System.out.println(result);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int n = arr.size();

        int leftSum = 0;  int leftColumn = 0;
        int rightSum = 0; int rightColumn = n-1;
        for(int row=0; row<n; row++) {
            leftSum += arr.get(row).get(leftColumn++);
            rightSum += arr.get(row).get(rightColumn--);
        }
        return Math.abs(leftSum - rightSum);
    }
}
