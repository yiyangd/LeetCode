# Employee (Id int, Name varchar(255), Salary int, DepartmentId int)
# Department (Id int, Name varchar(255))
# `Employee` cannot find the empty `Department` when using `LEFT JOIN`
SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM Employee JOIN Department 
ON Employee.DepartmentId = Department.Id
WHERE (Employee.DepartmentId , Salary) IN
    (   SELECT DepartmentId, MAX(Salary)
        FROM Employee
        GROUP BY DepartmentId
    )
;
