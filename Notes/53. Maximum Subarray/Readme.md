https://leetcode.com/problems/maximum-subarray/

Kadane's Algo
        
        1. If all the numbers were positive, the largest sum will be the sum of whole array nums
        2. If the curr subarray sum is negative
            - discard the curr subarray as it will always minimize the sum.
        3. Create two vars - sum and max, intialized to first num (as ans should contains atleast 1 num)
        4. Iterate from second num
            - Add curr num to sum
            - Update max, if curr sum is greater than max
            - If curr sum is negative
                - discard curr subarr and set the sum to 0
                
        Time comp - n
        Space Comp - 1
        
