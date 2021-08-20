# Customers (Id int, Name varchar(255))
# Orders (Id int, CustomerId int)
SELECT Customers.Name AS Customers
FROM Customers
WHERE Customers.Id NOT IN (SELECT Customerid FROM Orders);

SELECT Customers.Name as Customers
FROM Customers 
LEFT JOIN Orders
ON Customers.Id=Orders.CustomerId
WHERE Orders.CustomerId IS NULL;
