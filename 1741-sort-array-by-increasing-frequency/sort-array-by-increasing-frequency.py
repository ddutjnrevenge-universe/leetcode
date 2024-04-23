class Solution(object):
    def frequencySort(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1
        
        # Sort the numbers based on frequency and value
        sorted_nums = sorted(nums, key=lambda x: (freq[x], -x))
        
        return sorted_nums