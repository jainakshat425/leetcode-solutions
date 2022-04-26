class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
		
		// Need atleast 3 bars to trap the water
        if( n < 3 ) {
            return 0;
        }
        
        int left = 0;
        int right = n-1;
        
        // Store maximum bar height from the start till the {left} pointer
        int leftMax = height[left];
        
        // Store maximum bar height from the end till the {right} pointer
        int rightMax = height[right];
        
        int total = 0;
        
        while( left < right ) {
            int trapped = 0;
            
            /* If the bar to the right of the current position is smaller
            than maximum height bar in the left, than water trapped at 
            current position will be determined by maximum height bar in the right */
            if( rightMax < leftMax ) {
                
                /* Updating right before performing operations as we don't
                need to check for the last position, it will be always 0 */
                right--;
                
                /* If there is no bar in the right with more height than current
                position then no water can be trapped at this position, also 
                update the maximum height in the right till this point */
                if( height[right] > rightMax ) {
                    rightMax = height[right];
                } else {
                    total += rightMax - height[right];
                }
            } else {
                
                /* Updating left before performing operations as we don't
                need to check for the first position, it will be always 0 */
                left++;
                
                /* If there is no bar in the left with more height than current
                position then no water can be trapped at this position, also 
                update the maximum height in the left till this point */
                if( height[left] > leftMax ) {
                    leftMax = height[left];
                } else {
                    total += leftMax - height[left];
                }
            }
        }
        
        return total;
    }
}
