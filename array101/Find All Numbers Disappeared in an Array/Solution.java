class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /* 
        Input: nums = [4,3,2,7,8,2,3,1]
        Output: [5,6]
        
        Naive Solution
        1. Create boolean array of length n
        2. iterate over nums
        3. for each num, mark the respective array element true
        4. Add the false indices to the returned list
        Time Complexity = O(n)
        Space Complexity = O(n) for Boolean array (Not considering List<Integer> to be returned)
        */
        
        /*
        Solution 2
        1. Add elements 1 to nums.length to the set.
        2. iterate over nums
        3. for each num, remove the element from set
        4. return list from set
        
        Set<Integer> missingNumbers = new HashSet<Integer>();
        
        for(int i=1; i<=nums.length; i++) {
            missingNumbers.add( i );
        }
        
        for(int num : nums) {
            missingNumbers.remove( num );
        }
        
        return new ArrayList<Integer>(missingNumbers);
        */
        
        /*
        Solution 3 - Better Solution
        1. For each number {nums[i]}, check if number is not at it's correct index position.
        2. If not
            - Get the correct index {actualIndex} position for current number.
            - If number at current index {i} equals number at correct index, no need to swap.
            - else swap the number to actualIndex position.
        4. in this way we will have 1 at 0th index, 2 at 1st index, 3 at 2nd index and so on...
        5. iterate over rearranged elems, check if current value at it's correct index position.
        6. if yes, elem is in list. otherwise add it to missing numbers list.
        */
        int i=0;
        
        while( i<nums.length ) {
            
            // For each number {nums[i]}, check if number is not at it's correct index position.
            if( nums[i] != (i+1) ) {
                
                // Get the correct index {actualIndex} position for current number.
                int actualIndex = nums[i]-1;
                
                if( nums[i] != nums[actualIndex] ) {
                    
                    // else swap the number to actualIndex position.
                    int temp = nums[i];
                    nums[i] = nums[actualIndex];
                    nums[actualIndex] = temp;
                } else {
                    // If number at current index {i} equals number at correct index, no need to swap.
                    i++;
                }
            } else {
                i++;
            }
        }
        
        List<Integer> missingNumbers = new ArrayList<Integer>();
        
        // iterate over rearranged elems, check if current value at it's correct index position.
        for(int k=0; k<nums.length; k++) {
            
            if( nums[k] != (k+1) ) {
                // if yes, elem is in list. otherwise add it to missing numbers list.
                missingNumbers.add( (k+1) );
            }
        }
        return missingNumbers;
    }
}
