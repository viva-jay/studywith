package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 두_정수_사이의_합 {
	// 10m

	@DisplayName("두 정수 사이의 합을 구한다.")
	@Test
	void find_sum_between_two_integers(){
		Assertions.assertThat(solution(3,5))
			.isEqualTo(12);
	}

	@DisplayName("같은 두 정수 사이의 합을 구한다.")
	@Test
	void find_sum_between_two_same_integers(){
		Assertions.assertThat(solution(3,3))
			.isEqualTo(3);
	}

	@DisplayName("큰 수 부터 전달해도 두 정수 사이의 합을 구할 수 있다.")
	@Test
	void given_two_number_then_decide_min_or_max_and_find_sum_between_two_integers(){
		Assertions.assertThat(solution(5,3))
			.isEqualTo(12);
	}

	public long solution(int a, int b) {
		long answer = 0;
		int min = Math.min(a,b);
		int max = Math.max(a,b);

		for(int number = min; number <= max; number++){
			answer += number;
		}
		return answer;
	}

	//등차 수열의 합
	public long otherSolution(int a, int b){
		long min = Math.min(a,b);
		long max = Math.max(a,b);
		return (max - min + 1) * (min + max) / 2;
	}
}
