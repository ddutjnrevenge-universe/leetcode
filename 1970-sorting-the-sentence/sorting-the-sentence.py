class Solution(object):
    def sortSentence(self, s):
        """
        :type s: str
        :rtype: str
        """
        s=s.split()
        # Sort the words based on the appended index numbers
        sorted_s = sorted(s, key=lambda x: int(x[-1]))
        
        # Remove the index numbers and join the s to form the original sentence
        original_sentence = ' '.join(word[:-1] for word in sorted_s)
        
        return original_sentence