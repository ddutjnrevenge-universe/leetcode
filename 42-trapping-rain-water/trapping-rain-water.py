class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        i, j = 0, len(height)-1
        left_max, right_max = height[i], height[j]
        res = 0
        while i<j:
            left_max = max(left_max,height[i])
            right_max = max(right_max,height[j])
            if left_max<right_max:
                res+= left_max-height[i]
                i+=1
            else:
                res+= right_max-height[j]
                j-=1
        return res