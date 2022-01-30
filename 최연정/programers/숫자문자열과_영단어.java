import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 숫자문자열과_영단어 {

    @DisplayName("문자와 숫자가 섞여 있는 경우")
    @Test
    void changeIntegerWithWord() {
        Assertions.assertThat(solution("one4seveneight")).isEqualTo(1478);
    }

    @DisplayName("숫자만 존재하는 경우")
    @Test
    void changeIntegerOnlyNumber() {
        Assertions.assertThat(solution("123")).isEqualTo(234567);
    }

    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int index = 0; index < strArr.length; index++){
            s = s.replace(strArr[index], Integer.toString(index));
        }
        return Integer.valueOf(s);
    }
}
