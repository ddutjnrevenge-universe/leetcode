class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int num : arr) {
            occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1);
        }
        
        // Check if the number of occurrences is unique
        Set<Integer> occurrenceSet = new HashSet<>();
        for (int occurrence : occurrenceMap.values()) {
            if (!occurrenceSet.add(occurrence)) {
                return false; // Duplicate occurrence found
            }
        }
        
        return true;
    }
}