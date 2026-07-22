class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int row = 0; row< m; row++){
            int[] temp = new int[n];
            for(int col = 0; col< n; col++){
                if(row == 0 && col == 0) temp[col] = 1;
                else{
                    int down = 0;
                    if(row > 0){
                        down = dp[col];
                    }
                    int right = 0;
                    if(col > 0){
                        right = temp[col-1];
                    }
                    temp[col] = down + right;
                }
            }
            dp = temp;
        }
        return dp[n-1];
    }
}