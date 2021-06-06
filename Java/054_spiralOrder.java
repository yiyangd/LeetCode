
// Solution 1 - Simulation
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> order = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return order;
    }
    int rows = matrix.length, columns = matrix[0].length;
    boolean[][] visited = new boolean[rows][columns];
    int total = rows * columns;
    int row = 0, column = 0;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int directionIndex = 0;
    for (int i = 0; i < total; i++) {
        order.add(matrix[row][column]);
        visited[row][column] = true;
        int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
        if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
            directionIndex = (directionIndex + 1) % 4;
        }
        row += directions[directionIndex][0];
        column += directions[directionIndex][1];
    }
    return order;
}

// Time Complexity: $O(mn)$   
// Space Complexity: $O(mn)$ 

// Solution 2 - Layer-by-Layer
public List < Integer > spiralOrder(int[][] matrix) {
    List ans = new ArrayList();
    if (matrix.length == 0)
        return ans;
    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;
    while (top <= bottom && left <= right) {
        for (int col = left; col <= right; col++) ans.add(matrix[top][col]);
        for (int row = top + 1; row <= bottom; row++) ans.add(matrix[row][right]);
        if (top < bottom && left < right) {
            for (int col = right - 1; col > left; col--) ans.add(matrix[bottom][col]);
            for (int row = bottom; row > top; row--) ans.add(matrix[row][left]);
        }
        top++;
        bottom--;
        left++;
        right--;
    }
    return ans;
}

// Time Complexity: $O(mn)$   
// Space Complexity: $O(mn)$ 
