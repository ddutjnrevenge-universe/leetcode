class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """

        count = {}
        
        for i in s:
            if i in count:
                count[i] +=1
            else:
                count[i] = 1
        for x, i in enumerate(s): 
            if count[i] ==1:
                return s.index(i)
        return -1
           