// Solution - Backtracking

private List<List<String>> res = new ArrayList<>();
public List<List<String>> partition(String s) {
    backtrack(s,0,new ArrayList<>());
    return res;
}
private void backtrack(String s, int idx, List<String> path) {
    if (idx == s.length()) {
        res.add(new ArrayList<>(path));
        return;
    }
    for (int end = idx; end < s.length(); end++) {
        if (isPalindrome(s, idx, end)) {
            path.add(s.substring(idx, end + 1));
            backtrack(s, end + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
boolean isPalindrome(String s, int low, int high){
    while(low < high){
        if (s.charAt(low++) != s.charAt(high--)) 
            return false;
    }
    return true;
}

/*
Time Complexity: $O(N \times 2^N)$
- the worst-case time complexity when all the possible substrings are palindrome.

Space Complexity: O(N) to store the recursion stack.
*/
