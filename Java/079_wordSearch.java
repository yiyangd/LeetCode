
//Solution - Backtracking & DFS

public boolean exist(char[][] board, String word) {
    for (int r = 0; r < board.length; r++) {
        for (int c = 0; c < board[0].length; c++) {
            if (backtrack(board,word,r,c,0))
                return true;
        }
    }
    return false;
}
private boolean backtrack(char[][] board, String word, int r, int c, int idx) {

    if (idx == word.length()) return true;

    if(r >= 0 && r < board.length && c >= 0 
       && c < board[0].length && board[r][c] == word.charAt(idx)) {

        board[r][c] = '#'; // to avoid traverse back
        /* Slower
        boolean existed = false;
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int k = 0; k < 4; k++) {
            existed = backtrack(board,word,r+dirs[k][0],c+dirs[k][1],idx+1);
            if (existed) break;
        }*/

        /* Faster */
        boolean existed = backtrack(board,word,r-1,c,idx+1)
                    || backtrack(board,word,r+1,c,idx+1)
                    || backtrack(board,word,r,c-1,idx+1)
                    || backtrack(board,word,r,c+1,idx+1);

        board[r][c] = word.charAt(idx);
        return existed;
    }
    // If out of boundaries
    return false;
}
/*
Time Complexity: $O(mn · 3^L)$
- for each cell of the `board`, there are 3 options to go further (since we won't go back to where we come from)

Space Complexity: O(L) for recursion stack for the length of the `word`
*/
