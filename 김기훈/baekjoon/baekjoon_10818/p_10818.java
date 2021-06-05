import java.util.Scanner;

public class p_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int N = sc.nextInt();
        for(int i=1; i<=N; i++) {
            int temp = sc.nextInt();
            if (temp < min) min = temp;
            if (temp > max) max = temp;
        }
        System.out.println(min + " " + max);
    }
}
