https://leetcode.com/problems/merge-sorted-array/

        1. Merge Sort's Merge Function
        
        - Clone the nums1 into arr1
        - Apply merge on arr1 and nums2 and result will be stored in nums1 itself.
        
        Time - m + (m + n)
        Space - m
        
        2. Merge with insertion sort
        
        - Create two pointer i and j, pointing to start indices of nums1 and nums2
        - Repeat until there are nums left in both the arrays
            - if nums2[j] < nums1[i]
                - swap the nums
                - use insertion sort to move the new num in nums2 to correct position
                
        Time - mn
        Space - 1
        
        3. Merge Sort's Merge from End
        
        - Keep merging the array from the end, when both the arrays have nums left
        - If nums1 exhausted before nums1, copy remaining nums2 to nums1
        
        Time - m+n
        Space - 1
