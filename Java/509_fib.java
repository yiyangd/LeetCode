/*
509. Fibonacci Number
> F(n) denotes a sequence, F(0) = 0, F(1) = 1, F(n) = F(n - 1) + F(n - 2), for n > 1.
> - Given n, return F(n) 
*/

//Solution 1 - Non-DP Recursion
public int fib(int n) {
    if (n < 2) return n;
    return fib(n-1) + fib(n-2);
}
/*
Time Complexity: $O(2^n)$
- The amount of operations needed, for each level of recursion, grows exponentially (x2) as the depth approaches N

Space Complexity: O(n) for recursion stack
*/


//Solution 2 - Top-down DP with Memoization
public int fib(int n) {
    int memo[] = new int[n+1];
    return memoize(memo, n);
}
public int memoize(int[] memo, int n) {
    if (n < 2) return n;
    // return the saved, already solved result
    if (memo[n] > 0) return memo[n];
    // save the first-solved subproblem
    memo[n] = memoize(memo,n-1) + memoize(memo,n-2);
    return memo[n];
}
/*
Time Complexity: O(n)
- Each number up to n is visited, computed and stored and accessed for O(1)

Space Complexity: O(n) for recursion stack
*/

//Solution 3 - Bottom-up DP with Tabulation
public int fib(int n) {
    if (n < 2) return n;
    int dp[] = new int[n+1];
    dp[0] = 0; dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
/*
Time Complexity: O(n)
- Each number up to n is visited, computed and stored and accessed for O(1)

Space Complexity: O(n) for `dp[]`
*/
