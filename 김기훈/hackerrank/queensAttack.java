import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class queensAttack {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        //List<List<Integer>> obstacles = Arrays.asList(Arrays.asList(54,87), Arrays.asList(64,97), Arrays.asList(42,75), Arrays.asList(32,65), Arrays.asList(42,87), Arrays.asList(32,97), Arrays.asList(54,75), Arrays.asList(64,65), Arrays.asList(48,87), Arrays.asList(48,75), Arrays.asList(54,81), Arrays.asList(42,81), Arrays.asList(45,17), Arrays.asList(14,24), Arrays.asList(35,15), Arrays.asList(95,64), Arrays.asList(63,87), Arrays.asList(25,72), Arrays.asList(71,38), Arrays.asList(96,97), Arrays.asList(16,30), Arrays.asList(60,34), Arrays.asList(31,67), Arrays.asList(26,82), Arrays.asList(20,93), Arrays.asList(81,38), Arrays.asList(51,94), Arrays.asList(75,41), Arrays.asList(79,84), Arrays.asList(79,65), Arrays.asList(76,80), Arrays.asList(52,87), Arrays.asList(81,54), Arrays.asList(89,52), Arrays.asList(20,31), Arrays.asList(10,41), Arrays.asList(32,73), Arrays.asList(83,98), Arrays.asList(87,61), Arrays.asList(82,52), Arrays.asList(80,64), Arrays.asList(82,46), Arrays.asList(49,21), Arrays.asList(73,86), Arrays.asList(37,70), Arrays.asList(43,12), Arrays.asList(94,28), Arrays.asList(10,93), Arrays.asList(52,25), Arrays.asList(50,61), Arrays.asList(52,68), Arrays.asList(52,23), Arrays.asList(60,91), Arrays.asList(79,17), Arrays.asList(93,82), Arrays.asList(12,18), Arrays.asList(75,64), Arrays.asList(69,69), Arrays.asList(94,74), Arrays.asList(61,61), Arrays.asList(46,57), Arrays.asList(67,45), Arrays.asList(96,64), Arrays.asList(83,89), Arrays.asList(58,87), Arrays.asList(76,53), Arrays.asList(79,21), Arrays.asList(94,70), Arrays.asList(16,10), Arrays.asList(50,82), Arrays.asList(92,20), Arrays.asList(40,51), Arrays.asList(49,28), Arrays.asList(51,82), Arrays.asList(35,16), Arrays.asList(15,86), Arrays.asList(78,89), Arrays.asList(41,98), Arrays.asList(70,46), Arrays.asList(79,79), Arrays.asList(24,40), Arrays.asList(91,13), Arrays.asList(59,73), Arrays.asList(35,32), Arrays.asList(40,31), Arrays.asList(14,31), Arrays.asList(71,35), Arrays.asList(96,18), Arrays.asList(27,39), Arrays.asList(28,38), Arrays.asList(41,36), Arrays.asList(31,63), Arrays.asList(52,48), Arrays.asList(81,25), Arrays.asList(49,90), Arrays.asList(32,65), Arrays.asList(25,45), Arrays.asList(63,94), Arrays.asList(89,50), Arrays.asList(43,41));
        List<List<Integer>> obstacles = Arrays.asList(Arrays.asList(5,5),Arrays.asList(4,2),Arrays.asList(2,3));
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int count = 0;
        List type_1 = obstacles.stream().filter(point -> point.get(0) == r_q).sorted((a,b) -> a.get(1).compareTo(b.get(1))).distinct().collect(Collectors.toList());
        List type_2 = obstacles.stream().filter(point -> point.get(1) == c_q).sorted((a,b) -> a.get(0).compareTo(b.get(0))).distinct().collect(Collectors.toList());
        List type_3 = obstacles.stream().filter(point -> point.get(1) == point.get(0) - r_q + c_q).sorted((a,b) -> a.get(1).compareTo(b.get(1))).distinct().collect(Collectors.toList());
        List type_4 = obstacles.stream().filter(point -> point.get(1) == -point.get(0) + r_q + c_q).sorted((a,b) -> a.get(1).compareTo(b.get(1))).distinct().collect(Collectors.toList());

        int length = 0;
        System.out.println("type_1");
        length = get_valid_length(Arrays.asList(r_q,1), Arrays.asList(r_q,n), type_1, 0, 1, r_q, c_q, n);
        count += length;
        System.out.println("    length = " + length);

        System.out.println("type_2");
        length = get_valid_length(Arrays.asList(1,c_q), Arrays.asList(n,c_q), type_2, 1, 0, r_q, c_q, n);
        count += length;
        System.out.println("    length = " + length);

        System.out.println("type_3");
        int max_diff = IntStream.rangeClosed(0, n-1).filter(diff -> r_q - diff >= 1 && c_q - diff >= 1).max().getAsInt();
        int min_row = r_q - max_diff;
        int min_col = c_q - max_diff;

        max_diff = IntStream.rangeClosed(0, n-1).filter(diff -> r_q + diff <= n && c_q + diff <= n).max().getAsInt();
        int max_row = r_q + max_diff;
        int max_col = c_q + max_diff;
        length = get_valid_length(Arrays.asList(min_row,min_col), Arrays.asList(max_row, max_col), type_3, 1, 1, r_q, c_q, n);
        count += length;
        System.out.println("    length = " + length);

        System.out.println("type_4");
        max_diff = IntStream.rangeClosed(0, n-1).filter(diff -> r_q + diff <= n && c_q - diff >= 1).max().getAsInt();
        min_row = r_q + max_diff;
        min_col = c_q - max_diff;

        max_diff = IntStream.rangeClosed(0, n-1).filter(diff -> r_q - diff >= 1 && c_q + diff <= n).max().getAsInt();
        max_row = r_q - max_diff;
        max_col = c_q + max_diff;
        length = get_valid_length(Arrays.asList(min_row,min_col),Arrays.asList(max_row,max_col), type_4, -1, 1, r_q, c_q, n);
        count += length;
        System.out.println("    length = " + length);

        return count;
    }

    public static int get_valid_length(List<Integer> start_point, List<Integer> end_point, List<List<Integer>> obstacles, int row_direction, int col_direction, int r_q, int c_q, int n) {
        int start_row = start_point.get(0);
        int start_col = start_point.get(1);
        int end_row = end_point.get(0);
        int end_col = end_point.get(1);

        int obstacle_index = 0;
        int obstacle_length = obstacles.size();

        boolean is_queen_found = false;
        int row = start_row;
        int col = start_col;
        obstacles.stream().forEach(System.out::println);
        while (is_valid_range(row, n) && is_valid_range(col, n) && obstacle_index < obstacle_length) {
            if (obstacle_index < obstacle_length && obstacles.get(obstacle_index).get(0) == row && obstacles.get(obstacle_index).get(1) == col) {
                if (is_queen_found) {
                    end_row = row;
                    end_col = col;
                    break;
                }
                else {
                    start_row = row;
                    start_col = col;
                }
                obstacle_index++;
            }
            if (row == r_q && col == c_q) {
                is_queen_found = true;
            }
            row += row_direction;
            col += col_direction;
        }

        int count = 0;
        while (start_row != (end_row + row_direction) || start_col != (end_col + col_direction)) {
            int finalStart_row = start_row;
            int finalStart_col = start_col;
            if (!(obstacles.stream().filter(point -> point.get(0) == finalStart_row && point.get(1) == finalStart_col).count() > 0 || (start_row == r_q && start_col == c_q))) {
                count++;
            }
            start_row += row_direction;
            start_col += col_direction;
        }
        //System.out.println("start = (" + start_row + "," + start_col +") , end = (" + end_row + "," + end_col + ")");
        //return Math.max((end_row - start_row + ((end_row == r_q || start_row == r_q) ? -1 : 0)), (end_col - start_col + ((end_col == c_q || start_col == c_q) ? -1 : 0))) + 1;
        return count;
    }

    public static boolean is_valid_range(int index, int max_index) {
        return index >= 1 && index <= max_index;
    }
}
