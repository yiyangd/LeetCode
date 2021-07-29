/*
213. House Robber II
> Given an integer array `nums` representing the amount of money of each house, return the `maximum amount` of money you can rob tonight without breaking two adjacent houses `arranged in a circle`.

```
Input: nums:[2,3,2]
Output: 3
Explanation: the first house and the neighbor of the last one
```
*/

//Solution 1 - Top-down DP with Memoization 
public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    //if (nums.length == 2) return Math.max(nums[0],nums[1]);
    return Math.max(robMemo(nums,0,nums.length-2),robMemo(nums,1,nums.length-1));
}
public int robMemo(int[] nums, int start, int end) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return memo(dp, nums, start, end);
}
private int memo(int[] dp, int[] nums, int start, int end) {
    if (end < start) return 0; // base: n = 0, nums[0]
    if (dp[end] == -1) 
        dp[end] = Math.max(memo(dp, nums, start, end - 2) + nums[end], memo(dp, nums, start, end - 1));
    return dp[end];
}
/*
Time Complexity: O(n)

Space Complexity: O(n) for recursion stack
*/

// Solution 2 - Bottom-up DP with Tabulation
public int rob(int[] nums) {
    //if (nums.length == 0 || nums == null) return 0;
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0],nums[1]);
    return Math.max(robTab(nums,0,nums.length-2),robTab(nums,1,nums.length-1));
}

public int robTab(int[] nums, int start, int end) {
    int[] dp = new int[nums.length];
    dp[start] = nums[start]; dp[start+1] = Math.max(nums[start],nums[start+1]);
    // start: 0 and 1, end: length - 2, length - 1 //
    for (int i = start + 2; i <= end; i++) 
        dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
    return dp[end];
    
    /* 
    // Space Optimization : O(1)
    int cur = 0, next = 0;
    for (int i = start; i <= end; i++) {
        int temp = next;
        next = Math.max(nums[i] + cur, next);
        cur = temp;
    }
    return next;
    */
}

/*
Time Complexity: O(n)

Space Complexity: O(n) for `dp[]`
*/
