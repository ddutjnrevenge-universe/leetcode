class Solution {
    public String removeStars(String s) {
        char [] newString = new char [s.length()];
        int nextIndex = 0;
        for (char c : s.toCharArray()) {
            if (c=='*') {
                if (nextIndex >0) {
                    nextIndex--;
                }
            } else {
                newString[nextIndex] = c;
                nextIndex++;
            }
        }
        return new String(newString, 0, nextIndex);
    }
}