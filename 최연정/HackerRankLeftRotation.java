import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankLeftRotation {

    @Test
    public void leftRotate(){
        List<Integer> actual = rotateLeft(4, Arrays.asList(1,2,3,4,5));

        Assertions.assertThat(actual)
                .containsExactly(5,1,2,3,4);
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> result = new ArrayList(arr);
        int size = arr.size();
        for(int i = 0; i < size; i++){
            result.set((i + size - d) % size , arr.get(i));
        }
        return result;
    }
}
