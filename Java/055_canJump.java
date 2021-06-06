// Solution 1 - DP Top-down
// Time Complexity: $O(n^2)$ 
// Space Complexity: $O(n)$
enum Index {
    GOOD, BAD, UNKNOWN
}

Index[] memo;

public boolean canJumpFromPosition(int position, int[] nums) {
    if (memo[position] != Index.UNKNOWN) {
        return memo[position] == Index.GOOD ? true : false;
    }

    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
        if (canJumpFromPosition(nextPosition, nums)) {
            memo[position] = Index.GOOD;
            return true;
        }
    }

    memo[position] = Index.BAD;
    return false;
}

public boolean canJump(int[] nums) {
    memo = new Index[nums.length];
    for (int i = 0; i < memo.length; i++) {
        memo[i] = Index.UNKNOWN;
    }
    memo[memo.length - 1] = Index.GOOD;
    return canJumpFromPosition(0, nums);
}

// Solution 2 - DP Bottom-Up
// Time Complexity: $O(n^2)$ 
// Space Complexity: $O(n)$
enum Index {
    GOOD, BAD, UNKNOWN
}

public boolean canJump(int[] nums) {
    Index[] memo = new Index[nums.length];
    for (int i = 0; i < memo.length; i++) {
        memo[i] = Index.UNKNOWN;
    }
    memo[memo.length - 1] = Index.GOOD;
    for (int i = nums.length - 2; i >= 0; i--) {
        int furthestJump = Math.min(i + nums[i], nums.length - 1);
        for (int j = i + 1; j <= furthestJump; j++) {
            if (memo[j] == Index.GOOD) {
                memo[i] = Index.GOOD;
                break;
            }
        }
    }
    return memo[0] == Index.GOOD;
}

//Solution 3 - Greedy

public boolean canJump(int[] nums) {
    int n = nums.length;
    int rightmost = 0;
    for (int i = 0; i < n; ++i) {
        if (i <= rightmost) {
            rightmost = Math.max(rightmost, i + nums[i]);
            if (rightmost >= n - 1) {
                return true;
            }
        }
    }
    return false;
}

// Time Complexity: $O(n)$ for a single pass through the `nums`   
// Space Complexity: $O(1)$
