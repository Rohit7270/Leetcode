class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    cnt++;
                    bfs(row, col, grid, vis);
                }
            }
        }
        return cnt;
    }
    private void bfs(int row, int col, char[][] grid, int[][] vis){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();
            for(int ro = -1; ro < 2; ro++){
                for(int co = -1; co < 2; co++){
                    if(Math.abs(ro) + Math.abs(co) != 1){
                        continue;
                    }
                    int nrow = i + ro;
                    int ncol = j + co;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        vis[nrow][ncol] = 1;
                        q.offer(new Pair(nrow, ncol));                      
                    }
                }
            }
        }
            
    }
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}