class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[] dp = new int[m];
        for(int i = 0; i< m; i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        for(int row = n-2; row >= 0; row--){
            int[] temp = new int[row+1];
            for(int col = row; col >= 0; col--){
                int up = triangle.get(row).get(col) + dp[col];
                int diagonal = triangle.get(row).get(col) + dp[col+1];
                temp[col] = Math.min(up, diagonal);
            }
            dp = temp;
        }
        return dp[0];
    }
}