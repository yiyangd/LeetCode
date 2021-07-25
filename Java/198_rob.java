/*
198. House Robber
> Given an integer array `nums` representing the amount of money of each house, return the `maximum amount` of money you can rob tonight without breaking two adjacent houses.
```
Input: {2, (5), 1, 3, (6), 2, (4)}
Output: 15
Explanation: The thief should steal from houses 5 + 6 + 4
```
*/

//Solution 1 - Top-down DP with Memoization 
public int rob(int[] nums) {
    int[] dp = new int[nums.length + 1];
    Arrays.fill(dp, -1); // -1 to mark unsolved subproblem
    return memo(dp, nums, nums.length - 1);
}

private int memo(int[] dp, int[] nums, int n) {
    if (n < 0) return 0; // base: dp[0] = num[0] + (memo(-1) = 0)
    if (dp[n] == -1) 
        dp[n] = Math.max(memo(dp, nums, n - 2) + nums[n], memo(dp, nums, n - 1));
    return dp[n];
}
/*
Time Complexity: O(n)

Space Complexity: O(n) for recursion stack
*/

//Solution 2 - Bottom-up DP with Tabulation
public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int[] dp = new int[nums.length];
    dp[0] = nums[0]; dp[1] = Math.max(nums[0],nums[1]);
    for (int i = 2; i < nums.length; i++) 
        dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
    return dp[nums.length - 1];
}
/*
Time Complexity: O(n)

Space Complexity: O(n) for `dp[]`
*/
