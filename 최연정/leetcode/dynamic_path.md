출발지 부터 목적지 까지 가는 방법의 수를 구하는 문제가 주로 출제된다. 되돌아 갈 수 없다 또는 이동 방향이 왼쪽 또는 아래이다. 유니크한 최단 경로의 수를 구하라 같은 키워드가 언급된다. 

### Maximum Path Sum

왼쪽 최상단에서 오른쪽 최하단 까지 가는 최소 비용을 구하는 문제이다. 매트릭스 안에 쓰여진 값은 그 길을 지나가는데 필요한 비용이다. 그리고 이동은 왼쪽 또는 오른쪽으로만 이동 가능 하다.

이 문제를 sub problem으로 나누어서 생각해 보면 초록색 네모 부분과 파란색 네모 부분으로 나눌 수 있고 각각의 도착지 인 파란색 동그라미 까지 도달하는 최소 비용과 초록색 동그라미 까지 도달하는 최소비용 중 최소값을 구해서 코스트를 더해주면  전체에 대한 최소 비용을 구할 수 있다.

![image](https://user-images.githubusercontent.com/37570093/169700394-263f6a69-cf5b-4c3a-a42f-4df4a2065e36.png)

각 셀에 도달하는 최소비용을 계산하여 초기화 해둔 메트릭스를 이용하면 쉽게 활용 할 수 있지만 추가적인 2차원 배열이 필요하다. 공간 복잡도를 줄이기 위해 주어진 매트릭스를 사용할 수 있다.

```java
class Solution {
    public int minPathSum(int[][] grid) {    
        int row = grid.length;
        int column = grid[0].length;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {       
                int minCost = findMinimumCost(grid, i, j);
                grid[i][j] = minCost + grid[i][j];
         
            }
        }      
        return grid[row-1][column-1];  
    }
    
    public int findMinimumCost(int[][] grid, int i, int j){
        if(i == 0 && j == 0) {
            return 0;
        }
        
        if(i == 0) {
            return grid[i][j-1];
        }
        
        if(j == 0) {
            return grid[i-1][j];
        }
        return Math.min(grid[i][j-1], grid[i-1][j]);
    }    
    
```

###### Time complexity

* 전체 배열을 1번 순회 하므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(n*m)"> 이다.

###### Space complexity

* N개의 요소를 저장할 별도의 배열 필요하지 않으므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(1)"> 이다.

###### Link

* https://leetcode.com/problems/minimum-path-sum/



### Unique Paths II

로봇은 오른쪽 또는 왼쪽으로만 움직일 수 있으므로 첫 번째 행과 열은 각 셀에 도달할 수 있는 방법은 1이다. 만약 장애물이 존재한다면 그 셀을 거쳐서 갈 수 있는 방법은 없으므로 장애물에서 왼쪽으로 가는 방법과 아래로 가는 방법은 각 1이 된다.

나머지 셀들은 왼쪽으로 부터 오는 방법의 수와 위에서 오는 방법의 수의 합으로 볼 수 있다. 문제에 따라 다르지만 현재 문제 처럼 출발지와 목적이에 장애물이 위치 할 수 있는 경우  예외 상황을 잘 체크 해야한다. 장애물 표시를 1로 주는 상황과 (0,0)셀이 1로 초기화 되어야 하는 조건에서 예외가 발생 할 수 있다.

프로그래머스 문제 처럼 내가 직접 장애물 위치를 표시할 수 있는 경우 1이아닌 -1 같은 숫자로 대체하면 위의 문제를 해결 할 수 있다.

```java
class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                 if(obstacleGrid[i][j] == 1) { // 장애물인 경우 처리
                      obstacleGrid[i][j] = 0;
                  }else if(i == 0 && j == 0) { // 첫번째 셀에 도달할 수 있는 방법 수는 1
                     obstacleGrid[i][j] = 1;
                  }
                    else {
                      if(i != 0) {
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                      }
                      if(j != 0) {
                        obstacleGrid[i][j] += obstacleGrid[i][j-1];
                      }                    
                  }
            }
        }
        
        return obstacleGrid[m - 1][n - 1];       
    } 
}
```



* 장애 물이 있지만 장애물을 내가 표시할 수 있는 경우 (https://programmers.co.kr/learn/courses/30/lessons/42898)
  * 이 문제의 예외상황은 열, 행 순으로 장애물 위치를 표시하는 것이다. 문제 설명에서 계속 열, 행 순으로 설명을 하고 있는데 이를 캐치해서 생각해야 한다. (쓸 때 없이 햇갈리게 해놓은 문제)
  * 이 문제에서는 출발지와 목적지에 장애물이 놓일 수 없다.

```java
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] grid = new int[n][m];
        
        for (int i = 0; i < puddles.length; i++) { // 장애물 위치 표시
            int row = puddles[i][1] - 1; // 열 행 순으로 데이터를 준다
            int col = puddles[i][0] - 1;
            grid[row][col] = -1;
        }
      
        grid[0][0] = 1; // 장애물을 -1로 초기화 시켰기 때문에 이렇게 첫번째 값을 초기화 할 수 있다.
      
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == -1){
                    grid[i][j] = 0;
                    continue;
                }
                    
                if(i != 0) {
                    grid[i][j]= (grid[i][j] + (grid[i-1][j] % 1000000007)) % 1000000007;
                }
                if(j != 0) {
                    grid[i][j]= (grid[i][j] + (grid[i][j-1] % 1000000007)) % 1000000007;
                }
            
            }
        }
        return grid[n-1][m-1];
    }
}  
    
```

###### Time complexity

* 전체 배열을 1번 순회 하므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(n*m)"> 이다.

###### Space complexity

* N개의 요소를 저장할 별도의 배열 필요하지 않으므로  complexity는 <img src="https://render.githubusercontent.com/render/math?math=O(1)"> 이다.

###### Link

* https://leetcode.com/problems/unique-paths-ii/



