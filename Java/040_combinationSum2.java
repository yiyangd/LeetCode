// Solution - Backtracking with Index

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> combs = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates,target,comb,combs,0);
    return combs;
}
public void backtrack(int[] candidates, int target, List<Integer> comb,
                        List<List<Integer>> combs, int idx){
    if (target == 0){
        combs.add(new ArrayList<Integer>(comb));
        return;
    }
    if (target < 0) return;

    for (int i = idx; i < candidates.length; i++){
        if (i > idx && candidates[i] == candidates[i-1])
            continue; // skip to avoid duplicates, backtrack has already considered same values in candidates
        comb.add(candidates[i]);
        backtrack(candidates,target-candidates[i],comb,combs,i+1);
        comb.remove(comb.size()-1);
    }
}
/*
Time Complexity: $O(2^N)$  
- in the worst case, backtrack() will run with all $2^N$ possible combinations from the input array

Space Complexity: $O(N)$ for `comb` and recursion stack
*/
