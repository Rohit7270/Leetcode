class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] arr = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    arr[i][j] = 0;
                    q.offer(new Pair(i , j));
                }
            }
        }
        int[] nrow = {0, 1, -1, 0};
        int[] ncol = {1, 0, 0, -1};
        bfs(vis, arr, mat, q, nrow, ncol, 0);
        return arr;
    }
    private void bfs(boolean[][] vis, int[][] arr, int[][] mat, Queue<Pair> q, int[] nrow, int[] ncol, int i){
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for(int j = 0; j< 4; j++){
                int sr = row + nrow[j];
                int sc = col + ncol[j];
                if(sr >=0 && sr < arr.length && sc >=0 && sc < arr[0].length && vis[sr][sc] == false){
                    vis[sr][sc] = true;
                    arr[sr][sc] = arr[row][col] + 1; 
                    q.offer(new Pair(sr, sc));
                }
            }
        }
    }
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}