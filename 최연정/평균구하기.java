package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 평균구하기 {
	// 6m
	@DisplayName("주어진 숫자들에 대한 평균을 구한다")
	@Test
	void given_numbers_then_return_average() {
		Assertions.assertThat(solution(new int[] {1, 2, 3, 4}))
			.isEqualTo(2.5);
	}

	public double solution(int[] arr) {
		double numberSum = 0;
		for (int index = 0; index < arr.length; index++) {
			numberSum += arr[index];
		}
		return numberSum / arr.length;
	}
}
