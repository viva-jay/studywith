import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankDynamicArray {
    @Test
    public void dynamicArray() {
        List<List<Integer>> datas = new ArrayList<>();
        datas.add(Arrays.asList(1, 0, 5));
        datas.add(Arrays.asList(1, 1, 7));
        datas.add(Arrays.asList(1, 0, 3));
        datas.add(Arrays.asList(2, 1, 0));
        datas.add(Arrays.asList(2, 1, 1));
        List<Integer> expected = dynamicArray(2, datas);
        Assertions.assertThat(expected)
                .containsExactly(7, 3);

    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        int q = queries.size();
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int idx = (x ^ lastAnswer) % n;
            int value = 0;
            if (type == 1) {
                arr.get(idx).add(y);
            } else if (type == 2) {
                int size = arr.get(idx).size();
                int valueIdx = y % size;
                lastAnswer = arr.get(idx).get(valueIdx);
                result.add(lastAnswer);
            }

        }
        return result;
    }
}
