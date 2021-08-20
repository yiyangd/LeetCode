# `JOIN` and `ON` could be `,` and `WHERE`
# Employee (Id int, Name varchar(255), Salary int, ManagerId int)
SELECT e1.NAME AS Employee
FROM Employee e1 JOIN Employee e2
ON e1.ManagerId = e2.Id
AND e1.Salary > e2.Salary
