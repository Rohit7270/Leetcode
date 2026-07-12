class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];

        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                dis[i][j] = (int)1e9;
            }
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dis[u][v] = wt;
            dis[v][u] = wt;
        }

        for(int i = 0; i< n; i++) dis[i][i] = 0;

        for(int via = 0; via< n; via++){
            for(int i = 0; i< n; i++){
                for(int j = 0; j< n; j++){
                    if(dis[i][via] == (int)1e9 || dis[via][j] == (int)1e9) continue;
                    dis[i][j] = Math.min(dis[i][j], dis[i][via] + dis[via][j]);
                }
            }
        }
        int max = n;
        int cityno = -1;

        for(int i = 0; i< n; i++){
            int cnt = 0;
            for(int j = 0; j< n; j++){
                if(dis[i][j] <= distanceThreshold){
                    cnt++;
                }                
            }
            if(cnt <= max){
                max = cnt;
                cityno = i;
            }
        }
        return cityno;
    }
}