class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ""
        strs.sort()
        # Take the first and last string in the sorted array
        first_str = strs[0]
        last_str = strs[-1]
        
        # Find the common prefix between the first and last string
        prefix = ""
        for i in range(len(first_str)):
            if i < len(last_str) and first_str[i] == last_str[i]:
                prefix += first_str[i]
            else:
                break
        
        return prefix
        