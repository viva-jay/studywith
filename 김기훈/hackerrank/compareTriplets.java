import java.util.Arrays;
import java.util.List;

public class compareTriplets {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(17,28,30);
        List<Integer> b = Arrays.asList(99,16,8);
        List<Integer> result = compareTriplets(a, b);
        System.out.println(result);
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        // Write your code here
        int alicePoint = 0;
        int bobPoint = 0;

        for(int i=0; i<3; i++) {
            int aliceRate = a.get(i);
            int bobRate = b.get(i);

            if (aliceRate > bobRate) alicePoint++;
            if (aliceRate < bobRate) bobPoint++;
        }
        return Arrays.asList(alicePoint, bobPoint);
    }
}
