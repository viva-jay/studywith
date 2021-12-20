### Brute force

**Time complexity**

* 결과가 nums[n-2] + nums[n-1]경우를 생각해보면 최대 $n(n-1)/2$ 번의 검사를 해야하므로 complexity는 $O(n^2)$ 이다.  참고로 결과가 nums[0] + nums[1]인 경우는 $Ω(1)$ 이다.

**Space complexity**

* 다른 배열에 복사 하는 과정이 없이 이미 주어진 배열을 사용하므로 complexity는 $O(1)$ 이다.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        for(int out = 0; out < nums.length - 1; out++){
            for(int inner = out + 1; inner < nums.length; inner++){
                int sum = nums[out] + nums[inner];
                if(sum == target){
                   return new int[] {out, inner};
                }
            }
        }
        
        return null;
    }
}
```



### Hashing

**Time complexity**

* 해시 테이블을 이용하면 N개의 요소에 대해 $O(1)$ 의 탐색을 하므로 complexity는 $O(n)$ 이다.

**Space complexity**

* N개의 요소를 저장할 해시 테이블이 필요하므로  complexity는 $O(N)$ 이다.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        
        for(int index = 0; index < length; index++){
            map.put(nums[index], index);
        }
        
        for(int index = 0; index < length; index++){
            int value = target - nums[index];
            if(map.containsKey(value) && map.get(value) != index){
                return new int[]{index, map.get(value)};
            }
        }
        
        return null;
    }
}
```



### Memorization

* 초기화를 미리 하지 않고 요소를 탐색하면서 캐싱하는 방법이다.  해시테이블을 초기화 하는 시간을 가지지 않기 때문에 조금 더 빠른 실행 시간을 보이지만 **complexity**면에선 이론상으로 같다.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
       
        for(int index = 0; index < length; index++){
            int value = target - nums[index];
            if(map.containsKey(value)){
                return new int[]{map.get(value), index};
            }
             map.put(nums[index], index);
        }
        
        return null;
    }
}
```

