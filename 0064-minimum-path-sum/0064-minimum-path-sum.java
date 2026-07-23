class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        for(int row = 0; row< n; row++){
            int[] temp = new int[m];
            for(int col = 0; col < m; col++){
                if(row == 0 && col == 0) temp[0] = grid[0][0];
                else{
                    int right = Integer.MAX_VALUE;
                    if(col > 0){
                        right = grid[row][col] + temp[col-1];
                    }
                    int down = Integer.MAX_VALUE;
                    if(row > 0){
                        down = grid[row][col] + dp[col];
                    }
                    temp[col] = Math.min(right, down);
                }
            }
            dp = temp;
        }
        return dp[m-1];
    }
}