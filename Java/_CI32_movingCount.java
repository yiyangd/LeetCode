//Solution - DFS
private boolean[][] visited;
private int count = 0;
private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
public int movingCount(int m, int n, int k) {
    visited = new boolean[m][n];
    dfs(0,0,m,n,k);
    return count;
}
private void dfs(int i, int j, int m, int n, int k) {
    visited[i][j] = true;
    count++;
    for (int di = 0; di < 4; di++) {
        int ii = i + directions[di][0];
        int jj = j + directions[di][1];
        if (ii >= m || ii < 0 || jj >= n || jj < 0 || visited[ii][jj] || !isValid(ii,jj,k))
            continue;
        dfs(ii,jj,m,n,k);
    }
}
private boolean isValid(int i, int j, int k) {
    int sum = 0;
    while (i != 0) {
        sum += (i%10);
        i /= 10;
    }
    while (j != 0) {
        sum += (j%10);
        j /= 10;
    }
    return sum <= k;
}
/*
Time Complexity: O(mn)  
Space Complexity: O(mn) for store `visit[m][n]`
*/
