//Solution - Two Pointers
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int diff_index = 0;
    for (int j = 0; j < nums.length; j++){
        if (nums[diff_index] != nums[j]){
            nums[++diff_index] = nums[j];
        }
    }
    return diff_index + 1        
}
// Time Complexity: $O(N)$  
// Space Complexity: $O(1)$
