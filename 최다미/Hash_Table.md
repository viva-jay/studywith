# Hash Table (해시 테이블)

해시 테이블(Hash Table)은 (Key, Value)의 형태로 데이터를 저장하는 자료구조 중 하나로 빠르게 데이터를 검색할 수 있는 자료구조이다. 

해시 테이블 구조를 이름은 키(Key), 전화 번호는 값(Value)인 전화번호부라고 가정해보자.

전체 Data의 양을 16명이라고 했을 때, John Smith의 데이터를 저장할 때 `index = hash_function("John Smith") % 16`를 통해서 index 값을 구해내고, array[16] = "John Smith의 전화번호 521-8976"을 저장한다.

![A small phone book as a hash table](9https://en.wikipedia.org/wiki/Hash_table#/media/File:Hash_table_3_1_1_0_1_0_0_SP.svg)

이런 형식으로 데이터를 저장하면, key에 대한 데이터를 찾을 때 hash_function을 한 번만 수행하면 array 내에 저장된 index 위치를 찾아낼 수 있기 때문에, 기존 자료구조인 이진탐색트리나 배열에 비해서 굉장히 빠른 속도로 탐색(Search), 삽입(Insert), 삭제(Delete)를 할 수 있다.

그런데, 이 해시 테이블에는 근본적인 문제가 따르는데, `hash_function(key) / size_of_array`의 값이 중복이 될 수가 있다.

예를 들어, 저장하고자 하는 key가 정수이고 hash_function이 key % 10 이라고 하자. size_of_array가 10일 때, key 1, 11, 21, 31은 같은 index 값을 가지게 된다. 

이를 충돌(Collision)이라고 하는데, 충돌 해결을 위한 일반적인 방법에는 하기와 같이 두 가지가 있다.

1. Separate Chaining 방식

   Linked list를 이용하는 방식으로, 각 index에 데이터를 저장하는 Linked list에 대한 포인터를 가지는 방식이다.
      
   ![Hash collision resolved by separate chaining](https://en.wikipedia.org/wiki/Hash_table#/media/File:Hash_table_5_0_1_1_1_1_1_LL.svg)
      
   만약에 동일한 index로 인해서 충돌이 발생하면 그 index가 가리키고 있는 Linked list에 노드를 추가하여 값을 추가한다. 이렇게 함으로써 충돌이 발생하더라도 데이터를 삽입하는데 문제가 없다.

   데이터를 추출을 하고자할때는 key에 대한 index를 구한후, index가 가리키고 있는 Linked list를 선형 검색하여, 해당 key에 대한 데이타가 있는지를 검색하여 리턴하면 된다.


2. Open Addressing 방식
   
   Open Addressing 방식은 index에 대한 충돌 처리에 대해서 Linked list와 같은 추가적인 메모리 공간을 사용하지 않고, hash table array의 빈공간을 사용하는 방법으로, Separate chaining 방식에 비해서 메모리를 덜 사용한다.
   


## 보석과 돌
### 문제 : [Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)
**HashMap 을 이용한 풀이**
- 시간 복잡도 : n개의 요소와 m개의 요소에 대해 각각 O(1) 의 탐색을 하므로 시간 복잡도는 O(n+m) 이다. 여기서 n은 jewels, m은 stones 의 수를 말한다.
- 공간 복잡도 : HashMap을 사용하여 stones의 값을 저장하므로, 공간 복잡도는 O(n) 이다.
- 풀이
``` java
class Solution {
   public int numJewelsInStones(String jewels, String stones) {
      Map<Character, Integer> stone = new HashMap<>();
      int jewelCount = 0;
      
      for (int i = 0; i < stones.length(); i++) {
         stone.put(stones.charAt(i), stone.getOrDefault(stones.charAt(i), 0) + 1);
      }
      
      for (int i = 0; i < jewels.length(); i++) {
         jewelCount += stone.getOrDefault(jewels.charAt(i), 0);
      }
      
      return jewelCount;
   }
}
```

**indexOf() 를 이용한 풀이 방법**
- 시간 복잡도 : n개의 요소에 대해 O(1) 의 탐색을 하므로 시간 복잡도는 O(n) 이다. 여기서 n은 jewels 의 수를 말한다.
- 공간 복잡도 : n의 값에 상관없이 변수 jewelCount 만 필요하므로, 공간 복잡도는 O(1) 이다.
- 풀이
```java
class Solution {
   public int numJewelsInStones(String jewels, String stones) {
      int jewelCount = 0;

      for (int i = 0; i < stones.length(); i++) {
         if (jewels.indexOf(stones.charAt(i)) != -1) {
            jewelCount++;
         }
      }
      return jewelCount;
   }
}
```
