import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// success
public class marcsCakewalk {
    public static void main(String[] args) {
        int n = 4;
        List<Integer> calorie = Arrays.asList(819,701,578,403,50,400,983,665,510,523,696,532,51,449,333,234,958,460,277,347,950,53,123,227,646,190,938,61,409,110,61,178,659,989,625,237,944,550,954,439);
        System.out.println(marcsCakewalk(calorie));
    }

    public static long marcsCakewalk(List<Integer> calorie) {
        int n = calorie.size();
        long[] dp = new long[n];
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            dp[i] = dp[i-1] * 2;
        }

        List<Integer> sorted_calorie = calorie.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        long result = 0;
        for(int i=0; i<n; i++) {
            //System.out.println("dp[i] * calorie[i] = " + dp[i] + " * " + sorted_calorie.get(i));
            result += (long)(dp[i] * sorted_calorie.get(i));
        }
        return result;
    }
}
