import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HackerRankReverseArray {
    @Test
    public void reverseArray(){
        int[] expected = reverseArray(new int[]{1,2,3,4,5});
        int[] actual = new int[]{5,4,3,2,1};

        Assertions.assertArrayEquals(expected, actual);
    }
    static int[] reverseArray(int[] a) {
        int size = a.length;
        for(int i = 0; i < (size/2); i++){
            int end = size - i - 1;
            int temp = a[i];
            a[i] = a[end];
            a[end] = temp;
        }
        return a;
    }
}
