https://leetcode.com/problems/set-matrix-zeroes/

1st Approach
1. Create one additional {row} and {col}
2. Iterate over each cell
    - If the current cell is 0
        - Mark the respective row and col in the {row} & {col} as 0.
3. Iterate over the matrix again
    - if current cell's col or row is marked as 0 in {row} or {col}
        - set the curr cell to 0

Time Comp = m+n + m*n + m*n

Space comp = m + n

2nd Approach
1. Treat first row and first col themselves as the additional row and col
2. But since the very first cell is included in both first row and first col
    - Create a extra flag which will be set if the first row needs to marked 0
3. Iterate over each cell
    - If the current cell is 0
        - Set the corresponding cell in first col as 0
        - If row is 0
            - set the flag {firstRowZero} to true
        - else, set corresponding cell in the first row 0
4. Iterate over each cell from the end of the matrix
    - if the row index is 0
        - if {firstRowZero} is 0, mark the current cell 0
    - if current cell's corresponding first col or row is marked as 0
        - set the curr cell to 0

Time Comp = m*n + m*n

Space comp = 1
