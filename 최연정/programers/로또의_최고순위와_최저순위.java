import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 로또의_최고순위와_최저순위 {

    @Test
    @DisplayName("일부 번호가 가려진 경우")
    public void score3_5() {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};

        Assertions.assertThat(solution(lottos, winNums))
                .containsExactly(3, 5);
    }

    @Test
    @DisplayName("전체가 가려진 경우")
    public void score1_6() {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] winNums = {31, 10, 45, 1, 6, 19};

        Assertions.assertThat(solution(lottos, winNums))
                .containsExactly(1, 6);
    }

    @Test
    @DisplayName("완전 일치 하는 경우")
    public void score1_1() {
        int[] lottos = {31, 10, 45, 1, 6, 19};
        int[] winNums = {31, 10, 45, 1, 6, 19};

        Assertions.assertThat(solution(lottos, winNums))
                .containsExactly(1, 1);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] lottoPaper = new int[46];
        int lowCount = 0;
        int highCount = 0;

        //선택번호 확인을 위한 초기화
        for (int number : lottos) {
            lottoPaper[number] += 1;
        }

        // 최소 번호 확인
        for (int number : win_nums) {
            if (lottoPaper[number] == 1) {
                lowCount++;
            }
        }

        highCount = lowCount + lottoPaper[0];

        answer[0] = score(highCount);
        answer[1] = score(lowCount);
        return answer;
    }

    public int score(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
