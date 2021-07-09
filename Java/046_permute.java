//Solution - Backtracking

public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> pmtns = new ArrayList<List<Integer>>();
    List<Integer> pmtn = new ArrayList<Integer>();
    for (int num:nums) pmtn.add(num); //pmt=[1,2,3]
    backtrack(nums.length,pmtn,pmtns,0);
    return pmtns;
}
public void backtrack(int n, List<Integer> pmtn, List<List<Integer>> pmtns, int first){
    if (first == n)
        pmtns.add(new ArrayList<Integer>(pmtn));
    
    for(int i  = first; i < n; i++){
        Collections.swap(pmtn,first,i);
        backtrack(n,pmtn,pmtns,first+1);
        Collections.swap(pmtn,first,i);
    }
}

/*
Time Complexity: $O(\sum^N_{k=1}P(N,k))$ where $P(N,k)=\frac{N!}{(N-k)!}$
- equals the # of times that `backtrack` is called
- the algorithm performs better than $O(N·N!)$ and a bit slower than O(N!)
Space Complexity: $O(N!)$ since `pmtns` keeps N! solutions
*/
