class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        if(color == iniColor) return image;
        int[][] ans = image;
        int[] nrow = {0, 1, 0, -1};
        int[] ncol = {1, 0, -1, 0};
        bfs(ans, image, sr, sc, color, nrow, ncol, iniColor);
        return ans;
    }
    private void bfs(int[][]ans, int[][]image, int sr, int sc, int color, int[] nrow, int[] ncol, int iniColor){
        ans[sr][sc] = color;
        int n = ans.length;
        int m = ans[0].length;
        for(int i = 0; i< 4; i++){
            int row = sr + nrow[i];
            int col = sc + ncol[i];
            if(row < n && row >= 0 && col < m && col >= 0 && image[row][col] == iniColor && ans[row][col] != color){
                bfs(ans, image, row, col, color, nrow, ncol, iniColor);
            }
        }
    }
}