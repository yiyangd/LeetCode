SELECT Score,
       dense_rank() OVER(ORDER BY Score DESC) AS `Rank`
FROM Scores;
########################################################

SELECT S1.Score, COUNT(S2.Score) AS `Rank` 
FROM Scores S1, (SELECT DISTINCT Score FROM Scores) S2
WHERE S2.Score >= S1.Score  
GROUP BY S1.Id 
ORDER BY S1.Score DESC;
