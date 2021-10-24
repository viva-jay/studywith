package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 없는_숫자_더하기 {
	@DisplayName("존재하지 않는 숫자라면 더한다")
	@Test
	void when_not_exist_number_then_add_number(){
		Assertions.assertThat(solution(new int[]{1,2,3,4,6,7,8,0}))
			.isEqualTo(14);
	}

	public int solution(int []numbers) {
		int[] check = new int[10];
		for(int number : numbers){
			check[number] = 1;
		}

		int result = 0;
		for(int index = 0; index < check.length; index++){
			if(check[index] == 0){
				result += index;
			}
		}
		return result;
	}

	public int otherSolution(int[] numbers) {
		int sum = 45;
		for (int i : numbers) {
			sum -= i;
		}
		return sum;
	}
}
