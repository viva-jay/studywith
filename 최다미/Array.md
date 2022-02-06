# Array (배열)

배열(Array)는 번호(Index)와 번호에 대응하는 데이터들로 이루어진 자료구조를 나타낸다.

![Array](https://upload.wikimedia.org/wikipedia/commons/3/3f/Array1.svg)

일반적으로 배열에는 같은 종류의 데이터들이 순차적으로 저장되어, 값의 번호가 곧 배열의 시작점으로부터 값이 저장되어 있는 상대적인 위치가 된다.

배열은 메모리 상에 고정된 크기의 연속된 공간을 갖기 때문에 한 번 생성된 배열의 크기는 변경할 수 없기 때문에, 처음 배열을 생성할 때 크기를 적절하게 지정해줘야 한다.


## 주어진 숫자와 동일한 두 수의 합 구하기
### 문제 : [Two Sum](https://leetcode.com/problems/two-sum/)
**Brute force 를 이용한 풀이**
- 시간 복잡도 : n개의 요소를 두 개의 for 루프를 사용하여 탐색하므로 시간 복잡도는 O(n<sup>2</sup>) 이다.
- 공간 복잡도 : n의 값에 상관없이 변수 result 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
``` java
class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i != j && nums[i] + nums[j] == target) {
          result = new int[] {i, j};
        }
      }
    }
    
    return result;
  }
}
```

** HashMap을 이용한 최적화 방법**
- 시간 복잡도 : n개의 요소에 대해 O(1)의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n개의 요소를 저장할 해시 테이블이 필요하므로 공간 복잡도는 O(n) 이다.
- 풀이
```java
class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[] {map.get(nums[i]), i};
      }
      
      map.put(target - nums[i], i);
    }
    return new int[] {};
  }
}
```

## 배열의 요소 제거하기
### 문제 : [Remove Element](https://leetcode.com/problems/remove-element/)
**Two Pointer 를 이용한 풀이 방법**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다. n은 주어진 숫자들의 갯수이다.
- 공간 복잡도 : n의 값에 상관없이 변수 count 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
``` java
class Solution {
  public int removeElement(int[] nums, int val) {
    int count = 0;
    
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[count++] = nums[i];
      }
    }
    
    return count;
  }
}
```
