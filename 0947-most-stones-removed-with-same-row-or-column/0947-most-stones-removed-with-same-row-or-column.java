class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int[] edge : stones){
            maxRow = Math.max(maxRow, edge[0]);
            maxCol = Math.max(maxCol, edge[1]);
        }

        Disjointset ds = new Disjointset(maxRow + maxCol + 2);
        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = 0;
        for(int[] edge : stones){
            int row = edge[0];
            int col = edge[1] + maxRow + 1;
            ds.UnionBySize(row, col);
            hash.put(row, 1);
            hash.put(col, 1);
            n++;
        }
        int cnt = 0;
        for(int node : hash.keySet()){
            if(ds.findUParent(node) == node){
                cnt++;
            }
        }
        return n- cnt;
    }
}
class Disjointset{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public Disjointset(int n){
        for(int i = 0; i< n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void UnionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v)
            return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}