class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int row = 0; row< n; row++){
            for(int col = 0; col < m; col++){
                if(row == 0 && col == 0) continue;
                int right = Integer.MAX_VALUE;
                if(col > 0){
                    right = grid[row][col] + dp[row][col-1];
                }
                int down = Integer.MAX_VALUE;
                if(row > 0){
                    down = grid[row][col] + dp[row-1][col];
                }
                dp[row][col] = Math.min(right, down);
            }
        }
        return dp[n-1][m-1];
    }
}