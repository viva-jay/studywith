import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HackerRankHourglassSum {
    @Test
    public void hourglassSum() {
        int[][] hourglass =
                {{1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}};
        int expected = hourglassSum(hourglass);

        Assertions.assertEquals(expected, 19);
    }

    static int hourglassSum(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;
        int maxValueOfHourglass = -63;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                int sumOfHourglass = 0;
                sumOfHourglass += arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sumOfHourglass += arr[i + 1][j + 1];
                sumOfHourglass += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                maxValueOfHourglass = Math.max(maxValueOfHourglass, sumOfHourglass);
            }
        }
        return maxValueOfHourglass;
    }
}
