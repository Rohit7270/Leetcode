class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] arr = new int[graph.length];
        Arrays.fill(arr, -1);
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == -1){
                if(!dfs(graph, arr, i, 0)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] arr, int node, int col){
        arr[node] = col;

        for(int it : graph[node]){
            if(arr[it] == -1){
                if(!dfs(graph, arr, it, 1- col)){
                    return false;
                }
            }
            else if(arr[it] == arr[node]){
                return false;
            }
        }
        return true;
    }
}