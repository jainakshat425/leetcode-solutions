https://leetcode.com/problems/merge-intervals/

        - Two intervals overlap when next interval starts before current interval ends.
        - Sort intervals in increasing order of their start value
        - Create list to store merged intervals. 
        - Create pointer prev to point to the last interval add to the list.
        - Add first interval to list and make prev point to first interval
        - Iterate from second interval
            - If curr interval starts before prev interval ends 
                - Set the end of prev interval to the max of (prevEnd, currEnd)
            - else, add curr interval to the list and update prev to curr
