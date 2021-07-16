//Solution - Backtracking

private boolean[][] rows = new boolean[9][10];
private boolean[][] cols = new boolean[9][10];
private boolean[][][] blocks = new boolean[3][3][10];
private boolean solved = false;

public void solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
            if (board[i][j] != '.'){ // has a number
                int num = board[i][j] - '0'; // char - 'ASCII' => int
                rows[i][num] = true;
                cols[j][num] = true;
                blocks[i/3][j/3][num] = true;
            }
        }
    }
    backtrack(0, 0, board);
}

private void backtrack(int row, int col, char[][] board) {
    if (row == 9){
        solved = true;
        return;
    }
    if (board[row][col] != '.'){ // move to next cell 
        int nextRow = row;
        int nextCol = col + 1;
        if (col == 8){
            nextRow = row + 1;
            nextCol = 0;
        }
        backtrack(nextRow, nextCol, board);
        if (solved) return;
    } else { // the cell is empty
        for (int num = 1; num <= 9; num++) {
            if (!rows[row][num] && !cols[col][num] && !blocks[row/3][col/3][num]){
                board[row][col] = String.valueOf(num).charAt(0); // put in the num => char
                rows[row][num] = true;
                cols[col][num] = true;
                blocks[row/3][col/3][num] = true;

                // move to next cell
                int nextRow = row;
                int nextCol = col + 1;
                if (col == 8) {
                    nextRow = row + 1;
                    nextCol = 0;
                }
                backtrack(nextRow, nextCol, board);
                if (solved) return;

                board[row][col] = '.';
                rows[row][num] = false;
                cols[col][num] = false;
                blocks[row/3][col/3][num] = false;
            }
        }
    }
}
/*
Time complexity is constant, the number of operations needed: $(9!)^9$
- There are not more than 9 possibilities for the first number to put, not more than 9×8 for the second one, not more than 9×8×7 for the third one etc. 
- In total that results in not more than 9! possibilities for a just one row, that means not more than $(9!)^9$ operations in total.

Space complexity: the board size is fixed, and the space is used to store board, rows, columns and boxes structures, 
- each contains 9 x 10 = 90 elements.
*/
