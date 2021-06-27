import java.util.Arrays;
import java.util.List;

public class simpleArraySum {
    public static void main(String[] args) {
        int n = 6;
        List<Integer> ar = Arrays.asList(1,2,3,4,10,11);
        int result = simpleArraySum(ar);
        System.out.println(result);
    }

    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int sum = ar.stream().reduce(0, (a,b) -> a+b);
        return sum;
    }
}
