class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (char c : s.toCharArray()) {
            sb.append(c);
        }

        sb.reverse();

        if (sb.toString().equals(s)) {
            return true;
        }

        return false;
    }
}