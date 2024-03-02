class Solution {
    public String reverseVowels(String s) {
        if (s==null|s.length()==0) {
            return s;
        }
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        StringBuffer sb = new StringBuffer(s);

        int last = sb.length() - 1;
        int i=0;
        int j=last;
        while (i<j) {
            while (i<last && !vowels.contains(sb.charAt(i)))
                i++;
            while (j>0 && !vowels.contains(sb.charAt(j)))
                j--;
            
            if (i<j && vowels.contains(sb.charAt(i)) && vowels.contains(sb.charAt(j))) {
                char letter = sb.charAt(j);
                sb.setCharAt(j, sb.charAt(i));
                sb.setCharAt(i, letter);
                j--;
                i++;
            }
        }
        return sb.toString();
    }
}