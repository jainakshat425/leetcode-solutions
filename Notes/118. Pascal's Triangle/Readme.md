https://leetcode.com/problems/pascals-triangle/

 1. Bottom up
        
        - Iterate from row 1 to n using i
            - Create a list of size of the curr row
            - Iterate for each cell in curr row using j
                - if i == 0 || j == 0 || i == j
                    - set the curr cell value to 1
                - set value to prevRow[j-1] + prevRow[j]
