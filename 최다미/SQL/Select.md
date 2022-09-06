# SELECT

## 테이블 재구성
### 문제 : [1179. Reformat Department Table](https://leetcode.com/problems/reformat-department-table/)
**문제 풀이**
- MySQL 풀이
``` roomsql
SELECT id, 
       SUM(IF(month = "Jan", revenue, null)) as Jan_Revenue,
       SUM(IF(month = "Feb", revenue, null)) as Feb_Revenue,
       SUM(IF(month = "Mar", revenue, null)) as Mar_Revenue,
       SUM(IF(month = "Apr", revenue, null)) as Apr_Revenue,
       SUM(IF(month = "May", revenue, null)) as May_Revenue,
       SUM(IF(month = "Jun", revenue, null)) as Jun_Revenue,
       SUM(IF(month = "Jul", revenue, null)) as Jul_Revenue,
       SUM(IF(month = "Aug", revenue, null)) as Aug_Revenue,
       SUM(IF(month = "Sep", revenue, null)) as Sep_Revenue,
       SUM(IF(month = "Oct", revenue, null)) as Oct_Revenue,
       SUM(IF(month = "Nov", revenue, null)) as Nov_Revenue,
       SUM(IF(month = "Dec", revenue, null)) as Dec_Revenue
  FROM Department
 GROUP BY id;
```

- MS SQL Server, Oracle 풀이
```roomsql
SELECT id,
       SUM(CASE WHEN month = 'Jan' THEN revenue ELSE null END) as Jan_Revenue,
       SUM(CASE WHEN month = 'Feb' THEN revenue ELSE null END) as Feb_Revenue,
       SUM(CASE WHEN month = 'Mar' THEN revenue ELSE null END) as Mar_Revenue,
       SUM(CASE WHEN month = 'Apr' THEN revenue ELSE null END) as Apr_Revenue,
       SUM(CASE WHEN month = 'May' THEN revenue ELSE null END) as May_Revenue,
       SUM(CASE WHEN month = 'Jun' THEN revenue ELSE null END) as Jun_Revenue,
       SUM(CASE WHEN month = 'Jul' THEN revenue ELSE null END) as Jul_Revenue,
       SUM(CASE WHEN month = 'Aug' THEN revenue ELSE null END) as Aug_Revenue,
       SUM(CASE WHEN month = 'Sep' THEN revenue ELSE null END) as Sep_Revenue,
       SUM(CASE WHEN month = 'Oct' THEN revenue ELSE null END) as Oct_Revenue,
       SUM(CASE WHEN month = 'Nov' THEN revenue ELSE null END) as Nov_Revenue,
       SUM(CASE WHEN month = 'Dec' THEN revenue ELSE null END) as Dec_Revenue
  FROM Department
 GROUP BY id;
```

## 조건 조회
### 문제 : [1757. Recyclable and Low Fat Products](https://leetcode.com/problems/recyclable-and-low-fat-products/)
**문제 풀이**
- MySQL, MS SQL Server, Oracle 풀이
```roomsql
SELECT product_id
  FROM Products
 WHERE low_fats = 'Y' AND recyclable = 'Y';
```

## GROUP BY
### 문제 : [1693. Daily Leads and Partners](https://leetcode.com/problems/daily-leads-and-partners/)
**문제 풀이**
- MySQL, MS SQL Server 풀이
```roomsql
SELECT date_id
     , make_name
     , COUNT(DISTINCT lead_id) AS unique_leads
     , COUNT(DISTINCT partner_id) AS unique_partners
  FROM DailySales
 GROUP BY date_id, make_name;
```

- Oracle 풀이
```roomsql
SELECT TO_CHAR(date_id, 'YYYY-MM-DD') AS date_id
     , make_name
     , COUNT(DISTINCT lead_id) AS unique_leads
     , COUNT(DISTINCT partner_id) AS unique_partners
  FROM DailySales
 GROUP BY date_id, make_name;
```