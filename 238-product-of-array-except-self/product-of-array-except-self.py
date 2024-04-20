class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
    
        # Initialize left product array
        answer = [1] * n
        
        # Compute left product array and answer array in the same loop
        for i in range(1, n):
            answer[i] = answer[i - 1] * nums[i - 1]
        
        # Initialize a variable to keep track of the product of elements to the right
        right_product = 1
        
        # Compute answer array using right_product and update right_product on-the-fly
        for i in range(n - 1, -1, -1):
            answer[i] *= right_product
            right_product *= nums[i]
        
        return answer
