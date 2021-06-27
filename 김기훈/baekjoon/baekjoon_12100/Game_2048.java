import java.util.Scanner;
import java.util.Stack;

public class Game_2048 {
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int result = solution(N, map);
        System.out.println(result);
    }

    public static int solution(int N, int[][] map) {
        dfs(0, 5, map, N);
        return answer;
    }

    public static void dfs(int curDepth, int depth, int[][] map, int N) {
        if (curDepth == depth) {
            answer = Math.max(answer, getBiggestNum(map, N));
            return;
        }

        for(int i=0; i<4; i++) {
            dfs(curDepth + 1, depth, moveMap(map, i, N), N);
        }
    }

    public static int getBiggestNum(int[][] map, int N) {
        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                result = Math.max(result, map[i][j]);
            }
        }
        return result;
    }

    public static int[][] moveMap(int[][] map, int direction, int N) {
        int[][] newMap = new int[N][N];
        Stack<Integer> s = new Stack<>();
        boolean isMerged = false;

        if (direction == 0) {  // up
            for(int col=0; col<N; col++) {
                isMerged = false;
                for(int row=0; row<N; row++) {
                    if (map[row][col] == 0) continue;

                    if (!s.isEmpty() && s.peek() == map[row][col] && !isMerged) {
                        s.push(s.pop() * 2);
                        isMerged = true;
                    }
                    else {
                        s.push(map[row][col]);
                        isMerged = false;
                    }
                }

                int newIndex = s.size() - 1;
                while (!s.isEmpty()) {
                    newMap[newIndex][col] = s.pop();
                    newIndex--;
                }
            }
        }
        if (direction == 1) {  // right
            for(int row=0; row<N; row++) {
                isMerged = false;
                for(int col=N-1; col>=0; col--) {
                    if (map[row][col] == 0) continue;

                    if (!s.isEmpty() && s.peek() == map[row][col] && !isMerged) {
                        s.push(s.pop() * 2);
                        isMerged = true;
                    }
                    else {
                        s.push(map[row][col]);
                        isMerged = false;
                    }
                }

                int newIndex = N - s.size();
                while (!s.isEmpty()) {
                    newMap[row][newIndex] = s.pop();
                    newIndex++;
                }
            }
        }
        if (direction == 2) {  // down
            for(int col=0; col<N; col++) {
                isMerged = false;
                for(int row=N-1; row>=0; row--) {
                    if (map[row][col] == 0) continue;

                    if (!s.isEmpty() && s.peek() == map[row][col] && !isMerged) {
                        s.push(s.pop() * 2);
                        isMerged = true;
                    }
                    else {
                        s.push(map[row][col]);
                        isMerged = false;
                    }
                }

                int newIndex = N - s.size();
                while (!s.isEmpty()) {
                    newMap[newIndex][col] = s.pop();
                    newIndex++;
                }
            }

        }
        if (direction == 3) {  // left
            for(int row=0; row<N; row++) {
                isMerged = false;
                for(int col=0; col<N; col++) {
                    if (map[row][col] == 0) continue;

                    if (!s.isEmpty() && s.peek() == map[row][col] && !isMerged) {
                        s.push(s.pop() * 2);
                        isMerged = true;
                    }
                    else {
                        s.push(map[row][col]);
                        isMerged = false;
                    }
                }

                int newIndex = s.size() - 1;
                while (!s.isEmpty()) {
                    newMap[row][newIndex] = s.pop();
                    newIndex--;
                }
            }
        }
        return newMap;
    }
}
