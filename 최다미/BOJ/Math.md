# Math (수학)

## 피타고라스 정리
세 자연수 a, b, c의 값을 입력받은 후 a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup> 를 만족하는지 확인하면 된다.

a, b, c 중 어떤 값이 대각선인지 모를 경우 if 문을 활용하여 3가지의 경우로 나눈다.   
a가 대각선일 경우, a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup>   
b가 대각선일 경우, b<sup>2</sup> = a<sup>2</sup> + c<sup>2</sup>   
c가 대각선일 경우, c<sup>2</sup> = a<sup>2</sup> + b<sup>2</sup>


### 문제 : [4153. 직각삼각형](https://www.acmicpc.net/problem/4153)
**피타고라스의 정리 공식을 이용한 문제 풀이**
- 시간 복잡도 : n개의 요소를 하나의 while 루프를 사용하여 탐색하므로 시간 복잡도는 O(n) 이다.
- 공간 복잡도 : n의 값에 상관없이 변수 a, b, c 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}
```

- 거듭제곱을 구하기 위한 java.lang.Math 클래스의가 pow() 메소드를 이용한 풀이
```java
if ((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) ||
    Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) ||
    Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
    sb.append("right").append("\n");
} else {
    sb.append("wrong").append("\n");
}
```