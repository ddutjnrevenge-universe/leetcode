class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices)<2:
            return 0
        min_price = prices[0]
        max_profit=0
        for i in range(1,len(prices)):
            min_price = min(min_price,prices[i])
            profit=prices[i]-min_price
            max_profit=max(profit,max_profit)
        return max_profit


        