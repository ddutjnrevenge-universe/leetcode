class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer =0; //pointer in string s
        int tPointer=0; //pointer in string t
        while(sPointer<s.length() && tPointer <t.length()) { //iterate over the two string
            if (s.charAt(sPointer) == t.charAt(tPointer)) { //check if character in s also exists in t)
                sPointer++;
            }
            tPointer++;
        }
        return sPointer == s.length(); //at the end the sPointer would reach the length of string s if the entire string s is a subsequence of string t
    }
}
