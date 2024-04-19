class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        def factorial(num):
            result = 1
            for i in range(1, num + 1):
                result *= i
            return result

        def generate(nums, k):
            if not nums:
                return ""
            
            # Calculate factorial of n-1
            fact = factorial(len(nums) - 1)
            
            # Find index of current digit
            index = (k - 1) // fact
            
            # Update k
            k = k - index * fact
            
            # Add current digit to result and remove from nums
            num = nums[index]
            nums.remove(num)
            
            return num + generate(nums, k)

        nums = [str(i) for i in range(1, n + 1)]
        return generate(nums, k)