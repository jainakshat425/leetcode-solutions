https://leetcode.com/problems/rotate-image/

        1. Two pass approach - Easy
        
        - Transpose matrix > a[i][j] = a[j][i]
        - Reverse each row
        
        2. One pass approach
        
        - Required rotation 
        
        TopLeft -> TopRight -> BottomRight -> BottomLeft -> TopLeft
        
        - This rotation will require back up of each cell before copying the value from another cell
        - Instead backup cell TopLeft, and perform rotation like this
        
        TopLeft <- BottomLeft <- BottomRight <- TopRight <- TopLeft <- Backup Value
        
        - This will prevent backup of each cell, and we would only need to backup TopLeft.
        - Create four pointers - left, right, top, bottom - to mark boundary row/cols of shrinked matrix.
        - Perform rotation for n-1 cells in the left to right range.
