class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair1>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair1(v, w));
        }

        int[][] dis = new int[k+2][n];

        for(int i = 0; i<= k+1; i++){
            Arrays.fill(dis[i] , (int)1e9);
        }

        Queue<Pair> pq = new LinkedList<Pair>();
        pq.offer(new Pair(src, 0, 0));
        dis[0][src] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.first;
            int cost = p.second;
            int step = p.third;
            if(step > k + 1) continue;
            if(cost > dis[step][node]) continue;
            for(Pair1 it : adj.get(node)){
                int next = it.first;
                int distance = it.second;
                if(step < k + 1 && cost + distance < dis[step+1][next]){
                    dis[step+1][next] = cost + distance;
                    pq.offer(new Pair(next, dis[step+1][next], step + 1));
                }
            }
        }
        int ans = (int)1e9;
        for(int i = 0; i<= k+1; i++){
            ans = Math.min(ans, dis[i][dst]);
        }
        return ans == (int)1e9 ? -1 : ans;
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
    class Pair1{
        int first;
        int second;
        Pair1(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}