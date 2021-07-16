// Solution - Backtracking
public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++) 
            board[i][j] = '.';
    }
    backtrack(0,board,result,n);
    return result;
}

public void backtrack(int row, char[][] board, 
                      List<List<String>> result, int n){
    if (row == n){
        List<String> board_copy = new ArrayList<String>();
        for (int i = 0; i < n; i++)
            board_copy.add(new String(board[i]));
        result.add(board_copy);
        return;
    }
    for (int col = 0; col < n; col++){
        if (isValid(board, row, col, n)){
            board[row][col] = 'Q';
            backtrack(row+1, board, result, n);
            board[row][col] = '.';
        }
    }
}

private boolean isValid(char[][] board, int row, int col, int n){
    // Check Column up
    for (int i = 0; i < row; i++){
        if (board[i][col] == 'Q') return false;
    }
    // Check upper left 
    for (int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
        if (board[i][j] == 'Q') return false;
    }
    // Check upper right 
    for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--,j++){
        if (board[i][j] == 'Q') return false;
    }
    return true;
}

/*

Time Complexity: $O(N!)$
- For the first row, there are N options
- For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. 
    - for each N options, there are at most (N-2) options to be considered, and then (N-4)...  


Space Complexity: $O(N^2)$ for board size

*/
