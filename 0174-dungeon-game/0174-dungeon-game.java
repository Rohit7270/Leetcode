class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i< n; i++){
            Arrays.fill(dp[i], -1);
        }
        return minimal(0, 0, dungeon, dp);
    }
    private int minimal(int row, int col, int[][] arr, int[][] dp){
        int n = arr.length;
        int m = arr[0].length;
        if(row == n-1 && col == m-1){
            return Math.max(1, 1 - arr[row][col]);
        }
        if(row >= n || col >= m) return Integer.MAX_VALUE;
        if(dp[row][col] != -1) return dp[row][col];
        int left = minimal(row, col+1, arr, dp);
        int up = minimal(row+1, col, arr, dp);
        int need = Math.min(left, up) - arr[row][col];
        return dp[row][col] =  Math.max(1, need);
    }
}