package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 짝수와_홀수 {
	@DisplayName("홀수를 넘기면 Odd를 반환한다")
	@Test
	void given_number_when_divide_by_two_then_return_Odd() {
		Assertions.assertThat(solution(3))
			.isEqualTo("Odd");
	}

	@DisplayName("홀수를 넘기면 Even를 반환한다")
	@Test
	void given_number_when_divide_by_two_then_return_Even() {
		Assertions.assertThat(solution(4))
			.isEqualTo("Even");
	}

	public String solution(int num) {
		if (num % 2 == 0) {
			return "Even";
		}
		return "Odd";
	}
}
