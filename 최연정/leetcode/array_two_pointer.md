배열 또는 리스트에서 두 개의 포인터를 이용하는 알고리즘이다. 문제의 조건이 연속 또는 선행적으로 무언가를 해야 할 때 사용한다.  다음 그림은 two pointers 유형의 핵심 아이디어를 간략하게 보여준다.

![image-20220102193041064](/Users/yeonjeongchoi/Library/Application Support/typora-user-images/image-20220102193041064.png)



## Squares of a Sorted Array

오름차순으로 정렬된 배열이 주어지면 각 요소들의 **square**를 구하여 오름차순으로 정렬된 배열을 반환하는 문제이다. 음수가 포함되어 있기 때문에 각 요소의 **square**를 구하면 음수 부분은 내림차순으로 정렬되고 양수 부분은 오름차순으로 정렬되는 성질과 두 개의 포인터를 이용하여 time complexity를 줄인다.

```java
public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int[] result = new int[length];
        
        for(int index = length - 1; index >= 0; index--){ //결과 배열을 역순으로 채워야 오름차순 배열을 얻을 수 있다.
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if(leftSquare < rightSquare){ //오른쪽 요소가 더 크면
                result[index] = rightSquare; //결과 배열에 요소를 넣고
                right--; // 포인터를 줄인다
            }else{
                result[index] = leftSquare;
                left++;
            }
        }
        return result;
}
```

### Time complexity

* N개의 요소에 대해 <img src="https://render.githubusercontent.com/render/math?math=O(1)">연산을 하므로 complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(n)"> 이다.

### Space complexity

* N개의 요소를 저장할 별도의 배열 필요하므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(n)"> 이다.

### Link

* https://leetcode.com/problems/squares-of-a-sorted-array/



## Duplicate Zero

추가 공간을 활용하지 못하기 때문에 배열을 덮어써야 한다.  배열의 끝에서 버려질 수를 알 수 있으면 나머지 숫자들을 그 만큼 이동시키면 된다.  추가되는 0의 수를 카운트 하면 삭제되는 요소의 개수를 알수 있다.

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        int size = arr.length - 1;
        for(int index = 0; index < arr.length; index++){
            if(arr[index] == 0){
                zeroCount++; //0을 찾는다.
            }
        }  
        
        for(int index = size; index >= 0; index--){
            int newIndex = index + zeroCount; //요소를 0의 개수만큼 시프트 시킨다.
            
            if(arr[index] == 0){ //현재 요소가 0인경우 처리해야할 작업
                if(newIndex <= size){
                    arr[newIndex] = 0;
                }
                zeroCount--;
                newIndex--;
            }
            
            if(newIndex <= size){
                arr[newIndex] = arr[index]; //요소들을 새로운 인덱스로 옮긴다.
            }
        }
    }
}
```

### Time complexity

* N개의 요소에 대해  0의 개수를 찾는 작업과 요소를 복사하는 두 번의 실행을 한다. complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(n)"> 이다.

### Space complexity

* 추가적인 배열이 필요하지 않으므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(1)"> 이다.

### Link

* https://leetcode.com/problems/duplicate-zeros/





## Find First Palindromic String in the Array

앞뒤로 대칭인 문자열 중 첫 번째 문자열을 반환하는 문제 이다. 두 개의 포인터를 이용하여 문자열 앞뒤를 비교하면서 찾는다.

```java
class Solution {
    public String firstPalindrome(String[] words) {
        for(String word : words) {
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }
    
    public boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            int length = word.length() - 1;
           
            if (word.charAt(i) != word.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }
}
```

### Time complexity

* N개의 문자열에 대하여 각 문자열 길이 W의 연산을 하므로 complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(n * w)"> 이다.

### Space complexity

* 추가적인 배열이 필요하지 않으므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(1)"> 이다.

### Link

* https://leetcode.com/problems/find-first-palindromic-string-in-the-array/







## Valid Palindrome

입력 문자열의 양쪽 끝에서 안쪽으로 탐색을 시작하여 같은 문자가 있는지 확인 한다. 문자열에는 영문자나 숫자가 아닌 문자들이 포함되어 있는데 미리 정규화 하는데에 따른 시간도 소요되므로 순회를 하면서 판단한다.

```java
class Solution {
    public boolean isPalindrome(String s) {
        return isPalindromes(s);
    }
    
    public boolean isPalindromes(String word) {
        for(int left = 0, right = word.length() - 1;
        left < right; left++, right--){
            while(left < right && !Character.isLetterOrDigit(word.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(word.charAt(right))){
                right--;
            }
            
            if(Character.toLowerCase(word.charAt(left)) != Character.toLowerCase(word.charAt(right))){
                return false;
            }
        }
        return true;
    }
}
```

### Time complexity

* N개의 문자열에 대하여 두 포인터가 중간에서 만나거나 중단 할 때까지 최대 한번 순회하므로 <img src="https://render.githubusercontent.com/render/math?math=O(n)"> 이다.

### Space complexity

* 추가적인 배열이 필요하지 않으므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(1)"> 이다.

### Link

* https://leetcode.com/problems/valid-palindrome/
