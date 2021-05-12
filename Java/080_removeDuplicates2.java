// Solution 1 - Two Pointers
public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 2) {
        return n;
    }
    int slow = 2, fast = 2;
    while (fast < n) {
        if (nums[slow - 2] != nums[fast]) {
            nums[slow++] = nums[fast];
            //++slow;
        }
        ++fast;
    }
    return slow;
}

//Time Complexity: $O(N)$  
//Space Complexity: $O(1)$

// Solution 2 - To keep at most K duplicates
public int removeDuplicates(int[] nums) {
    int K = 2;
    int length = 0;
    for (int num:nums) {
        if (length < K || nums[length - K] != num){
            nums[length++] = num;
        }
    }
    return length;
}

//Time Complexity: $O(N)$  
//Space Complexity: $O(1)$
