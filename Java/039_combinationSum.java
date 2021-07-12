//Solution - Backtracking

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> combs = new ArrayList<List<Integer>>();
    List<Integer> comb = new ArrayList<Integer>();
    backtrack(candidates,target,combs,comb,0);
    return combs;
}
public void backtrack(int[] candidates, int target,List<List<Integer>> combs,
                      List<Integer> comb, int idx){
    if (target == 0){
        combs.add(new ArrayList<Integer>(comb));
        return;
    } else if (target < 0) return;
    for(int i = idx; i < candidates.length; i++){
        comb.add(candidates[i]);
        backtrack(candidates,target-candidates[i],combs,comb,i);
        comb.remove(comb.size()-1);
    }
/*
Time Complexity: $O(N^{\frac{T}{M}+1})$, a loose upper bound
- Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
- the time complexity is linear to the number of nodes of the execution tree.
- The maximal depth of the tree, would be $\frac{T}{M} $
    - where we keep on adding the smallest element to the combination.
- the maximal number of nodes in N-ary tree of $\frac{T}{M}$ height would be $N^{\frac{T}{M}+1}$

Space Complexity: $O(\frac{T}{M})$
- The number of recursive calls can pile up to $\frac{T}{M}$
    - where we keep on adding the smallest element to the combination
- In addition, we keep a combination of numbers during the execution, which requires at most $O(\frac{T}{M})$ space as well.
*/
