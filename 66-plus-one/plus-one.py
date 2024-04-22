class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        n = len(digits)
    
        # Start from the least significant digit
        for i in range(n - 1, -1, -1):
            if digits[i] < 9:
                # If the digit is less than 9, simply increment it and return the digits
                digits[i] += 1
                return digits
            else:
                # If the digit is 9, set it to 0 and continue with the next digit
                digits[i] = 0
        
        # If we are here, it means all digits were 9. Add 1 to the front.
        return [1] + digits