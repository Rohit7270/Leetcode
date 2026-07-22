class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int row = 0; row< n; row++){
            for(int col = 0; col < m; col++){
                if(obstacleGrid[row][col] == 1){
                    dp[row][col] = 0;
                }
                else if(row == 0 && col == 0) dp[row][col] = 1;
                
                else{
                    int down = 0;
                    if(row > 0){
                        down = dp[row-1][col];
                    }
                    int right = 0;
                    if(col > 0){
                        right = dp[row][col-1];
                    }
                    dp[row][col] = right + down;
                }
            }
        }
        return dp[n-1][m-1];
    }
    private int path(int row, int col, int[][] obstacleGrid, int[][] dp){
        if(row < 0 || col < 0) return 0;
        if(row >= 0 && col >= 0 && obstacleGrid[row][col] == 1) return 0;
        if(row == 0 && col == 0) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int left = path(row, col-1, obstacleGrid, dp);
        int up = path(row-1, col, obstacleGrid, dp);
        return dp[row][col] = left + up;
    }
}