import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 신규아이디추천 {

    @Test
    @DisplayName("입력이 빈문자인 경우")
    public void fillAcharacter() {
        Assertions.assertThat(solution(""))
                .isEqualTo("aaa");
    }

    @Test
    @DisplayName("중간에 a로 초기화 되는 경우")
    public void fillLastCharacter() {
        Assertions.assertThat(solution("=.="))
                .isEqualTo("aaa");
    }

    @Test
    @DisplayName("문자열 길이가 2 이하인 경우")
    public void setLengthTo3() {
        Assertions.assertThat(solution("z-+.^."))
                .isEqualTo("z--");
    }

    public String solution(String new_id) {

        String answer = new_id;

       answer = answer
                .toLowerCase()
                .replaceAll("([^a-z0-9._-]+)", "")
                .replaceAll("([.]{2,})", ".")
                .replaceFirst("^[.]|[.]$","");

        if (answer.equals("")) {
            answer = "a";
        }

        if (answer.length() > 15) {
            answer = answer
                    .substring(0, 15)
                    .replaceFirst("^[.]|[.]$","");
        }

        if (answer.length() <= 2) {
            int endPoint = answer.length();
            String lastCharator = answer
                    .substring(endPoint - 1, endPoint);

            while (answer.length() < 3) {
                answer = new StringBuffer(answer)
                        .append(lastCharator)
                        .toString();
            }
        }
        return answer;
    }
}
