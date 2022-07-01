https://leetcode.com/problems/next-permutation/

        1. Find the index of pivot number of end
            - Pivot number is the one which is greater than the next number
            - All the nums after pivot are sorted in non-increasing order
        2. If pivot not found, all the nums are sorted in non-increasing order
            - That means, current permutation is already the highest permutation
            - Reverse the current permutation and return the answer
        3. Swaping the pivot num with any number in the right, will generate a higher permutation
        4. Find the least greater element from the pivot num from the end and swap pivot with it.
        5. A new permutation is generated, but it's not the minimum permutation.
            - To make it minimum, reverse the nums after the pivot index
        6. Return the answer
        
        Time comp - n + n + n
        Space comp - 1
