class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)

    # Step 1: Mark the presence of positive integers
        for i in range(n):
            while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]

        # Step 2: Find the smallest positive integer that is missing
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1

        # If no missing positive integer found, return the next positive integer
        return n + 1
