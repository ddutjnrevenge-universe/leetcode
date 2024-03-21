class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        sum = {}
        for i,j in enumerate(nums): 
            complement = target - j

            if complement in sum:
                    return [sum[complement],i]
            sum[j]=i
        return []
        # # another solution
        # for i in range(len(nums)):
        #     for j in range(i+1,len(nums)):
        #         if (nums[i]+nums[j] == target):
        #             return [i,j]
        # return []
