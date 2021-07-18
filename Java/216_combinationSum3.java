//Solution - Backtracking

private List<List<Integer>> combs = new ArrayList<>();
public List<List<Integer>> combinationSum3(int k, int n) {
    backtrack(k,n,0,1,new ArrayList<>());
    return combs;
}
private void backtrack(int k, int n, int sum, int step, List<Integer> comb){
    if (sum == n && comb.size() == k) {
        combs.add(new ArrayList<>(comb));
        return;
    }
    if (sum >= n || comb.size() >= k || step > 9) return;

    backtrack(k,n,sum,step+1,comb);
    comb.add(step);
    backtrack(k,n,sum+step,step+1,comb);
    comb.remove(comb.size()-1);
}
/*
Time Complexity: $O(k \times C(9,k))$
- there are C(9,k) combinations and each will take O(k) to check  

Space Complexity: O(k) for `comb` and recursion stack
*/
