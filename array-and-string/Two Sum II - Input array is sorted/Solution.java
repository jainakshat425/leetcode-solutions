class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
        1. Two Pointers Approach
            - {left} - pointing to the start of the array.
            - {right} - pointing to the end of the array
        2. Iterate while left less than right
            - store the sum of numbers pointed by {left} and {right} pointers into {sum}.
            - if sum equals target, return current {left} and {right}.
            - else if {sum} > {target}, decrement {right} pointer.
            - else ({sum} < {target}), increment left.
        */
        
        
        // Two Pointers Approach
        //     - {left} - pointing to the start of the array.
        //     - {right} - pointing to the end of the array
        int left = 0, right = numbers.length-1;
        int sum;
        
        // Iterate while left less than right
        while( left < right ) {
            
            // store the sum of numbers pointed by {left} and {right} pointers into {sum}.
            sum = numbers[left] + numbers[right];
            
            // if sum equals target, return current {left} and {right}.
            if( sum == target ) {
                return new int[]{left+1, right+1};
            } else if( sum > target ) {
                
                // else if {sum} > {target}, decrement {right} pointer.
                --right;
            } else {
                
                // else ({sum} < {target}), increment left.
                ++left;
            }
        }
        
        return new int[]{-1, -1};
    }
}
