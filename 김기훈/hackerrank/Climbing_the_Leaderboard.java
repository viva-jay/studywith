import javax.xml.transform.Result;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Climbing_the_Leaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\hoon\\IdeaProjects\\input.txt"));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = null;
        try {
            result = climbingLeaderboard(ranked, player);
        } catch (Exception e) {
            System.out.println(e);
        }

        for(Integer rank : result) {
            System.out.println(rank);
        }

        bufferedReader.close();
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        List<Integer> no_dup_ranked = new HashSet<>(ranked).stream().sorted(Comparator.reverseOrder()).collect(toList());

        int right = no_dup_ranked.size() - 1;
        for (Integer player_score : player) {
            int left = 0, middle = 0;
            while (left <= right) {
                middle = (left + right) / 2;

                int m_score = no_dup_ranked.get(middle);
                if (m_score == player_score) {
                    left = middle;
                    break;
                }
                else if (m_score > player_score) {
                    left = middle + 1;
                }
                else {
                    right = middle - 1;
                }
            }
            result.add(left + 1);
            right = left - 1;
        }
        return result;
    }
}
