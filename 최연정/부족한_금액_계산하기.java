package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 부족한_금액_계산하기 {
	// 30m

	@DisplayName("놀이 기구를 탔을 때 부족한 돈을 구한다")
	@Test
	void calculate_shortfall() {
		Assertions.assertThat(solution(3, 20, 4))
			.isEqualTo(10);
	}

	@DisplayName("가져온 돈이 충분하면 0을 반환한다.")
	@Test
	void when_enough_money_then_return_zero() {
		Assertions.assertThat(solution(10, 100, 2))
			.isEqualTo(0);
	}

	public long solution(int price, int money, int count) {
		long priceTotal = 0;
		for (int time = 1; time <= count; time++) {
			priceTotal += (price * time);
		}

		return Math.max(priceTotal - money, 0);
	}

	public long otherSolution(int price, int money, int count) {
		return Math.max(price * (count * (count + 1) / 2) - money, 0);
	}
}