import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 음양더하기 {
	@DisplayName("절대값과 부호배열을 넘기면 부호가 적용된 숫자들의 합이 계산된다")
	@Test
	void given_absolutes_numbers_and_signs_then_return_sum_of_numbers() {
		int result = solution(new int[] {1, 2, 3}, new boolean[] {false, false, true});
		Assertions.assertThat(result).isEqualTo(0);
	}

	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int index = 0; index < signs.length; index++) {
			int sign = isNegativeOrNot(signs[index]);
			answer += (absolutes[index] * sign);
		}
		return answer;
	}

	private int isNegativeOrNot(boolean sign) {
		if (sign == true) {
			return 1;
		}
		return -1;
	}
}


