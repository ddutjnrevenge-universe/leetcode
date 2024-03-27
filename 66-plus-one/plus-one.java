class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            digits[i]++;
            // If the digit becomes less than 10 after incrementing, no carry, so return digits
            if (digits[i] < 10) {
                return digits;
            } else {
                // If there's a carry, set the current digit to 0 and continue with the loop
                digits[i] = 0;
            }
        }

        // If we reach here, it means there's a carry in the most significant digit
        // So, we need to create a new array with an additional digit
        int[] result = new int[n + 1];
        result[0] = 1; // Set the most significant digit to 1
        return result;
    }
}