그리디 알고리즘은 만족하는 적합한 해를 찾는 방법이지 최적의 해를 찾는 방법은 아니다. 최적의 해를 찾기 위해서는 다이나믹 프로그래밍을 사용한다. 둘의 차이점은 다이나믹 프로그래밍은 하위 문제에 대한 최적의 솔루션을 찾은 다음에 이 결과들을 결합한 정보로 최적 솔루션에 대한 선택을 하고, 그리디는 각 단계마다 최적해를 찾는 문제로 접근해 문제를 좁혀 나가며 선택을 다시 고려하지 않는다.

 **그리디 문제인지 판단하는 방법은 단순히 가장 좋아 보이는 것을 반복적으로 선택해도 최적의 해를 구할 수 있는지 파악해야 한다.** 코딩 테스트에서는 어떠한 입력이 주어 젔을 때 어떠한 출력이 나와야 한다는 것을 미리 출제자가 정해놓고 문제를 만드는 경우가 대부분이라 그리디로 얻은 해가 문제의 결과가 말하는 최적의 해가 될 때 그리디로 풀 수 있다.



무게 대비 가치가 다른 물건들을 일정한 용량의 용기에 담아야 한다는 기본 틀에서 변형된 경우가 많다. 가방이 여러개 이거나 고려할 변수가 무게와 가치 이외 추가되는 경우도 많다. 동적 계획법을 사용하면 O(nW)만에 구할 수 있다.



# Knapsack

대표적인 그리디 알고리즘으로 조합 최적화 문제의 일종이다. 담을 수 있는 최대 무게가 정해진 배낭과 함께 각각의 무게와 가치가 주어진 아이템의 집합이 주어젔을 때, 배낭에 담은 아이템들의 가치의 합이 최대가 되도록 하는 아이템들의 부분집합을 찾는 문제이다.

![image-20220312165739197](/Users/yeonjeongchoi/Library/Application Support/typora-user-images/image-20220312165739197.png)

## 분할 가능한 배낭 문제(fractional knapsack problem)

도둑이 상자에 든 금괴를 훔쳐간다고 가정해보자. 도둑은 최대 15KG까지 담을 수 있고 각각의 상자의 무개는 위의 그림과 같을 때 도둑이 배낭에 담을 수 있는 최적의 조합은  C 4kg, B 1kg, E 2kg, D 1kg, **A 7kg**가 된다.  이런 형태의 문제를 분할 가능한 배낭 문제라고 한다. 

1. 각 항목의 가격/무게의 비율 즉 무게당 가치를 계산하고 이 가치 기준으로 정렬 한다.
2. 무게당 가장 가치가 높은 항목부터 가방에 담는다.
3. 담으려는 항목 무게에 비해 현재 가방 사이즈가 충분 하다면 모두 담는다.
4. 그렇지 않다면 항목을 나누어서 현재 가방에 담을 수 있는 용량 만큼만 담는다.

```java

```



### Maximum Units on a Truck

```java
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (unit1, unit2) -> unit2[1] - unit1[1]);
        
        int totalUnitCount = 0;
        for(int[] boxes : boxTypes) {
            
            int boxCount = boxes[0];
            int unitCount = boxes[1];
            
            int necessaryBoxCount = Math.min(truckSize, boxCount);
            totalUnitCount = totalUnitCount + unitCount * necessaryBoxCount;
            truckSize = truckSize - necessaryBoxCount;
        }
        
        return totalUnitCount;      
    }
}
```



###### Link

* https://leetcode.com/problems/maximum-units-on-a-truck/



### 0-1 배낭 문제(0-1 knapsack problem)

포함 여부만 결정할 수 있고 아이템은 나누어서 선택이 불가능 하다. 동적 계획법 또는 백트래킹의 조합 최적화 방법으로 풀어야 한다.