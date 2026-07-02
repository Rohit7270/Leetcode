class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] arr = new int[numCourses];

        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            arr[u]++;
        }

        int[] topo = new int[numCourses];
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<numCourses; i++){
            if(arr[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topo[cnt++] = node;

            for(int it : adj.get(node)){
                arr[it]--;
                if(arr[it] == 0){
                    q.offer(it);
                }
            }
        }
        if(cnt == numCourses) return topo;
        int[] ans = {};
        return ans;
    }
}