class Solution {
    public int findDuplicate(int[] nums) {
        // Return -1 if there is only one element in the array
        if( nums.length < 2 ) {
            return -1;
        }
        
        // This problem is similar to finding the start of a cycle in a linked list 
        // Slow pointer will move one step and fast pointer will move two steps
        int slow = 0;
        int fast = 0;
        
        // Repeat the slow and fast pointer till they eventually meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while( slow != fast );
            
        // Move the {fast} pointer to start while {slow} is pointing to pointing of intersection
        fast = 0;
        
        // Move slow and fast one step at time until they meet, which will be start of the cycle (duplicate element)
        while( slow != fast ) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
