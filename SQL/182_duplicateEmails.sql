# Person (Id int, Email varchar(255))
SELECT Email
FROM Person
GROUP BY Email
HAVING count(Email) > 1;
