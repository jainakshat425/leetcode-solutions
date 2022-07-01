https://leetcode.com/problems/find-the-duplicate-number/

        1. Using hashset
        
        - Declare hashset to store seen nums
        - Iterate over nums
            - Check if num already exist in hashset
                - if yes, return curr num
            - Add num to hashset
            
        Time - n
        Space - n
        
        2. Using Fast & Slot Poitner Approach
        
        - Since max num can be n in the array of size n+1
            - Each num can treated as an index of the same array
        - Declare fast and slow pointer, pointing to index 0
        - Repeat till the index slow and fast in not pointing to the same index
            - Move slow pointer to the next index
            - Move fast pointer to the next of the next index
        - Move fast pointer again to the first index
        - Repeat while slow and fast are not equal
            - Move both pointer to the next index
            
        Time - 2n
        Space - n
        
        Proof - 
        
        If a value is repeated, the duplicate value will create a cycle
        
        1 3 4 2 2 
        
        0 -> 1 -> 3 -> 2 -> 4 -> 2 (Cycle found)
        
        The cycle is starting at index 2
        
        Since fast pointer is traversing at 2x speed than slow, and since there is a cycle
        they will eventually meet at some point a in the their path
        
        Let 
        F be distance from the initial position to the start of the cycle
        a be the distance from the start of the cycle to point of intersection
        C be length of the cycle
        
        And the traverse at 2x speed than slow, so distance travelled by fast is 2x of slow
        
        dist(Fast) = 2 * dist(Slow)
        F + C + a = 2(F+a) 
        F + a = C          ------- eq1
        
        Now if we reset fast to initial position move one step at a time now
        until it reaches F and slow will also move F steps from a
        
        Fast moves F step to reach F from 0
        Slow moves F step to start of the cycle from a - because a + F is C from eq1
       
        Since slow and fast meets at F, it's the start of cycle
