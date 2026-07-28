class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i< n; i++) totalSum += nums[i];
        if((totalSum % 2) == 1) return false;
        return isSubsetSum(nums, totalSum/2);
    }
    boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[] prev = new boolean[sum+1];
        prev[0] = true;
        if(arr[0] <= sum){
            prev[arr[0]] = true;
        }
        for(int index = 1; index < n; index++){
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int target = 1; target <= sum; target++){
                boolean nottake = prev[target];
                boolean take = false;
                if(arr[index] <= target){
                    take = prev[target-arr[index]];
                }
                curr[target] = take || nottake;
            }
            prev = curr;
        }
        return prev[sum];
    }
}