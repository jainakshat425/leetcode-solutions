https://leetcode.com/problems/sort-colors/

Dutch National Flag Algo - Two pointers 
        
        1. Create pointers pointing to the index where next 0 and 2 needs to placed
        2. Iterate through num 0 to last non-2 index
            - If curr num is 0, swap it with value at zero pointer
            - else If curr num is 2, swap it with value at two pointer
            - else move i to next index
            
        Time - 2n
        Space - 1
