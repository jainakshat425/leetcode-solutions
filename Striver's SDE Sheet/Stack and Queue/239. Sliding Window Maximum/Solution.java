class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ansSize = n-k+1;
        int[] ans = new int[ansSize];
        Deque<Integer> deque = new LinkedList<>();  
            
        for(int right=0; right<n; right++) {
            
            // Remove the indexes before the left of sliding window (left is right-k+1)
            if( !deque.isEmpty() && deque.peekFirst() == right-k ) {
                deque.pollFirst();
            }
            
            /* Remove the numbers which are not greater than current number, as these
            numbers can't be maximum in current window */
            while( !deque.isEmpty() && nums[deque.peekLast()] <= nums[right] ) {
                deque.pollLast();
            }
            
            // Add the current number to the deque
            deque.offerLast( right );
            
            // If right has crossed the end of first window
            if( right >= k-1 ) {
                // calculate index of window start
                int left = right - k + 1;
                // head of the deque points the maximum number in current window
                ans[left] = nums[deque.peekFirst()];
            }
        }
        
        return ans;
    }
}
/*
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int resultSize = n-k+1;
        int[] result = new int[resultSize];
        int maxIndex = -1;
        
        for(int left=0; left<resultSize; left++) {
            
            int right = left + k -1;
            
            if( maxIndex != -1 && nums[maxIndex] <= nums[right] ) {
                
                result[left] = nums[right];
                maxIndex = right;
                
            } else {
                result[left] = nums[left];
                maxIndex = left;
                
                for(int i=left+1; i<=right; i++) {
                    if( nums[i] >= result[left] ) {
                        result[left] = nums[i];
                        maxIndex = i;
                    }
                }
            }
        }
        
        return result;
    }
}
*/
