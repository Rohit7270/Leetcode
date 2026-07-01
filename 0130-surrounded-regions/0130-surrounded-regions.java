class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] nrow = {0, 0, -1, 1};
        int[] ncol = {1, -1, 0, 0};
        for(int i = 0; i< n; i++){
            if(vis[i][0] == false && board[i][0] == 'O'){
                dfs(vis, board, i, 0, nrow, ncol);
            }
            if(vis[i][m-1] == false && board[i][m-1] == 'O'){
                dfs(vis, board, i, m-1, nrow, ncol);
            }
        }
        for(int i = 0; i< m; i++){
            if(vis[n-1][i] == false && board[n-1][i] == 'O'){
                dfs(vis, board, n-1, i, nrow, ncol);
            }
            if(vis[0][i] == false && board[0][i] == 'O'){
                dfs(vis, board, 0, i, nrow, ncol);
            }
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(vis[i][j] == false && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(boolean[][] vis, char[][] board, int row, int col, int[] nrow, int[] ncol){
        vis[row][col] = true;
        for(int i = 0; i< 4; i++){
            int ro = row + nrow[i];
            int co = col + ncol[i];
            if(ro >=0 && ro < board.length && co >= 0 && co < board[0].length && vis[ro][co] == false && board[ro][co] == 'O'){
                dfs(vis, board, ro, co, nrow, ncol);
            }
        }
    }
}