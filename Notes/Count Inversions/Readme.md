https://www.codingninjas.com/codestudio/problems/count-inversions_615

Modified Merge Sort Approach
        
        1. Write mergeSort and merge logic.
        2. Modify the mergeSort function - 
            - Get the count from the left and right half mergeSort call
            - Sum it with the inversions found in the merge of left and right half
            - return the sum
        3. Modify the merge function - 
            - Before merging the sorted left and right half
            - Iterate through nums in left half
                - If the left_num is greater than right_num
                    - all the nums from left_num in left half will be greater than right_num
                    - Add to sum the count of nums from current num in left half.
                    - Move to next num in right half only
                - else, move to the next num in left half only
            - Perform the merge and return the sum
            
        Time - nlogn
        Space - n
