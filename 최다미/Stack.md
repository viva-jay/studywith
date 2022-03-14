# Stack (스택)

스택이란 한 쪽 끝에서 자료를 넣고 뺄 수 있는 LIFO(Last In First Out) 형식의 자료 구조를 말한다.

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