# Greedy (탐욕법)

그리디 알고리즘을 사용하면 어떤 기준에 따라 매 순간 가장 좋아보이는 것을 선택한다.
그러나 현재의 선택이 미래에 미칠 영향까지는 고려하지 않기 때문에 항상 최적의 답을 도출하는 것은 아니다.

그리디 알고리즘은
- 탐욕 선택 속성(Greedy choice property) : 현재 선택이 이후의 선택에 영향을 주지 않음
- 최적 부분 구조(Optimal Substructure) : 매 순간의 최적의 해가 문제 전체에 대한 최적의 해여야 함

특성을 가지는 문제들을 해결하는 데 강점이 있다. 즉, 한 번의 선택이 다음 선택에는 전혀 무관한 값이어야 하며, 매 순간의 최적해가 문제에 대한 최적해야 한다는 의미이다.

> **용어 참조**
> - 최적해 : 선형 계획법에서, 제약 조건을 충족시킬 수 있는 해 가운데 목적 함수값을 최대 또는 최소로 만드는 값.

## 거스름돈 문제
### 문제 : [Lemonade change](https://leetcode.com/problems/lemonade-change/)
**문제 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n의 값에 상관없이 변수 fiveCount, 변수 tenCount 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
  ```java
  class Solution {
    public boolean lemonadeChange(int[] bills) {
      if (bills[0] != 5) {
          return false;
      }
      
      int fiveCount = 0;
      int tenCount = 0;
      
      for (int i = 0; i < bills.length; i++) {
        if (bills[i] == 5) {
          fiveCount++;
        } else if (bills[i] == 10) {
          if (fiveCount <= 0) {
              return false;
          }
          fiveCount--;
          tenCount++;
        } else {
          if (fiveCount > 0 && tenCount > 0) {
            tenCount--;
            fiveCount--;
          } else if (fiveCount >= 3) {
            fiveCount -= 3;
          } else {
            return false;
          }
        }
      }
      return true;
    }
  }
  ```
  

**Hash 를 이용한 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n의 값에 상관없이 key 5와 key 10의 value 값만 저장할 공간이 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
  ```java
  class Solution {
    public boolean lemonadeChange(int[] bills) {
      if (bills[0] != 5) {
        return false;
      }
        
      Map<Integer, Integer> change = new HashMap<>();
      change.put(5, 0);
      change.put(10, 0);
        
      for (int i = 0; i < bills.length; i++) {
        if (bills[i] == 5) {
          change.put(bills[i], change.getOrDefault(bills[i], 0) + 1);
        } else if (bills[i] == 10) {
          if (change.get(5) < 1) {
              return false;
          } else {
            change.put(5, change.get(5) - 1);
            change.put(bills[i], change.getOrDefault(bills[i], 0) + 1);
          }
        } else {
          if (change.get(5) > 0 && change.get(10) > 0) {
            change.put(5, change.get(5) - 1);
            change.put(10, change.get(10) - 1);
          } else if (change.get(10) == 0 && change.get(5) > 2) {
            change.put(5, change.get(5) - 3);
          } else {
            return false;
          }
        }
      }
      return true;
    }
  }
  ```