//Solution 1 - DFS
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int num = 0;
    for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[r][c] == '1') {
                dfs(grid,r,c);
                num++;
            }
        }
    }
    return num;
}

private void dfs(char[][] grid, int r, int c) {
    grid[r][c] = '0';
    int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    for (int k = 0; k < 4; k++) {
        int newR = r + dirs[k][0];
        int newC = c + dirs[k][1];
        if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == '1') {
            dfs(grid,newR,newC);
        }
    }
}
/*
Time Complexity: O(mn)  
Space Complexity: O(mn)
*/


//Solution 2 - BFS
public int numIslands(char[][] grid) {
    int num = 0;
    for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[r][c] == '1') {
                num++;
                grid[r][c] = '0';
                Queue<Integer> queue = new LinkedList<>();
                queue.add(r * grid[0].length + c);
                int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
                while (!queue.isEmpty()) {
                    int cellId = queue.remove();
                    int row = cellId/grid[0].length;
                    int col = cellId%grid[0].length;
                    for (int k = 0; k < 4; k++) {
                        int newR = row + dirs[k][0];
                        int newC = col + dirs[k][1];
                        if (newR>=0 && newR<grid.length 
                            && newC>=0 && newC<grid[0].length
                            && grid[newR][newC] == '1') {
                            queue.add(newR*grid[0].length+newC);
                            grid[newR][newC] = '0';
                        }
                    }
                }
            }
        }
    }
    return num;
}
/*
Time Complexity: O(mn)  
Space Complexity: O(min(m,n))
*/
