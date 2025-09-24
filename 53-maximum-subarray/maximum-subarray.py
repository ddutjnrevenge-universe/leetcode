class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        def maxCrossingSum(nums, left, mid, right):
                # Calculate the maximum sum on the left of mid
                left_sum = float('-inf')
                total = 0
                for i in range(mid, left - 1, -1):
                    total += nums[i]
                    left_sum = max(left_sum, total)
                
                # Calculate the maximum sum on the right of mid
                right_sum = float('-inf')
                total = 0
                for i in range(mid + 1, right + 1):
                    total += nums[i]
                    right_sum = max(right_sum, total)
                
                # Return the sum of both parts
                return left_sum + right_sum
            
        # Helper function to implement divide and conquer
        def maxSubArraySum(nums, left, right):
            if left == right:  # Base case: only one element
                return nums[left]
            
            # Find the middle index
            mid = (left + right) // 2
            
            # Find the maximum subarray sum in the left half, right half, and crossing the middle
            left_sum = maxSubArraySum(nums, left, mid)
            right_sum = maxSubArraySum(nums, mid + 1, right)
            crossing_sum = maxCrossingSum(nums, left, mid, right)
            
            # Return the maximum of the three sums
            return max(left_sum, right_sum, crossing_sum)
        
        # Call the helper function for the entire array
        return maxSubArraySum(nums, 0, len(nums) - 1)