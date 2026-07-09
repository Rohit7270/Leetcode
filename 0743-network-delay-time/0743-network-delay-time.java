class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis, (int)1e9);
        dis[k] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.second - y.second);
        pq.offer(new Pair(k, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.first;
            int distance = p.second;
            if(distance > dis[node]) continue;
            for(Pair it : adj.get(node)){
                int next = it.first;
                int edgewt = it.second;
                if(distance + edgewt < dis[next]){
                    dis[next] = distance + edgewt;
                    pq.offer(new Pair(next, dis[next]));
                }
            }
        }  

        int ans = 0;
        for(int i = 1; i<= n; i++){
            if(dis[i] == (int) 1e9){
                return -1;                
            }
            ans = Math.max(ans, dis[i]);
        }      
        return ans;
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