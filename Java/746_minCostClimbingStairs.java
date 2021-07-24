/*
746. Min Cost Climbing Stairs
> You are given an integer array `cost` where `cost[i]` is the cost of `ith` step on a staircase. Once you pay the cost, you can either climb one or two steps.
> - You can either start from the step with index 0, or the step with index 1.
> - Return the minimum cost to reach the top of the floor.

```
Input: cost = [(1),100,(1),1,(1),100,(1),(1),100,(1)] -> top of the floor
Output: 6
Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
```
*/

//Solution 1 - Top-down DP with Memoization 
public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    return memo(dp, cost, cost.length);
}
public int memo(int[] dp, int[] cost, int n) {
    if (n <= 1) return 0;
    if (dp[n] == 0) 
        dp[n] = Math.min(cost[n-1] + memo(dp,cost,n-1),
                        cost[n-2] + memo(dp,cost,n-2));
    return dp[n];
}
/*
Time Complexity: O(n)
Space Complexity: O(n) for recursion stack
*/

//Solution 2 - Bottom-up DP with Tabulation
public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    // dp[0] = dp[1] = 0; // 0 is default when init Java array
    for (int i = 2; i <= cost.length; i++) 
        dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
    return dp[cost.length]; 
    // dp[i] stores the minCost to reach cost[i] or top
}
/*
Time Complexity: O(n)
Space Complexity: O(n) for `dp[]`
*/
