// import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLength = words[0].length(); // Length of each word in the array
        int totalWordsLength = wordLength * words.length; // Total length of all words combined

        HashMap<String, Integer> wordCount = new HashMap<>(); // HashMap to store frequency of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); // Count the frequency of each word
        }

        for (int i = 0; i <= s.length() - totalWordsLength; i++) {
            String subString = s.substring(i, i + totalWordsLength); // Get substring of length equal to totalWordsLength
            if (isConcatenated(subString, wordCount, wordLength)) { // Check if the substring is concatenated
                result.add(i); // If concatenated, add the starting index to result list
            }
        }

        return result;
    }

    private boolean isConcatenated(String s, HashMap<String, Integer> wordCount, int wordLength) {
        HashMap<String, Integer> tempMap = new HashMap<>(); // Temporary map to store frequency of words in substring
        for (int i = 0; i < s.length(); i += wordLength) {
            String word = s.substring(i, i + wordLength); // Extract each word from the substring
            if (!wordCount.containsKey(word)) // Check if the word is present in the wordCount map
                return false;
            tempMap.put(word, tempMap.getOrDefault(word, 0) + 1); // Count the frequency of each word
        }

        return tempMap.equals(wordCount); // Check if frequency of words in substring matches with frequency of words in wordCount
    }
}
