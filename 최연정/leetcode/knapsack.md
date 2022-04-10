## 풀이법의 결정

그리디 알고리즘은 만족하는 적합한 해를 찾는 방법이지 최적의 해를 찾는 방법은 아니다. 최적의 해를 찾기 위해서는 다이나믹 프로그래밍을 사용한다. 둘의 차이점은 다이나믹 프로그래밍은 하위 문제에 대한 최적의 솔루션을 찾은 다음에 이 결과들을 결합한 정보로 최적 솔루션에 대한 선택을 하고, 그리디는 각 단계마다 최적해를 찾는 문제로 접근해 문제를 좁혀 나가며 선택을 다시 고려하지 않는다.

 **그리디 문제인지 판단하는 방법은 단순히 가장 좋아 보이는 것을 반복적으로 선택해도 최적의 해를 구할 수 있는지 파악해야 한다.** 코딩 테스트에서는 어떠한 입력이 주어 젔을 때 어떠한 출력이 나와야 한다는 것을 미리 출제자가 정해놓고 문제를 만드는 경우가 대부분이라 그리디로 얻은 해가 문제의 결과가 말하는 최적의 해가 될 때 그리디로 풀 수 있다.

무게 대비 가치가 다른 물건들을 일정한 용량의 용기에 담아야 한다는 기본 틀에서 변형된 경우가 많다. 가방이 여러 개 이거나 고려할 변수가 무게와 가치 이외 추가되는 경우도 많다. 동적 계획법을 사용하면 O(nw)만에 구할 수 있다.



# Knapsack

대표적인 그리디 알고리즘으로 조합 최적화 문제의 일종이다. 담을 수 있는 최대 무게가 정해진 배낭과 함께 각각의 무게와 가치가 주어진 아이템의 집합이 주어젔을 때, 배낭에 담은 아이템들의 가치의 합이 최대가 되도록 하는 아이템들의 부분집합을 찾는 문제이다.

![image-20220312165739197](https://user-images.githubusercontent.com/37570093/159168899-4f192e4f-d4e7-4976-9ead-01c37623e39e.png)

## 분할 가능한 배낭 문제(fractional knapsack problem)

도둑이 상자에 든 금괴를 훔쳐간다고 가정해보자. 도둑은 최대 15KG까지 담을 수 있고 각각의 상자의 무개는 위의 그림과 같을 때 도둑이 배낭에 담을 수 있는 최적의 조합은  C 4kg, B 1kg, E 2kg, D 1kg, **A 7kg**가 된다.  이런 형태의 문제를 분할 가능한 배낭 문제라고 한다. 

1. 각 항목의 가격/무게의 비율 즉 무게당 가치를 계산하고 이 가치 기준으로 정렬 한다.
2. 무게당 가장 가치가 높은 항목부터 가방에 담는다.
3. 담으려는 항목 무게에 비해 현재 가방 사이즈가 충분 하다면 모두 담는다.
4. 그렇지 않다면 항목을 나누어서 현재 가방에 담을 수 있는 용량 만큼만 담는다.



### Maximum Units on a Truck

Unit이 담긴 박스를 트럭이 수용가능한 만큼 만 실을 수 있다. 이 때 Unit의 개수는 최대 몇 개가 될 수 있는지 구하는 문제이다. 

Brute Force로 해결 한다면 매 순간 남은 박스를 순회 하면서 유닛이 가장 많이 담긴 박스를 찾아 채운다. 이 때 박스 개수는 트럭이 수용 가능한 개수 만큼 채워야 한다. 그리디 알고리즘을 사용한다면 정렬을 사용하여 최대 Unit을 찾기 위해 매 순간 반복하는 것을 하지 않아도 된다. Unit이 많은 순서대로 상자를 정렬하고 순서대로 트럭에 실으면 된다.

```java
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (unit1, unit2) -> unit2[1] - unit1[1]); // Unit이 많은 순서대로 정렬한다.
        
        int totalUnitCount = 0;
        for(int[] boxes : boxTypes) {
            int boxCount = boxes[0];
            int unitCount = boxes[1];
            
            int necessaryBoxCount = Math.min(truckSize, boxCount); // 박스가 더 많으면 트럭 개수만큼만 싣게 해주는 효과
            totalUnitCount = totalUnitCount + unitCount * necessaryBoxCount;
            truckSize = truckSize - necessaryBoxCount;
        }
        
        return totalUnitCount;      
    }
}
```

###### Time complexity

* N개의 요소를 정렬하는데 <img src="https://render.githubusercontent.com/render/math?math=O(nlogn)">연산을 하므로 complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(nlogn)"> 이다.

###### Space complexity

* N개의 요소를 저장할 별도의 배열 필요하지 않으므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(1)"> 이다.

###### Link

* https://leetcode.com/problems/maximum-units-on-a-truck/





## 0-1 배낭 문제(0-1 knapsack problem)

포함 여부만 결정할 수 있고 아이템은 나누어서 선택이 불가능 하다. 동적 계획법 또는 백트래킹의 조합 최적화 방법으로 풀어야 한다.

1. 큰 문제를 작은 부분 문제로 나누어서 해결 할 수  있다.
2. 작은 부분 문제로 큰 문제의 해를 구할 수 있다.
3. 중복되는 부분 문제 들이 존재한다.(* 중요한 조건 , memorization으로 계산을 줄일 수 있기 때문)





### Coin change

가장 적은 수의 동전으로 교환 해 줄 때 몇 개의 동전을 주어야 하는지 구하는 문제이다. 대표적인 DP 문제 이지만 동전들이 더 작은 동전의 배수로 주어지는 경우 그리디로 풀이가 가능하다. Ex. 1,5,10, 50, 100, 500



![image](https://user-images.githubusercontent.com/37570093/162606769-0dbe6fe2-7547-4271-8f8d-1805f7e8c3f2.png)



주어진 동전이 1원 2원 5원이 있고 n원 만큼 교환해 주어야 한다면 n원이 되기전 동전의 상태는 n-1, n-2, n-5일 것이고 여기 까지 거슬러 준 최소 개수를 구할 수 있으면 1을 더해서 최종적인 동전의 최소 개수를 알 수 있다.

```java
public int coinChange(int[] coins, int amount) {

    int[] memory = new int[amount + 1];
    Arrays.fill(memory, 1, amount + 1, amount + 1); 
    //memory[i]에 값을 저장 후 최소값을 계속 비교해야하므로 amount 보다 큰 값으로 초기화
  	//0원은 0
      
    for(int currentAmount = 1; currentAmount < memory.length; currentAmount++) {
        for(int coin : coins) {
            if(coin <= currentAmount) {
                memory[currentAmount] = Math.min(memory[currentAmount], memory[currentAmount - coin] + 1);
            }
        }
    }
  
    if(memory[amount] == amount + 1) { // 동전으로 거슬러 줄 수 있는 방법이 없었기 때문에 값이 초기값이 변하지 않음
        return -1;
    }
    return memory[amount];
}    
```

###### Time complexity

* 각 스텝 마다 동전 개수 만큼 연산 해야 하므로 동전 개수가 M이라고 하면  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(N*M)"> 이다.

###### Space complexity

* N개의 각 요소에 대해 최소 동전 개수를 저장할 배열이 따로 필요하므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(N)"> 이다.

###### Link

* https://leetcode.com/problems/coin-change/
