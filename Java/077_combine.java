//Solution - Backtracking & Recursion

public List<List<Integer>> combine (int n, int k){
    List<List<Integer>> combs = new ArrayList<List<Integer>>();
    backtrack(1,n,k,combs,new LinkedList<Integer>());
    return combs;
}
public void backtrack(int curr, int n, int k, List<List<Integer>> combs,
                        LinkedList<Integer> comb){
    if (comb.size() == k){ // base: combination is done
        combs.add(new LinkedList(comb));
        return;
    }
    for(int i = curr; i < n+1; i++){ 
        comb.add(i);     
        backtrack(i+1,n,k,combs,comb);
        comb.removeLast();
    }
}
//Time Complexity:$O(kC^k_N)$ where $C^k_N=\frac{N!}{(N-k)!k!}$ is a number of combinations to build
//Space Complexity:$O(C^k_N)$to keep all the combinations as for an output
