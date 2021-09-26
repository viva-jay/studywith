import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 내적 {
    @Test
    void calculate() {
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};
        Assertions.assertThat(solution(a, b)).isEqualTo(3);
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int index = 0; index < a.length; index++){
            answer += (a[index] * b[index]);
        }

        return answer;
    }

}
