class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<=1:
            return 0
        dp = [0] * (n + 1)

        for i in range(2, n + 1):
            dp[i] = i  # At worst, we would copy 'A' once and then paste it i-1 times
            for j in range(2, i):
                if i % j == 0:
                    dp[i] = min(dp[i], dp[j] + (i // j))  # If i is divisible by j, we can paste j times
        return dp[n]