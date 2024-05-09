class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        counts1 = Counter(nums1)
        counts2 = Counter(nums2)
        intersection = counts1 & counts2
        return list(intersection.elements())
        