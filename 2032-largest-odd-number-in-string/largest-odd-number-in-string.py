class Solution(object):
    def largestOddNumber(self, num):
        """
        :type num: str
        :rtype: str
        """
        # while i<len(num):
        for i in range(len(num) - 1, -1, -1):
            if int(num[i]) % 2 != 0:
                return num[:i+1]
        return ""