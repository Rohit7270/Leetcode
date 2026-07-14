class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjointset ds = new Disjointset(n);
        int cnt = 0;
        for(int[] it : connections){
            int u = it[0];
            int v = it[1];

            if(ds.findUParent(u) == ds.findUParent(v)){
                cnt++;
            }
            else{
                ds.UnionSet(u, v);
            }
        }
        int noc = 0;
        for(int i = 0; i< n; i++){
            if(ds.findUParent(i) == i) noc++;
        }
        if((noc-1) <= cnt){
            return noc-1;
        }
        else{
            return -1;
        }
    }
}
class Disjointset{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public Disjointset(int n){
        for(int i = 0; i< n; i++){
            size.add(1);
            parent.add(i);
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
    public void UnionSet(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}