import java.io.IOException;

public class p_2739 {
    public static void main(String[] args) throws IOException {
        int N = System.in.read() - '0';
        Calculator object_test = new Calculator(N);
        object_test.print();
    }

    public static class Calculator {
        private final int N;

        public Calculator(int N) {
            this.N = N;
        }

        public void print() {
            for(int i=1; i<=9; i++){
                System.out.println(String.format("%d * %d = %d", N, i, N * i));
            }
        }
    }
}
