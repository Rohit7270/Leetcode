class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for(int i = 0 ;i < V; i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i< V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }    

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        } 
        Collections.sort(ans);
        return ans;   
    }
}