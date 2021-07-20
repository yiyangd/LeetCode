//Solution - Backtracking
private List<String> res = new ArrayList<>();
public List<String> generateParenthesis(int n) {
    backtrack(n, 0, 0, new StringBuilder());
    return res;
}
private void backtrack(int n, int open, int close, StringBuilder path){
    if (path.length() == n*2) {
        res.add(path.toString());
        return;
    }
    if (open < n) {
        path.append("(");
        backtrack(n,open+1,close,path);
        path.deleteCharAt(path.length()-1);
    }
    if (open > close) {
        path.append(")");
        backtrack(n,open,close+1,path);
        path.deleteCharAt(path.length()-1);
    }
}
/*
Time Complexity:$\frac{4^n}{\sqrt{n}$
- The number of elements in `generateParenthesis(n)` is the n-th *Catalan number* $\frac{1}{n+1}\tbinom{2n}{n}$
    - which is bounded asymptotically by $\frac{4^n}{n\sqrt{n}$
- Each valid sequence has at most n steps during the backtracking procedure.

Space Complexity:$\frac{4^n}{\sqrt{n}$
- O(n) space to store the sequence.
*/
