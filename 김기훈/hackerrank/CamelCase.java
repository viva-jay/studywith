public class CamelCase {
    public static void main(String[] args) {
        String s = "saveChangesInTheEditor";
        System.out.println(camelcase(s));
    }

    public static int camelcase(String s) {
        // Write your code here
        int count = 0;
        for(char ch : s.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') count++;
        }
        return count + 1;
    }
}
