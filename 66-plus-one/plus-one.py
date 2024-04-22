class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        n = len(digits)
    
        # Initialize carry to 1 for the addition
        carry = 1
        result = []
        
        # Traverse the digits in reverse order
        for i in range(n - 1, -1, -1):
            total = digits[i] + carry
            
            # Update the carry
            carry = total // 10
            
            # Update the current digit
            result.insert(0, total % 10)
        
        # If there's a remaining carry, add it to the front
        if carry:
            result.insert(0, carry)
        
        return result
