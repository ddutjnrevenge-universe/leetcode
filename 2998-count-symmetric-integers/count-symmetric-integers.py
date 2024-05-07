class Solution(object):
    def countSymmetricIntegers(self, low, high):
        """
        :type low: int
        :type high: int
        :rtype: int
        """
        count = 0
        for num in range(low, high + 1):
            if is_symmetric(num):
                count += 1
        return count
def is_symmetric(num):
    num_str = str(num)
    n = len(num_str)
    if n % 2 != 0:
        return False  # Odd number of digits are never symmetric
    
    half = n // 2
    first_half_sum = sum(int(digit) for digit in num_str[:half])
    second_half_sum = sum(int(digit) for digit in num_str[half:])
    
    return first_half_sum == second_half_sum

    