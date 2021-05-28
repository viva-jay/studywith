public class p_1330 {
    public static void main(String[] args) throws java.io.IOException {
        int a = System.in.read() - '0';
        System.in.read();
        int b = System.in.read() - '0';

        String result;
        if (a > b) result = ">";
        else if (a < b) result = "<";
        else result = "==";
        System.out.println(result);
    }
}
