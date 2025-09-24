class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def helper(nums,left,right):
            if left==right:
                return nums[left]
            mid=(left+right)//2
            left_maj = helper(nums,left,mid)
            right_maj = helper(nums,mid+1,right)

            if left_maj == right_maj: 
                return left_maj
            left_count=right_count=0
            for i in range(left,right+1):
                if nums[i]==left_maj:
                    left_count+=1
                if nums[i]==right_maj:
                    right_count+=1

            if left_count > (right-left+1)//2:
                return left_maj
            elif right_count > (right-left+1)//2:
                return right_maj
            else:
                return None
        return helper(nums,0,len(nums)-1)
        