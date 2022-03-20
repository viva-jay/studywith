둘 이상의 테이블에서 주어진 컬럼을 기준으로 데이터를 결합하여 데이터를 생성한다. 



# INNER JOIN

ON절 조건에 해당하는 컬럼의 데이터가 조인에 참가하는 두 테이블에서 모두 존재하는 로우들만 새로운 논리적 테이블에 참여할 수 있다. FROM 또는 WHERE 절에 위치 가능하다.

![스크린샷 2022-03-06 오후 5.55.55](/Users/yeonjeongchoi/Desktop/스크린샷 2022-03-06 오후 5.55.55.png)

```SQL
SELECT <열 목록>
FROM <첫 번째 테이블>
    INNER JOIN <두 번째 테이블>
    ON <조인조건>
[WHERE 검색 조건]
```





# Combine Two Tables

### Problem

```SQL
# Table : Person
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| personId<PK>| int     |
| lastName    | varchar |
| firstName   | varchar |
+-------------+---------+

# Table : Address
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| addressId<PK>| int     |
| personId     | int     |
| city         | varchar |
| state        | varchar |
+--------------+---------+
```

위와 같은 테이블이 존재 할 때 Person 테이블에 있는 각각 사람에 대해 이름과 주소를 포함하는 SQL을 작성한다. 해당하는 주소 데이터가 없는 경우 `null`로 표시한다.

### Solution

Address 테이블의 persionId는 Person의 외래키 이므로 두 테이블을 결합하여 주소 데이터를 가져올 수 있다. 모든 사람에 대한 주소 데이터가 없을 수도 있으므로 INNER JOIN 대신 OUTER JOIN을 사용해야 한다.

```SQL
SELECT 
	P.firstname,
	P.lastname,
	A.city,
	A.state
FROM Person AS P
  LEFT JOIN Address AS A
  ON P.personID = A.personID;
```

아래와 같이 NATURAL LEFT JOIN을 사용하는 편이 속도 면에서 좀 더 효율적으로 계산된다.

```sql
SELECT firstName, lastName, city, state
FROM Person 
	NATURAL LEFT JOIN Address;
```

### Link

* https://leetcode.com/problems/combine-two-tables/





# Employee Bonus

### Problem

```SQL
# Table : Employee
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| empId       | int     |
| name        | varchar |
| supervisor  | int     |
| salary      | int     |
+-------------+---------+

# Table : Bonus
+-------------+------+
| Column Name | Type |
+-------------+------+
| empId       | int  |
| bonus       | int  |
+-------------+------+
```

1000 보다 작은 보너스를 가진 직원의 이름과 보너스를 보고하는  SQL 쿼리를 작성한다. 이때 보너스가 없는 직원의 정보도 표시가 되어야 한다.

### Solution

일부 직원은 보너스 레코드가 없기 때문에 OUTER JOIN을 사용한다. 개념적으로 NULL은 `알 수 없는 값이 누락됨` 을 의미하며 다른 값과 다소 다르게 취급 된다.  NULL은 비교가 가능한 숫자 또는 문자열이 아니기 때문에  =,<과 같은 비교연산자를 사용할 수 없으며 WHERE절에서 비교연산자를 사용하면 NULL 값은 제외된다. NULL 값을 포함시키려면 ` IS NULL` 또는` IS NOT NULL`을 사용해야 한다.

```Sql
SELECT 
		E.name, 
		B.bonus
FROM Employee AS E 
    LEFT JOIN Bonus AS B
    ON E.empId = B.empId
WHERE bonus < 1000 OR bonus IS NULL;
```



### Link

* https://leetcode.com/problems/employee-bonus/