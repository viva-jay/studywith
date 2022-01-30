package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 이상한_문자_만들기 {
	@Test
	void test(){
		Assertions.assertThat(solution("try hello world"))
			.isEqualTo("TrY HeLlO WoRlD");
	}

	public String solution(String s) {
		String[] words = s.split("\\s", -1);
		List<String> container = new ArrayList<>();

		for(String word : words){
			StringBuffer wordBuffer = new StringBuffer();
			for(int index = 0; index < word.length(); index++){
				if(index % 2 == 0){
					wordBuffer
						.append(Character
							.toUpperCase(word.charAt(index)));
				}else {
					wordBuffer
						.append(Character
							.toLowerCase(word.charAt(index)));
				}
			}
			container.add(wordBuffer.toString());
		}
		return String.join(" ", container);
	}

	public String otherSolution(String s) {
		String answer;
		answer = s.toUpperCase();
		char[] chars = answer.toCharArray();

		//앞문자가 대문자라면 소문자로 치환
		for (int i = 1; i < chars.length; i++) {
			if (62 <= chars[i - 1] && chars[i - 1] <= 90) {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}
		answer = String.valueOf(chars);
		return answer;
	}
}
