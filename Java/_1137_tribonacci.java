/*
1137. N-th Tribonacci Number
> The Tribonacci sequence T(n) is defined as follows: 
> - T(0) = 0, T(1) = 1, T(2) = 1, and T(n) = T(n-1) + T(n-2) + T(n-3) for n >= 3.
> - Given n, 0 <= n <= 37, return  T(n).
*/

//Solution 1 - Top-down DP with Memoization
public int tribonacci(int n) {
    int[] dp = new int[n+3]; // to avoid out of bound when n = 0 or 1
    dp[0] = 0; dp[1] = 1; dp[2] = 1;
    return memo(dp,n);
}
public int memo(int[] dp, int n) {
    if (n>=3 && dp[n] == 0) // not stored in dp
        dp[n] = memo(dp,n-1) + memo(dp,n-2) + memo(dp,n-3);
    return dp[n]; // elseif (n < 3 || dp[n] > 0)
}
/*
Time Complexity: O(n)
- Each number up to n is visited, computed and stored and accessed for O(1)

Space Complexity: O(n) for recursion stack
*/

//Solution 2 - Bottom-up DP with Tabulation
public int tribonacci(int n) {
    //if (n < 3) return (n==0)? 0 : 1;
    int[] dp = new int[n+3]; // to avoid out of bound when n = 0 or 1
    dp[0] = 0; dp[1] = 1; dp[2] = 1;
    for (int i = 3; i <= n; i++)
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    return dp[n];
}
/*
Time Complexity: O(n)
- Each number up to n is visited, computed and stored and accessed for O(1)

Space Complexity: O(n) for `dp[]`
*/
