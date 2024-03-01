class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz", // 9
            "", // *
            "" //#
        };
        
        backtrack(result, digits, mapping, new StringBuilder(), 0);
        return result;
    };
    
    private void backtrack(List<String> result, String digits, String[] mapping, StringBuilder combination, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(result, digits, mapping, combination, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
};