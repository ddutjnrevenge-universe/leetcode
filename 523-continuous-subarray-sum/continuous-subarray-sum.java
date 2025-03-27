class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        int cumulativeSum = 0;
    
        remainderMap.put(0, -1);
    
        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            
            int remainder = k == 0 ? cumulativeSum : cumulativeSum % k;
            
            if (remainderMap.containsKey(remainder)) {

                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
    
        return false;
    }
}