class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        if(n == 1 && m == 1) return 1;

        int[][] dis = new int[n][m];

        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                dis[i][j] = (int)1e9;
            }
        }
        dis[0][0] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, 0, 0));
        int[] nrow = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] ncol = {-1, 1, 1, 0, -1, -1, 0, 1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int distance = p.first;
            int x = p.second;
            int y = p.third;
            for(int i = 0; i< 8; i++){
                int row = x + nrow[i];
                int col = y + ncol[i];
                if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 0 && distance + 1 < dis[row][col]){
                    if(row == n-1 && col == m-1) return distance +1;
                    q.offer(new Pair(distance + 1, row, col));
                    dis[row][col] = distance + 1;
                }
            }
        }
        return -1;
    }
    class Pair{
        int first;
        int second;
        int third;
        Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}