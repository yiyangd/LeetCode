// Solution 1: Rotate Groups of Four Cells
public void rotate(int[][] matrix) {
    int n = matrix.length; // n = 5
    for (int i = 0; i < (n + 1)/2; i++){ // i = 0, 1, 2
        for (int j = 0; j < n /2; j++){ // j = 0, 1
            int temp = matrix[i][j]; // 00,01
            matrix[i][j] = matrix[n-1-j][i]; // n-1_0, n-2_0
            matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; // n-1_n-1, n-2_n-2
            matrix[n-1-i][n-1-j] = matrix[j][n-1-i]; // 0_n-1, 1_n-1
            matrix[j][n-1-i] = temp;
        }
    }
}
// Time Complexity: $O(N^2)$   
// Space Complexity: $O(1)$ 

// Solution 2: Transpose and Reflect
public void rotate(int[][] matrix) {
    int n = matrix.length;
    // Reverse on Diagonal 
    for (int i = 0; i < n; i++){
        for (int j = i+1; j < n; j++){
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = tmp;
        }
    }
    // Reverse Left to Right
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n/2; j++){
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[i][n-1-j];
            matrix[i][n-1-j] = tmp;          
        }
    }  
}
//Time Complexity: $O(N^2)$   
//Space Complexity: $O(1)$ 
