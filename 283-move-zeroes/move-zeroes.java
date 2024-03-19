class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int nonZeroIndex =0; // initalize a variable for the nonzero elem index
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=0) {
                // Swap non-zero element with the element at nonZeroIndex
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }
    }
}