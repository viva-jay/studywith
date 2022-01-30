# Linked List (연결 리스트)

연결 리스트(Linked List)는 배열과 같이 연속적인 메모리 위치에 저장되지 않고, 포인터를 사용하여 연결하는 선형 데이터 구조이다. ‘노드(Node)’라는 객체로 이루어져 있으며, 각 노드는 데이터 필드와 다음 노드에 대한 참조를 포함하는 노드로 구성이 된다.


연결 리스트를 사용하는 이유는

1. 배열의 크기가 고정되어 있어서 미리 요소의 수에 대해 할당 받아야 하는 문제
2. 새로운 요소를 삽입하는 것이 비용이 많이 듦으로 비효율적

이라는 점이 있다.


연결 리스트는 연속적인 메모리 공간이 없어도 데이터를 저장하는 것이 가능하며, 미리 메모리 공간을 확보할 필요가 없다는 장점이 있는 반면, 링크 필드를 위한 추가 공간이 필요하므로 저장공간 효율이 높지 않고, 순차 탐색을 해야 하므로 탐색 속도가 떨어진다는 단점이 있다.

따라서, 탐색 혹은 정렬이 빈번히 일어나는 경우에는 배열을, 데이터의 추가 및 삭제 연산이 많을 경우에는 연결 리스트를 사용하는 것이 좋다.

연결 리스트에는 다음과 같이 3종류가 있다.
- 단일 연결 리스트 : 각 노드에 자료 공간과 한 개의 포인터 공간이 있고, 각 노드의 포인터는 다음 노드를 가리킨다.
  ![단일 연결 리스트](https://upload.wikimedia.org/wikipedia/commons/9/9c/Single_linked_list.png)

- 이중 연결 리스트 : 구조가 단일 연결 리스트와 비슷하지만, 포인터 공간이 두 개가 있고 각각의 포인터는 앞의 노드와 뒤의 노드를 가리킨다.
  ![이중 연결 리스트](https://upload.wikimedia.org/wikipedia/commons/c/ca/Doubly_linked_list.png)

- 원형 연결 리스트 : 일반적인 연결 리스트에 마지막 노드와 처음 노드를 연결시켜 원형으로 만든 구조이다.
  ![원형 연결 리스트](https://upload.wikimedia.org/wikipedia/commons/9/98/Circurlar_linked_list.png)


## 연결 리스트의 이진수를 정수로 변환하기
### 문제 : [Convert Binary Number in a Linked List to Integer](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/)
**비트 조작을 이용한 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n의 값에 상관없이 변수 decimalValue 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public int getDecimalValue(ListNode head) {
      int decimalValue = 0;
      while (head != null) {
         decimalValue = (decimalValue << 1) + head.val;
         head = head.next;
      }
      
      return decimalValue;
   }
}
```

## 연결 리스트의 중간 노드 찾기
### 문제 : [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
**Two Pointer 를 이용한 풀이 방법**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다. n은 주어진 목록의 노드 수이다.
- 공간 복잡도 : n의 값에 상관없이 변수 slow 와 변수 fast 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
```

**Brute Force 를 이용한 풀이 방법**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다. n은 주어진 목록의 노드 수이다.
- 공간 복잡도 : n의 값에 상관없이 변수 deque 와 변수 headCopy, 변수 top 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode middleNode(ListNode head) {
    if (head == null && head.next == null) {
      return null;
    }
    
    ArrayDeque<ListNode> deque = new ArrayDeque<>();
    ListNode headCopy = head;
    
    while (headCopy != null) {
      deque.push(headCopy);
      headCopy = headCopy.next;
    }
    
    int count = deque.size() % 2 == 0 ? deque.size() / 2 : deque.size() / 2 + 1;
    ListNode top = null;
    
    while (count-- > 0) {
      top = deque.pop();
    }
    
    return top;
  }
}
```
