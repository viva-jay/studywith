import java.util.*;
import java.util.stream.Collectors;

public class nonDivisibleSubset {
    public static void main(String[] args) {
        int k = 7;
        List<Integer> s = Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436);
        int result = nonDivisibleSubset(k, s);
        System.out.println(result);
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int n = s.size();
        int[] reminder = new int[k];

        for(int i=0; i<n; i++) {
            int t = s.get(i) % k;
            reminder[t] = reminder[t] + 1;
        }

        int max_length = 0;
        if (k%2 == 0) reminder[k/2] = Math.min(1, reminder[k/2]); // Any(reminder[k/2]) + Any(reminder[k/2]) % k = 0 이므로, 해당 집합에서는 최대 1개만 선택 가능
        for(int i=1; i<=k/2; i++) {
            max_length = max_length + Math.max(reminder[i], reminder[k-i]);  // Any(reminder[i]) + Any(reminder[k-i]) % k = 0 이므로, 양립할 수 없는 두 집합에서 개수가 많은 것을 우선적으로 선택
        }
        max_length = max_length + Math.min(1, reminder[0]);  // Any(reminder[0]) + Any(reminder[0]) % k = 0 이므로, 해당 집합에서도 최대 1개만 선택 가능
        return max_length;
    }

/*    public static boolean comb(List<Integer> arr, boolean[] visited, int start, int n, int r, int k) {
        if (r == 0) {
            return do_something(arr, visited, n, k);
        }
        else {
            for(int i=start; i<n; i++) {
                visited[i] = true;
                boolean result = comb(arr, visited, i+1, n, r-1, k);
                if(!result) return result;
                visited[i] = false;
            }
        }
        return true;
    }

    public static boolean do_something(List<Integer> arr, boolean[] visited, int n, int k) {
        boolean is_divided = false;
        for(int i = 0; !is_divided && i<n; i++) {
            if (!visited[i]) continue;
            int num1 = arr.get(i);
            for(int j=i+1; !is_divided && j<n; j++) {
                if (!visited[j]) continue;
                int num2 = arr.get(j);
                if ((num1 + num2) % k == 0) is_divided = true;
            }
        }
        return is_divided;
    }*/
}

/*
* [ 조합 원리 ]
* 경우의 수의 순서가 있는 경우 Permutation
순서가 없는 경우 Combination 이라고 한다.

순서가 있다는 것이 보장이 되면,
각 경우의 수는 서로 완전히 구분되는 독립적인 경우이다.
따라서, 5개의 사과 중 3개를 고른다고 했을 때,
처음에 고를 수 있는 경우의 수 = 5
두번째에 고를 수 있는 경우의 수 = 4
세번째에 고를 수 있는 경우의 수 = 3
이 되어, 5 x 4 x 3 = 60개가 되는 것이다.

순서가 없다는 것이 보장이 되면,
위 방식대로 구한 경우의 수 대부분은 중복이다.
예컨데, 1,2,3번을 고른 것과 2,3,1번을 고른 것은 뽑은 순서는 다르겠지만
실제로는 같은 집합을 구성하고 있다는 것이다.

따라서, 중복을 제거하기 위해서는
동시에 양립할 수 없는 경우로 쪼개서
각 독립적인 상황을 더해주어야 한다.

그렇다면, 동시에 양립할 수 없는 경우란 어떤 것일까?
동전을 던졌을 때 앞면이 나오는 경우, 뒷면이 나오는 경우 (양자역학 없다고 가정)
게임에서 승리하는 경우, 패배하는 경우 (무승부 없다고 가정, 정신승리 없다고 가정)
network ping을 보냈을 때 pong이 오는 경우, 오지 않는 경우
등등등 다양하다

우리는 무언가를 선택하는 조합 문제를 풀고 있기 때문에
동시에 양립할 수 없는 경우는 '사과 하나를 선택하는 경우', '사과 하나를 선택하지 않는 경우' 라고 볼 수 있다
5개의 사과 중 '사과 하나를 선택하는 경우'란 4개의 사과 중 나머지 2개를 선택해야만 하는 경우와 같고,
5개의 사과 중 '사과 하나를 선택하지 않은 경우'란 4개의 사과 중 3개를 선택해야만 하는 경우와 같다
즉, 5C3 = 4C2 + 4C3 으로 생각할 수 있다.

Q) 사과 하나를 선택하는 경우는 5C1이 아닌가요?
그러면 5C1*4C2 + 5C0*4C3 으로 생각해야하는거 아닌가요?
A) 아닙니다. 곱셈이란 곧 사건의 연속성을 의미합니다.
(서울-대구-부산 으로 연결된 경우, 서울에서 대구가는 경우 3가지, 대구에서 부산 가는 경우 2가지라면,
서울에서 부산으로 가는 경우는 3*2 = 6가지 입니다. 이는 위 경우가 연속성을 가지기 때문에 곱셈으로 연결해주는게 맞습니다)
5C1*4C2를 해석해보면 '우선 5개 중의 1개를 선택하고 나머지 4개 중에 2개를 선택한다'로 해석할 수 있습니다.
즉, 처음에 1번 사과를 선택한 경우, 2번 사과를 선택한 경우, 3번 사과를 선택한 경우, 4번 사과를 선택한 경우, 5번 사과를 선택한 경우
를 가지고 이 각각의 시작점마다 또 4C2를 가진다는 것인데, 이 4C2에는 첫 번째 시작점에 위치한 사과를 선택하는 경우도 포함되어 있으므로
애초에 5C1*4C2라는 방식에는 중복이 생길 수밖에 없다.
(ex 1,3,2 를 예시로 들면 두 번째에 3을 뽑았는데, 이는 첫 번째에 3을 뽑는 경우와 중복될 수 있습니다. 1,3,2 = 3,1,2)

그저 '원소를 하나 선택하는 경우'를 하나의 경우라고 보고
마찬가지로 '원소를 선택하지 않는 경우'를 하나의 경우라고 보시면,
5C3 = 1 * 4C2 + 1 * 4C3 으로 생각하는 것이 더 적합합니다.
*
* */