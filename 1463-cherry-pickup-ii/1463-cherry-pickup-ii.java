class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] arr1 : dp){
            for(int[] arr2 : arr1){
                Arrays.fill(arr2, -1);
            }
        }
        return minimal(0, 0, m-1, grid, dp);
    }
    private int minimal(int row, int col1, int col2, int[][] arr, int[][][] dp){
        int n = arr.length;
        int m = arr[0].length;
        if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return Integer.MIN_VALUE;
        if(row == n-1){
            if(col1 == col2) return arr[row][col1];
            return arr[row][col1] + arr[row][col2];
        }
        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];
        int cherry;
        if(col1 == col2){
            cherry = arr[row][col1];
        }
        else{
            cherry = arr[row][col1] + arr[row][col2];
        }
        int max = Integer.MIN_VALUE;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                max = Math.max(max, minimal(row+1, col1+i, col2+j, arr, dp));
            }
        }
        return dp[row][col1][col2] = cherry + max;
    }
}