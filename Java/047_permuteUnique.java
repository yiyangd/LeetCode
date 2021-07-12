//Solution - Backtracking

public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> perms = new ArrayList<List<Integer>>();
    List<Integer> perm = new ArrayList<Integer>();
    boolean[] vis = new boolean[nums.length];
    Arrays.sort(nums);
    backtrack(nums, vis, perm, perms, 0);
    return perms;
}

public void backtrack(int[] nums, boolean[] vis, List<Integer> perm, List<List<Integer>> perms, int idx) {
    if (idx == nums.length) {
        perms.add(new ArrayList<Integer>(perm));
        return;
    }
    for (int i = 0; i < nums.length; ++i) {
        if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
            continue;
        }
        perm.add(nums[i]);
        vis[i] = true;
        backtrack(nums, vis, perm, perms, idx + 1);
        vis[i] = false;
        perm.remove(idx);
    }
}
/*
Time Complexity: $O(n · n!)$
- times of `backtrack` called: O(n!)
- ArrayList.add: O(n)


Space Complexity: O(n+n) = O(n)
- O(n) for `vis` and O(n) for recursion stack
*/
