class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        def search(nums, target, left, right):
            if left == right:
                return left if nums[left] >= target else left + 1

            mid = left + (right - left) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                return search(nums, target, mid + 1, right)
            else:
                return search(nums, target, left, mid)

        return search(nums, target, 0, len(nums) - 1)