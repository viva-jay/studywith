# Queue (큐)

큐(Queue)는 한쪽 끝에서 원소를 넣고 반대쪽 끝에서 원소를 뺄 수 있는 자료구조이며, FIFO(First in First Out)이라고 하기도 한다.   
이는 나중에 집어 넣은 데이터가 먼저 나오는 스택(Stack)과는 반대되는 개념이다.

큐에서 연산의 시간 복잡도를 보면, 
- 원소의 추가와 제거가 모두 O(1)이다.
- 가장 앞/뒤에 위치한 원소의 확인도 O(1)이다.
- 가장 앞/뒤가 아닌 나머지 원소들의 확인/변경이 원칙적으로 불가능하다.

큐의 종류에는 선형과 환형이 있다.

### 문제 : [933. Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)
**문제 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : 공간 복잡도는 O(n) 이다.
- 풀이
    ```java
    class RecentCounter {
        Queue<Integer> queue;
        
        public RecentCounter() {
            queue = new LinkedList<>();
        }
        
        public int ping(int t) {
            queue.add(t);
            while (!queue.isEmpty() && queue.size() > 0 && t - queue.peek() > 3000) {
                queue.poll();
            }
            
            return queue.size();
        }
    }
    ```
  
### 문제 : [2073. Time Needed to Buy Tickets](https://leetcode.com/problems/time-needed-to-buy-tickets/)
**Brute Force를 이용한 문제 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(n) 의 탐색을 하므로 시간 복잡도는 O(n<sup>2</sup>) 이다.
- 공간 복잡도 : n의 값과 상관 없이 변수 countTime 만 필요하므로 공간 복잡도는 O(1) 이다.
- 풀이
```java
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
    int countTime = 0;
        while (true) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    countTime++;
                }
                if (i == k && tickets[i] == 0) {
                    return countTime;
                }
            }
        }
    }
}
```

**1개의 loop로 최적화한 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n의 값과 상관 없이 변수 countTime 만 필요하므로 공간 복잡도는 O(1) 이다.
- 풀이
```java
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int countTime = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                countTime += Math.min(tickets[k], tickets[i]);
            } else {
                countTime += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return countTime;
    }
}
```

**Queue를 이용한 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : 공간 복잡도는 O(n) 이다.
- 풀이
```java
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i == k ? -tickets[i] : tickets[i]);
        }
        
        int countTime = 0;
        while (!queue.isEmpty()) {
            countTime++;
            
            int front = queue.poll();
            if (front < 0) {
                if (front == -1)
                    break;
                else
                    queue.add(front + 1);
            } else if (front != 1) {
                queue.add(front - 1);
            }
        }
        return countTime;
    }
}
```