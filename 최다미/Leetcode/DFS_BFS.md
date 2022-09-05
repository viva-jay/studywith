# 그래프 탐색 알고리즘 : DFS/BFS

탐색(Search)이란 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정을 말한다.
대표적인 그래프 탐색 알고리즘으로는 DFS와 BFS가 있다.

## 학습 전 선행 되어야 할 자료구조
- [Stack (스택)](Stack.md)
  - 먼저 들어 온 데이터가 나중에 나가는 형식(선입후출)의 자료구조이다.
  - 입구와 출구가 동일한 형태로 스택을 시각화할 수 있다.
  - [!Stack](https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Data_stack.svg/1920px-Data_stack.svg.png)

- [Queue (큐)](Queue.md)
  - 먼저 들어온 데이터가 먼저 나가는 형식(선입선출)의 자료구조이다.
  - 큐는 입구와 출구가 모두 뚫려 있는 터널과 같은 형태로 시각화할 수 있다.
  - [!Queue](https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Data_Queue.svg/1920px-Data_Queue.svg.png)


## DFS (Depth-First Search)
- DFS는 **깊이 우선 탐색**이라고도 부르며 그래프에서 **깊은 부분을 우선적으로 탐색**하는 알고리즘이다.
- DFS는 스택 자료구조(혹은 재귀함수)를 이용하며, 구체적인 동작 과정은 다음과 같다.
  1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
  2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면 그 노드를 스택에 넣고 방문 처리한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
  3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복한다.

## BFS(Breadth-First Search)
- BFS는 **너비 우선 탐색**이라고도 부르며, 그래프에서 **가까운 노드부터 우선적으로 탐색**하는 알고리즘이다.
- BFS는 큐 자료구조를 이용하며, 구체적인 동작 과정은 다음과 같다.
  1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
  2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리한다.
  3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복한다.

## DFS 문제
### 문제 : [938. Range Sum of BST](https://leetcode.com/problems/range-sum-of-bst/)
**문제 풀이**
- 시간 복잡도 : 시간 복잡도는 O(n) 이다. 여기서 n은 총 노드의 수이다.
- 공간 복잡도 : 공간 복잡도는 O(h) 이다. 여기서 h는 트리의 높이이다.
- 재귀 함수를 이용한 풀이
  ```java
  class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
      if (root == null) {
          return 0;
      }
      
      int sum = 0;
      // 범주 안에 속해 있으면 노드 더하기
      if (low <= root.val && root.val <= high) {
          sum += root.val;
      }
      
      sum += rangeSumBST(root.left, low, high);    // 노드의 왼쪽 탐색
      sum += rangeSumBST(root.right, low, high);    // 노드의 오른쪽 탐색
      return sum;
    }
  }
  ```
  
## BFS 문제
### 문제 : [617. Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/)
**문제 풀이**
- 시간 복잡도 : 시간 복잡도는 O(n) 이다. 여기서 n은 총 노드의 수이다.
- 공간 복잡도 : 공간 복잡도는 O(h) 이다. 여기서 h는 트리의 높이이다.
- 재귀 함수를 이용한 풀이
```java
public class Solution {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		} else if (root1 == null) {
			return root2;
		} else if (root2 == null) {
			return root1;
		}

		TreeNode result = new TreeNode(root1.val + root2.val);
		result.left = mergeTrees(root1.left, root2.left);
		result.right = mergeTrees(root1.right, root2.right);
		return result;
	}
}
```
