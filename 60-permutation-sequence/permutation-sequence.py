class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        factorial = [1] * n
        nums = [str(i) for i in range(1, n + 1)]

        # Calculate factorial
        for i in range(1, n):
            factorial[i] = factorial[i - 1] * i

        k -= 1
        result = []

        # Calculate the permutation
        for i in range(n, 0, -1):
            index = k // factorial[i - 1]
            k %= factorial[i - 1]
            result.append(nums[index])
            nums.pop(index)

        return ''.join(result)