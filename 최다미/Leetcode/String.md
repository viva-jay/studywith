# String (문자열)

문자열 알고리즘은 특정한 글에서 특정 문자 또는 문자열을 찾아낸다.

1. 단순 문자열 알고리즘
    
    단순히 하나씩 비교하는 가장 간단한 형태의 알고리즘으로, 찾을 문자열을 전체 문장의 처음 부분에 두고 일치할 때까지 한 칸씩 이동하며 비교한다.
    
2. KMP(Knuth-Morris-Pratt) 알고리즘
    
    대표적인 문자열 매칭 알고리즘으로, 모든 경우를 다 비교하지 않아도 부분 문자열을 찾을 수 있는 알고리즘이다. 접두사, 접미사를 이용하여 불필요한 연산은 스킵하여 연산을 줄인다.
    
## 연속된 문자열의 최대 길이 구하기
### 문제 : [Consecutive Characters](https://leetcode.com/problems/consecutive-characters/)
**문제 풀이**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n의 값에 상관없이 변수 count, 변수 maxCount, 변수 prevC 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
``` java
class Solution {
  public int maxPower(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int count = 0, maxCount = 0;
    char prevC = ' ';

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (prevC == c) {
        // 이전 문자와 같으면 count + 1 한다.
        count++;
      } else {
        // 아니면 count를 초기화 한다.
        count = 1;
        prevC = c;
      }

      maxCount = Math.max(count, maxCount);
    }

    return maxCount;
  }
}
```

## 문자열 일치 구현
### 문제 : [Implement strStr()](https://leetcode.com/problems/implement-strstr/)
**Brute Force를 이용한 풀이 방법**
- 시간 복잡도 : 시간 복잡도는 O(M*N) 이다. 여기서 M은 haystack의 길이, N은 needle의 길이이다.
- 공간 복잡도 : 공간 복잡도는 O(1) 이다.
- 풀이
``` java
class Solution {
  public int strStr(String haystack, String needle) {
    int haystackLen = haystack.length();
    int needleLen = needle.length();

    if (needleLen == 0) {
      return 0;
    }
    if (haystackLen < needleLen) {
      return -1;
    }

    for (int i = 0; i <= haystackLen - needleLen; i++) {
      int j = 0;
      while (j < needleLen && haystack.charAt(i + j) == needle.charAt(j)) {
        j++;
      }
      if (j == needleLen) {
        return i;
      }
    }
    return -1;
  }
}
```

**KMP를 이용한 풀이 방법**
- 시간 복잡도 : 조회 테이블을 생성하고(O(N)), haystack 에서 needle을 찾기 때문에(O(M)) 시간 복잡도는 O(M + N) 이다.
- 공간 복잡도 : 조회 테이블을 생성하기 위한 공간이 필요하므로 공간 복잡도는 O(N) 이다. M은 haystack의 길이, N은 needle의 길이이다.
- 풀이
```java
class Solution {
  public int strStr(String haystack, String needle) {
  if (haystack.equals("")) {
    if (needle.equals("")) {
      return 0;
    } else {
      return -1;
    }
  }
  if (needle.equals("")) {
    return 0;
  }

  int[] array = kpmLookUp(needle);	// needle의 길이 저장
  int i = 0, j = 0;

  while (i < needle.length() && j < haystack.length()) {
    if (needle.charAt(i) == haystack.charAt(j) && i == needle.length() - 1) {
      // 마지막 문자가 일치하는 경우
      return j - i;
    } else if (needle.charAt(i) == haystack.charAt(j)) {
      // 문자가 일치하는 경우
      i++;
      j++;
    } else {
      // 문자가 일치하지 않는 경우
      if (i != 0) {
        i = array[i - 1];
      } else {
        j++;
      }
    }
  }

  return -1;
  }

  private int[] kpmLookUp(String needle) {
    int i = 0;
    int j = 1;

    int[] table = new int[needle.length()];
    table[0] = 0;

    while (j < needle.length()) {
      if (needle.charAt(i) == needle.charAt(j)) {
        i++;
        table[j] = i;
        j++;
      } else if (i == 0) {
        // 첫 번째 문자가 일치하지 않을 때
        table[j] = 0;
        j++;
      } else {
        // 문자가 불일치할 경우
        i = table[i - 1];
      }
    }

    return table;
  }
}
```
