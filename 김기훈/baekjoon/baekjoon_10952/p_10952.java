import java.util.Scanner;

public class p_10952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Integer A = sc.nextInt();
            Integer B = sc.nextInt();
            if (A == 0 && B == 0) break;
            System.out.println(A + B);
        }
    }
}
