// Solution - Backtracking

private List<List<Integer>> subsets = new ArrayList<>();
public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);

    List<Integer> subset = new ArrayList<>();

    backtrack(nums, 0, subset);
    return subsets;
}
private void backtrack(int[] nums, int index, List<Integer> subset) {
    // Add the subset formed so far to the subsets list.
    subsets.add(new ArrayList<>(subset));

    for (int i = index; i < nums.length; i++) {
        // If the current element is a duplicate, ignore.
        if (i > index && nums[i] == nums[i - 1]) 
            continue;
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset);
        subset.remove(subset.size() - 1);
    }
}
/*
Time Complexity: $O(N \times 2^N)$
- to generate all subsets and then copy them into output list.

Space Complexity: $O(N)$ for `subset`
*/
