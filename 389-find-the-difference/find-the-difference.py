class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        count = collections.Counter(s)

        for c in t:
            if count[c] == 0:
                return c
            count[c] -= 1