/*
070.Climbing Stairs
> Each time you can either climb `1 or 2` steps. In how many distinct ways can you climb to the top i `n` steps)? 
> - 1 <= n <= 45
```
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

//Solution 1 - Top-down DP with Memoization 
public int climbStairs(int n) {
    int[] dp = new int[n+1];
    return memo(dp, n);
}
public int memo(int[] dp, int n) {
    if (n <= 2) return n; // base case
    if (dp[n] == 0) // store the first-solved sub-problem
        dp[n] = memo(dp, n-1) + memo(dp, n-2);
    return dp[n]; // return the stored solution
}
/*
Time Complexity: O(n)

Space Complexity: O(n) for recursion stack
*/

//Solution 2 - Bottom-up DP with Tabulation
public int climbStairs(int n) {
    int[] dp = new int[n+2]; // avoid out of bound if n = 1
    dp[1] = 1; dp[2] = 2;
    for (int i = 3; i <= n; i++) 
        dp[i] = dp[i-1]+dp[i-2];
    return dp[n];
}
/*
Time Complexity: O(n)

Space Complexity: O(n) for `dp[]`
*/
