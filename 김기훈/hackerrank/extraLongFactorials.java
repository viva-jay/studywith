import java.math.BigInteger;

public class extraLongFactorials {
    public static void main(String[] args) {
        int n = 100;
        extraLongFactorials(n);
    }

    public static void extraLongFactorials(int n) {
        BigInteger result = new BigInteger("1");
        while (n >= 1) {
            result = result.multiply(BigInteger.valueOf(n));
            n = n - 1;
        }
        System.out.println(result);
    }
}
