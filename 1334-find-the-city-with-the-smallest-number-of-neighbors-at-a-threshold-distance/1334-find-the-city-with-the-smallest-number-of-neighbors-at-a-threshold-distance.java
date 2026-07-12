class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        int max = n;
        int cityno = -1;

        for(int src = 0; src< n; src++){
            int[] dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[src] = 0;

            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.second - b.second);
            pq.offer(new Pair(src, 0));

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
            int cnt = 0;
            for(int i = 0; i< n; i++){
                if(dis[i] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= max){
                max = cnt;
                cityno = src;
            }
        }
        
        return cityno;
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