//Solution - Backtracking

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<> ();
    backtrack(nums, 0, new ArrayList<Integer>(), subsets);
    return subsets;
}
private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsets) {
    if (idx == nums.length) {
        subsets.add(new ArrayList(subset));
        return;
    }
    backtrack(nums, idx + 1, subset, subsets);
    subset.add(nums[idx]);
    backtrack(nums, idx + 1, subset, subsets);
    subset.remove(subset.size() - 1);
}
/*
Time Complexity: $O(N \times 2^N)$
- to generate all subsets and then copy them into output list.

Space Complexity: $O(N)$ for `subset`
*/
