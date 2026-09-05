class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> hash = new HashMap<>();
        hash.put(0,1);
        int cnt = 0;
        int prefix = 0;
        for(int i = 0; i< nums.length; i++){
            prefix += nums[i];
            int rem = prefix-k;
            cnt += hash.getOrDefault(rem, 0);
            hash.put(prefix, hash.getOrDefault(prefix, 0)+ 1);
        }
        return cnt;
    }
}