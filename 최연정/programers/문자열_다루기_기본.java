import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 문자열_다루기_기본 {

    @DisplayName("문자가 포함되어 있는 경우")
    @Test
    void checkText() {
        Assertions.assertThat(solution("a234"))
                .isEqualTo(false);
    }

    @DisplayName("길이가 4 또는 6이 아닌 경우")
    @Test
    void checkLength() {
        Assertions.assertThat(solution("02345678"))
                .isEqualTo(false);
    }

    @DisplayName("길이가 4인 숫자인 경우")
    @Test
    void checkNumber() {
        Assertions.assertThat(solution("0234"))
                .isEqualTo(true);
    }

    public boolean solution(String s) {
        return s.matches("^([0-9]{4}|[0-9]{6})$");
    }
}
