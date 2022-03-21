class Solution {
    public void rotate(int[] nums, int k) {

        /* 
        1. It might be possible that we would have to perform more than {nums.length} rotation,
        but all the the {nums.length} rotation are useless as they will keep generating initial array
        again. So take modulus of {k} by {nums.length}.
        2. Reverse the complete array.
        3. Reverse the first {k} elements, these are the elements which will be removed when a array is shifted {k} times right.
        4. Reverse the element after the first {k} element.
        */
        
        /* It might be possible that we would have to perform more than {nums.length} rotation,
        but all the the {nums.length} rotation are useless as they will keep generating initial array
        again. So take modulus of {k} by {nums.length}. */
        k = k % nums.length;
        
        // Reverse the complete array.
        reverse(nums, 0, nums.length-1);
        
        // Reverse the first {k} elements, these are the elements which will be removed when a array is shifted {k} times right.
        reverse(nums, 0, k-1);
        
        // Reverse the element after the first {k} element.
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        
        while(start < end ) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
}
    
