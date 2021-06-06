import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HackerRankSparseArrays {
    @Test
    public void sparseArrays() {
        String[] strings = Arrays.array("def", "de", "fgh");
        String[] queries = Arrays.array("de", "lnm", "fgh");
        int[] actual = matchingStrings(strings, queries);
        Assertions.assertThat(actual)
                .containsExactly(1, 0, 1);

    }

    public int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int size = queries.length;
        int[] result = new int[size];

        for (String key : strings) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < size; i++) {
            result[i] = map.getOrDefault(queries[i], 0);
        }

        return result;
    }
}
