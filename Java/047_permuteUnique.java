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

//Solution 2 - Backtracking with HashMap
private List<List<Integer>> perms = new ArrayList<>();
public List<List<Integer>> permuteUnique(int[] nums) {
    HashMap<Integer,Integer> hm = new HashMap<>();
    for (int i = 0; i < nums.length; i++){
        int count = 1;
        if (hm.containsKey(nums[i]))
            count += hm.get(nums[i]);
        hm.put(nums[i], count);
    }
    int[] uniNums = new int[hm.size()];
    int[] counts = new int[hm.size()];
    int k = 0;
    for (int i = 0; i < nums.length; i++){
        if (hm.containsKey(nums[i])) {
            uniNums[k] = nums[i];
            counts[k++] = hm.get(nums[i]);
            hm.remove(nums[i]);
        }
    }
    backtrack(uniNums, counts, 0, new ArrayList(), nums.length);
    return perms;
}
private void backtrack(int[] uniNums, int[] counts, int idx, List<Integer> perm, int n) {
    if (idx == n){
        perms.add(new ArrayList<>(perm));
        return;
    }
    for (int i = 0; i < uniNums.length; i++) {
        if (counts[i] == 0) continue;
        perm.add(uniNums[i]);
        counts[i]--;
        backtrack(uniNums,counts,idx+1,perm,n);
        perm.remove(perm.size()-1);
        counts[i]++;
    }
}

