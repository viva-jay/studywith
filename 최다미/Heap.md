# Heap (힙)

힙은 특수한 유형의 이진 트리이며, 다음 기준을 충족한다.

- 완전한 이진 트리이다.
- 각 노드의 값은 자식 노드의 값보다 크거나 작지 않아야 한다.

힙에는 다음과 같은 속성이 있다.
- 힙에 요소를 삽입하는 것은 시간 복잡도가 O(log N) 이다.
- 힙에서 요소 삭제는 시간 복잡도가 O(log N) 이다.
- 힙의 최대/최소 값은 시간 복잡도가 O(1) 이다.

힙에는 최대 힙과 최소 힙의 두 가지 종류가 있다.
- 최대 힙(max-heap) : 힙의 각 노드는 자식 노드보다 작지 않은 값을 갖는다. 따라서 최상위 요소(루트 노드)는 힙에서 가장 큰 값을 갖는다.
- 최소 힙(min-heap) : 힙의 각 노드는 자식 노드보다 크지 않은 값을 갖는다. 따라서 최상위 요소(루트 노드)는 힙에서 가장 작은 값을 갖는다.

[!최소 힙 및 최대 힙 다이어그램](https://leetcode.com/explore/featured/card/Figures/heap_explore/1_1_min_max_heap_diagram_new.png)

## 테이블 재구성
### 문제 : [1464. Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)
**두 개의 loop를 이용한 문제 풀이**
- 시간 복잡도 : n개의 요소를 두 개의 for 루프를 사용하여 탐색하므로 시간 복잡도는 O(n<sup>2</sup>) 이다.
- 공간 복잡도 : n의 값에 상관없이 변수 max 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
``` java
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return max;
    }
}
```

**두 개의 변수를 이용한 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n의 값에 상관없이 변수 max1, 변수 max2 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
```java
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        
        if (nums.length == 2) {
            return (nums[1] - 1) * (nums[0] - 1);
        }
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        
        return (max1 - 1) * (max2 - 1);
    }
}
```

