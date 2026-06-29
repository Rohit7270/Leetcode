class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int temp = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 2){
                    q.offer(new Pair(row, col, 0));
                    vis[row][col] = 2;
                }
                else{
                    vis[row][col] = 0;
                }
                if(grid[row][col] == 1) temp++;
            }
        }
        int[] nrow = {-1, 0, 1, 0};
        int[] ncol = {0, -1, 0, 1};
        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Pair p = q.poll(); 
            int r = p.first;
            int c = p.second;
            int tee = p.t;
            tm = Math.max(tee, tm);           
            for(int j = 0; j < 4; j++){
                int ro = r + nrow[j];
                int co = c + ncol[j];
                if(ro < grid.length && ro >= 0 && co < grid[0].length && co >= 0 && vis[ro][co] == 0 && grid[ro][co] == 1){
                    vis[ro][co] = 2;
                    q.offer(new Pair(ro, co, tee+1));
                    cnt++;
                }
            }            
        }
        if(temp != cnt) return -1;
        return tm;
    }
    class Pair{
        int first;
        int second;
        int t;
        Pair(int first, int second, int t){
            this.first = first;
            this.second = second;
            this.t = t;
        }
    }
}