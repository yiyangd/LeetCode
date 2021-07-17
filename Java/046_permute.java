//Solution - Backtracking
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> pmtns = new ArrayList<List<Integer>>();
    List<Integer> pmtn = new ArrayList<Integer>();
    backtrack(nums,0,pmtn,pmtns);
    return pmtns;
}

public void backtrack(int[] nums,int idx, List<Integer> pmtn, List<List<Integer>> pmtns){
    if (idx == nums.length){
        pmtns.add(new ArrayList<Integer>(pmtn));
        return;
    } 

    for (int i  = 0; i < nums.length; i++){
        if(pmtn.contains(nums[i])) 
            continue;
        pmtn.add(nums[i]);
        backtrack(nums,idx+1,pmtn,pmtns);
        pmtn.remove(pmtn.size()-1);
    }
}

/*
Time Complexity: $O(\sum^N_{k=1}P(N,k))$ where $P(N,k)=\frac{N!}{(N-k)!}$
- equals the # of times that `backtrack` is called
- the algorithm performs better than $O(N·N!)$ and a bit slower than O(N!)
Space Complexity: $O(N!)$ since `pmtns` keeps N! solutions
*/
