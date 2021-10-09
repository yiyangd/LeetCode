//Solution 1 - Backtrack
int count = 0;
public int findTargetSumWays(int[] nums, int target) {
    backtrack(nums, target, 0, 0);
    return count;
}
public void backtrack(int[] nums, int target, int idx, int sum) {
    if (idx == nums.length) {
        if (sum == target) count++;
    } else {
        backtrack(nums, target, idx + 1, sum + nums[idx]);
        backtrack(nums, target, idx + 1, sum - nums[idx]);
    }
}

// Time Complexity: $O(2^n)$  
// Space Complexity: $O(n)$ for recursion stack

//Solution 2 - Top-Down DP with Memoization
public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) sum += num;
    int[][] dp = new int[nums.length][2*sum+1];
    for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
    return memo(nums, 0, 0, target, sum, dp);
}
public int memo(int[] nums, int idx, int subSum, int target, int sum, int[][] dp) {
    if (idx == nums.length) {
        return (subSum == target)? 1 : 0;
    } else {
        if (dp[idx][subSum+sum] != Integer.MIN_VALUE)
            return dp[idx][subSum+sum];
        int add = memo(nums,idx+1, subSum + nums[idx], target, sum, dp);
        int subtract = memo(nums,idx+1, subSum - nums[idx], target, sum, dp);
        dp[idx][subSum+sum] = add + subtract;
        return dp[idx][subSum + sum];
    }
}
//Time Complexity: $O(sum \times length)$  
//Space Complexity: $O(sum \times length)$  

// Solution 3 - 
