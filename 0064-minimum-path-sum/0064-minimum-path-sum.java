class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i< n; i++){
            Arrays.fill(dp[i], -1);
        }
        return minimal(n-1, m-1, grid, dp);
    }
    private int minimal(int row, int col, int[][] arr, int[][] dp){
        if(row == 0 && col == 0) return arr[0][0];
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        if(dp[row][col] != -1) return dp[row][col];
        int up = minimal(row-1, col, arr, dp);
        if(up != Integer.MAX_VALUE){
            up += arr[row][col];
        }
        int left = minimal(row, col-1, arr, dp);
        if(left != Integer.MAX_VALUE){
            left += arr[row][col];
        }
        return dp[row][col] = Math.min(up, left);
    }
}