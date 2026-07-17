class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1]; 
        for(int i = 0; i< n; i++){
            if(i != 0) arr1[i-1] = nums[i];
            if(i != n-1) arr2[i] = nums[i];
        }
        return Math.max(house(arr1), house(arr2));
    }
    private int house(int[] arr){
        int n = arr.length;
        int prev = arr[0];
        int prev1 = 0;
        for(int i = 1; i< n; i++){
            int take = arr[i];
            if(n > 1){
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