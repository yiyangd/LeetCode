//Solution 1 - DFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        image[r][c] = newColor;
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int k = 0; k < 4; k++) {
            int newR = r + dirs[k][0];
            int newC = c + dirs[k][1];
            if (newR >= 0 && newR < image.length && newC >= 0
               && newC < image[0].length && image[newR][newC] == color) {
                dfs(image,newR,newC,color,newColor);
            }
        }
    }
}
/*
Time Complexity: O(N), where N is the number of pixels in the image.  

Space Complexity: O(N), the size of the implicit call stack when calling `dfs`.
*/

/// Solution 2 - BFS
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int color = image[sr][sc];
    if (color != newColor) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr,sc});

        image[sr][sc] = newColor;
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // first in first out
            int r = cell[0];
            int c = cell[1];
            for (int k = 0; k < 4; k++) {
                int newR = r + dirs[k][0];
                int newC = c + dirs[k][1];
                if (newR >= 0 && newR < image.length && newC >= 0
                    && newC < image[0].length && image[newR][newC] == color) {
                    image[newR][newC] = newColor;
                    queue.offer(new int[]{newR,newC});
                }
            }           
        }           
    }
    return image;
}
/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
