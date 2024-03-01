class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        // Append remaining characters from word1 if any
        while (i < word1.length()) {
            result.append(word1.charAt(i++));
        }

        // Append remaining characters from word2 if any
        while (j < word2.length()) {
            result.append(word2.charAt(j++));
        }

        return result.toString();
    }
};