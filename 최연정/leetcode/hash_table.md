### Hash Table

`빠른 insert와 search`을 지원하기 위해서  hash function을 사용하여 데이터를 구성하는 data structure이다. Hash Table은 hash map과 hash set이 있다. 자바 컬렉션은 둘다 지원을 한다.

* hash set은 반복되지 않은 값을 저장하는 set data structure의 구현 중 하나이다.

* hash map은 (key,value)쌍을 저장하기 위한 map data structure의 구현 중 하나이다.

  

### The Principle of Hash Table

Hash Table을 구현의 핵심은 Hash finction과 Collision resolution 이다.   hash function을 사용하여 키를 버킷에 매핑. 새로운 키를 insert하면 hash function이 키를 할당해야 하는 버킷을 결정하고 키가 해당 버킷에 저장된다. 키를 이용하여 검색하려는 경우 hash table은 동일한 hash function을 사용하여 해당 버킷을 찾고 그 버킷에서 검색한다.

![스크린샷 2022-02-13 오후 9 07 13](https://user-images.githubusercontent.com/37570093/153752483-63f702dc-c175-45cc-a5b7-8dc57c13404e.png)

 `y = x % 5`를 hash function으로 사용하고 위와 같은 상황이 주어 질때 insertion과 search는 다음과 같이 동작 한다.

* insertion
  * hash function을 통해 키를 파싱하여 해당 버킷에 맵핑한다. 위의 예제에서 키1987는 버킷 2에 할당 될 것이다.
  
* search
  * hash function을 통해 키를 분석하고 특정 버킷을 찾는다. 키 1987에 해당하는 value를 찾는다면 버킷2에서 1987을 찾을 것이다. 
  
    

 ### Hash Function

hash function은 키를 특정 버킷에 매핑하는데 사용되는 hash table의 가장 중요한 구성요소이며 `키 값이 가지는 범위`와 `버킷 수`에 따라 달라진다. 이론적으로 이상적으로 완벽 한 function은 hash function는 키와 버킷이 1:1로 맵핑된다.  버킷이 많을 수록 충돌이 발생 할 가능성은 줄어든다. 그러나 대부분의 경우 가능하지 않으며 버킷의 수와  collision의 tradeoff이다. 일반적으로  `y = x modulo base` 같은 연산을 활용하는데 여기서 base가 최종적으로 가질 버킷 수를 결정한다. base는 잠재적 충돌을 줄이기 위해 769와 같은 소수를 사용한다.

![스크린샷 2022-02-20 오후 3.17.41](/Users/yeonjeongchoi/Library/Application Support/typora-user-images/스크린샷 2022-02-20 오후 3.17.41.png)





### collision resolution

해시 함수의 특성은 어떤 공간에서 더 작은 공간으로 값을 매핑시키는 것이기 때문에 여러 값이 동일한 공간에 매핑될 수 있다. 이 것을 우리는 collision이라 부르고 이 것을 처리하기 위한 전략을 갖는 것이 필수 적이다. 충돌을 해결 하기 위해선 다음과 같은 질문을 해 볼 수 있다.

1. 동일한 버킷에서 값을 어떻게 구성할 것인가?
2. 동일한 버킷에 너무 많은 값이 할당되면 어떻게 해야할까?
3. 특정 버킷에서 대상 값을 어떻게 검색 해야할까?

이러한 질문은 버킷의 개수 및 hash function에 따라 동일한 버킷에 매핑될 수 있는 키의 개수와 관련이 있다. 최대 N개의 키를 가지는 버킷이 있을 때,  일반적으로 N이 일정하고 작으면 배열을 사용하여 동일한 버킷에 키를 저장할 수 있다.  N이 가변적이거나 크면 `height-balanced binary search tree`(높이 균형 이진 탐색 트리)를 대신 사용해야 할 수도 있다. 실제 Java8 이후 HashMap에서 해시 버킷의 항목 수가 특정 임계값이 넘어가는 경우`height-balanced binary search`로 전환된다.  최악의 경우 O(n)에서 O(log n)으로 성능을 향상 시킬 수 있다. `IdentityHashMap`에서는 해시 코드를 생성하는데 `System.identityHashCode()`를 사용하므로 충돌이 거의 없다 그래서 여기서는 이 기술을 사용하지 않는다. 이 변경으로 인해 트리를 추가하고 관리하는데 약간의 오버헤드가 발생하지만 무시할 만한 수준이라고 한다. 



* 충돌을 해결하기 위한 전략
  * Separeate Chaining
    * 동일한 해시 키를 가진 값의 경우 버킷에 보관하며 각 버킷은 서로 독립적이다.
  * Open Addressing
    * 충돌이 있을 때마다 빈 슬롯을 찾을 때까지 특정 전략으로 메인 공간을 계속 탐색한다.
  * 2-Chice Hashing
    * 하나가 아닌 두 개의 해시 함수를 사용하고 충돌이 더 적은 주소를 선택한다.









# Design HashSet

### 요구 조건

아래와 같이 HashSet의 동작에 관련된 메소드를 설계한다.

* add(key) - key를 HashSet에 추가하는 역할을 한다. 이미 값이 있다면 저장하지 않는다.
* Contains(key) - key가 HashSet에 존재하는지 여부를 반환한다.
* remove(key) - key에 해당하는 값을 제거한다. 값이 없다면 아무 것도 하지 않는다.



## Approach 1:  LinkedList as Bucket

```java
class MyHashSet {
    private static final int BUCKET_SIZE = 769;
    private LinkedList<Integer>[] set;
    
    public MyHashSet() {
        set = new LinkedList[BUCKET_SIZE];
        LinkedList<Integer> test;      
    }
    
    public void add(int key) {
        int index = generateIndex(key);
        
        if(set[index] == null){
            set[index] = new LinkedList<Integer>();
        } 
       
        if(!(contains(key))) {// 버켓에 값이 없는 경우 저장한다.
            set[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = generateIndex(key);
        
        if(set[index] != null){
            for(int i = 0; i < set[index].size(); i++){
                int value = set[index].get(i);
                if(value == key){ // 버킷에 값이 있는 경우 삭제한다.
                    set[index].remove(i);
                    break;
                }        
            }
        }
    }
    
    public boolean contains(int key) {
        int index = generateIndex(key);
        
        if(set[index] == null){
            return false;
        }        
        return set[index].contains(key);
    }
    
    private int generateIndex(int key){
        return key % BUCKET_SIZE;
    }
}
```



배열의 크기가 n 일 때 , 배열을 버킷으로 사용하는 경우 중복을 피하기 위하여 배열을 스캔 해야 하므로 O(n)의 탐색 시간이 소요된다.  그리고 i 번째 요소를 삭제 해야한다면 i 번째 요소 이 후의 모든 요소를 한 위치 앞으로 이동 시켜야 한다. 즉, n-i번 이동해야 한다.  따라서 배열 목록에서 요소를 제거하는 시간 복잡도는 O(n)이된다. 삭제시간을 O(1) 로 시간복잡도를 줄일 수 있는 두 가지 솔루션이 있다. 

1.swap

제거하려는 요소를 버킷의 제일 마지막 요소와 바꾼다. 그런 다음 마지막 요소를 제거 할 수 있다.

2.Linked List

LinkedList를 사용하면 list의 순서를 수정하지 않고 O(1)만에 삭제가 가능하다.



### Time complexity

* N이 가능한 모든 수이고 , K가 769와 같은 사전에 정의된 버킷의 수일 때 값이 고르게 분포되어 있다고 가정하면 버킷의 평균 크기는 <img src="https://render.githubusercontent.com/render/math?math=\frac{N}{K}">이다. 각 작업에 대해 최악의 경우 전체 버킷을 스캔해야 하므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(\frac{N}{K})"> 이다.

### Space complexity

* K는 사전에 정의된 버킷의 수이고 M은 HashSet에 추가된 고유한 값들의 수라면 K만큼 M이 존재하므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(KsumM)"> 이다. 

### Link

* https://leetcode.com/problems/design-hashset/solution/



위의 접근 방식에서 단점 중 하나는 값이 버킷에 존재하는지 확인하기 위해 리스트 전체를 스캔해야 한다는 것이다.

# Design HashMap





# Contains Duplicate



### Approach 1 : HashMap

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> container = new HashMap<>();

            for(int num : nums) {
               	int value =  container.compute(num , new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                  		return container.getOrDefault(integer, 0) + 1;
                }
            }); 
              
            if(value > 1){
                return true;
            }
        }
        return false;
    }
}
```

