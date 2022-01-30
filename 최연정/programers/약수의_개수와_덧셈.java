import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 약수의_개수와_덧셈 {
	@Test
	void test() {
		Assertions.assertThat(solution(13, 17))
			.isEqualTo(43);
	}

	public int solution(int left, int right) {
		int answer = 0;
		for (int dividend = left; dividend <= right; dividend++) {
			int count = 0;
			for (int divisor = 1; divisor <= dividend; divisor++) {
				if (dividend % divisor == 0) {
					count++;
				}
			}
			int sign = isNegativeOrNot(count);
			answer += (dividend * sign);

		}
		return answer;
	}

	private int isNegativeOrNot(int count) {
		if (count % 2 == 0) {
			return 1;
		}
		return -1;
	}

	public int otherSolution(int left, int right) {
		int sum = IntStream.rangeClosed(left, right).sum();

		int sqrt = (int) Math.ceil(Math.sqrt(left));
		for (int i = sqrt; i * i <= right; i++) { // 4 ~ 17
			sum -= 2 * i * i;
		}

		return sum;
	}
}
