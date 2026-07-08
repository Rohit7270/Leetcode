class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        if(n == 1 && m == 1) return 0;

        int[][] dis = new int[n][m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                dis[i][j] = (int)1e9;
            }
        }
        dis[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.first - b.first);
        pq.offer(new Pair(0, 0, 0));
        int[] nrow = {0, 0, 1, -1};
        int[] ncol = {1, -1, 0, 0};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int distance = p.first;
            int x = p.second;
            int y = p.third;
            if(distance > dis[x][y]) continue;
            if(x == n-1 && y == m-1) return distance;
            for(int i = 0; i< 4; i++){
                int row = x + nrow[i];
                int col = y + ncol[i];
                if(row >= 0 && row < n && col >= 0 && col < m){
                    int effort = Math.max(distance, Math.abs(heights[row][col] - heights[x][y]));
                    if(effort < dis[row][col]){
                        dis[row][col] = effort;
                        pq.offer(new Pair(effort, row, col));
                    }
                }
            }
        }
        return 0;
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