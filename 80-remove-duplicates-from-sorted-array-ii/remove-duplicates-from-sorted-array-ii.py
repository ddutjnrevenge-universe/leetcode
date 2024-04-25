class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        count =1
        pointer = 1
        for i in range(1,len(nums)):
            if nums[i]==nums[i-1]:
                count+=1
            else:
                count =1
            if count <=2:
                nums[pointer]=nums[i]
                pointer+=1

        return pointer