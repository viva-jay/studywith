import java.util.Arrays;
import java.util.List;

public class aVeryBigSum {
    public static void main(String[] args) {
        List<Long> ar = Arrays.asList(1000000001L , 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        long result = aVeryBigSum(ar);
        System.out.println(result);
    }

    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        return ar.stream().reduce(0L, (a,b) -> a+b);
    }
}
