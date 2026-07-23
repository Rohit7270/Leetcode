class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return minimal(0, 0, n-1, triangle, dp);
    }
    private int minimal(int row, int col, int size, List<List<Integer>> arr, Integer[][] dp){
        if(size == row) return arr.get(row).get(col);
        if(dp[row][col] != null) return dp[row][col];
        int down = arr.get(row).get(col) + minimal(row+1, col, size, arr, dp);
        int diagonal = arr.get(row).get(col) + minimal(row+1, col+1, size, arr, dp);
        return dp[row][col] = Math.min(down, diagonal);
    }
}