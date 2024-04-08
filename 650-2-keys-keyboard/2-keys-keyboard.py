class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 1:
            return  0
    
        dp = [0] * (n + 1)  # dp[i] represents minimum steps to get 'A' i times on screen
        
        for i in range(2, n + 1):
            dp[i] = i  # initialize with worst case scenario
            
            for j in range(2, i // 2 + 1):
                if i % j == 0:
                    dp[i] = min(dp[i], dp[j] + i // j)
        
        return dp[n]