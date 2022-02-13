### Hash Table

`빠른 insert와 search`을 지원하기 위해서  hash function을 사용하여 데이터를 구성하는 data structure이다. Hash Table은 hash map과 hash set이 있다. 자바 컬렉션은 둘다 지원을 한다.

* hash set은 반복되지 않은 값을 저장하는 set data structure의 구현 중 하나이다.
* hash map은 (key,value)쌍을 저장하기 위한 map data structure의 구현 중 하나이다.



### The Principle of Hash Table

핵심 아이디어는 hash function을 사용하여 키를 버킷에 매핑하는 것이다. 새로운 키를 insert하면 hash function이 키를 할당해야 하는 버킷을 결정하고 키가 해당 버킷에 저장된다. 키를 이용하여 검색하려는 경우 hash table은 동일한 hash function을 사용하여 해당 버킷을 찾고 그 버킷에서 검색한다.



 `y = x % 5`를 hash function으로 사용하고 위와 같은 상황이 주어 질때 insertion과 search는 다음과 같이 동작 한다.

* insertion
  * hash function을 통해 키를 파싱하여 해당 버킷에 맵핑한다. 위의 예제에서 키1987는 버킷 2에 할당 될 것이다.
* search
  * hash function을 통해 키를 분석하고 특정 버킷을 찾는다. 키 1987에 해당하는 value를 찾는다면 버킷2에서 1987을 찾을 것이다. 



##### Hash Function

hash function은 키를 특정 버킷에 매핑하는데 사용되는 hash table의 가장 중요한 구성요소이며 `키 값의 범위`와 `버킷 수`에 따라 달라진다. function을 설계하는 것은 가능한 한 균일하게 키를 버킷에 할당하는 것이다. 이상적으로 완벽한 hash function는 키와 버킷이 1:1로 맵핑 된다.  그러나 대부분의 경우 완벽하지 않으며 버킷의 양과 버킷의 용량의 tradeoff이다.



##### collision resolution

앞서 설명 하였듯이 대부분의 경우 충돌은 거의 불가피하다. 앞서 보았던 예시에서 1987과 2는 모두 버킷 2에 할당 되어 충돌을 일으켰다. 충돌을 해결 하기 위해선 다음과 같은 질문을 해 볼 수 있다.

1. 동일한 버킷에서 값을 어떻게 구성할 것인가?
2. 동일한 버킷에 너무 많은 값이 할당되면 어떻게 해야할까?
3. 특정 버킷에서 대상 값을 어떻게 검색 해야할까?

이러한 질문은 버킷의 용량 및 hash function에 따라 동일한 버킷에 매핑될 수 있는 키의 개수와 관련이 있다. 최대 N개의 수를 보유할 수 있는 버킷에 N개의 키가 있다고 가정하자. 일반적으로 N이 일정하고 작으면 배열을 사용하여 동일한 버킷에 키를 저장할 수 있다.  N이 가변적이거나 크면 `height-balanced binary search tree`(높이 균형 이진 탐색 트리)를 대신 사용해야 할 수도 있다.