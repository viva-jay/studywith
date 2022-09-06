# SELECT (UNION)

## UNION
### 문제 : [1965. Employees With Missing Information](https://leetcode.com/problems/employees-with-missing-information/)
**문제 풀이**
- MySQL, MS SQL Server, Oracle 풀이
```roomsql
SELECT employee_id
  FROM Employees
 WHERE employee_id NOT IN (SELECT employee_id FROM Salaries)
 UNION
SELECT employee_id
  FROM Salaries
 WHERE employee_id NOT IN (SELECT employee_id FROM Employees)
 ORDER BY employee_id;
```