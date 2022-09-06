# SELECT (JOIN 문)

## LEFT JOIN
### 문제 : [175. Combine Two Tables](https://leetcode.com/problems/combine-two-tables/)
**문제 풀이**
- MySQL, MS SQL Server, Oracle 풀이
```roomsql
SELECT A.firstName
     , A.lastName
     , B.city
     , B.state
  FROM Person A LEFT JOIN Address B
    ON A.personId = B.personId;
```