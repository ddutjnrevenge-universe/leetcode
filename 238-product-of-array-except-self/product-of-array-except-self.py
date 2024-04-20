class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
    
        # Initialize left and right product arrays
        left = [1] * n
        right = [1] * n
        
        # Compute left product array
        for i in range(1, n):
            left[i] = left[i - 1] * nums[i - 1]
        print(left)
        
        # Compute right product array
        for i in range(n - 2, -1, -1):
            right[i] = right[i + 1] * nums[i + 1]
        print(right)
        # Compute answer array
        answer = [left[i] * right[i] for i in range(n)]
        
        return answer
            