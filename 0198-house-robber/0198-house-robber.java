class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev1 = 0;
        for(int i= 1; i< n; i++){
            int take = nums[i];
            if(i > 1){
                take += prev1;
            }
            int nottake = prev;
            int curr = Math.max(take, nottake);
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}