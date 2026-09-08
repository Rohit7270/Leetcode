class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int left = height[0];
        int right = height[n-1];
        int i = 0;
        int j = n-1;
        while(i < j){
            if(height[i] <= height[j]){
                if(height[i] > left){
                    left = height[i];
                }
                else{
                    total += left - height[i];
                }
                i++;
            }
            else{
                if(height[j] > right){
                    right = height[j];
                }
                else{
                    total += right - height[j];
                }
                j--;
            }
        }
        return total;
    }
}