class Solution {
    public int findPeakElement(int[] nums) {
        // int i =0;
        // int peak=nums[i];
        int peak = 0;
        for (int i=1; i<nums.length;i++) {
            if (nums[i]>nums[peak]) {
                peak = i;
            } 
        }
        return peak;
    }
}