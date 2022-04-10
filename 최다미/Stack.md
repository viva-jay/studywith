# Stack (스택)

스택이란 한 쪽 끝에서 자료를 넣고 뺄 수 있는 LIFO(Last In First Out) 형식의 자료 구조를 말한다.

## 스택 예제
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();   // 7 제거
        stack.push(1);
        stack.push(4);
        stack.pop();   // 4 제거
        
        // 스택의 최상단 원소부터 출력
        // 실행 결과 : 1 3 2 5
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
```

## 유효한 괄호
### 문제 : [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
**문제 풀이**
- 시간 복잡도 : 문자열 개수 n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : 최악의 경우 길이가 n개의 공간이 필요하므로, 공간 복잡도는 O(n) 이다.
- 풀이
```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peekFirst() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
```