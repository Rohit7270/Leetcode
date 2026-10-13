class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, ans, 0, 0,new ArrayList<>());
        return ans;
    }
    public void helper(int[] arr, int target, List<List<Integer>> res, int index, int sum, List<Integer> ds){
        if(sum > target) return;
        if(index == arr.length){
            if(sum == target){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(arr[index]);
        sum += arr[index];
        helper(arr, target, res, index, sum, ds);
        ds.remove(ds.size() -1);
        sum -= arr[index];
        helper(arr, target, res, index+1, sum, ds);
    }
}