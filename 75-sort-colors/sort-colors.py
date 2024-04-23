class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
     # Initialize pointers for red, white, and blue sections
        red, white, blue = 0, 0, len(nums) - 1
        
        while white <= blue:
            if nums[white] == 0:
                # Swap red and white elements
                nums[red], nums[white] = nums[white], nums[red]
                # Move red and white pointers forward
                red += 1
                white += 1
            elif nums[white] == 1:
                # Move white pointer forward
                white += 1
            else:
                # Swap white and blue elements
                nums[white], nums[blue] = nums[blue], nums[white]
                # Move blue pointer backward
                blue -= 1