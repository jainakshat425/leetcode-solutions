class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack();
        int[] min = new int[n];
        min[0] = nums[0];
          
        // Store minimum number till current index 
        for(int i=1; i<n; i++) {
            min[i] = Math.min( min[i-1], nums[i]);
        }
        
        // Iterate from the end of the array
        for(int j=n-1; j>=1; j--) {
            
            if( min[j] < nums[j] ) {
                
                /* Get the number in right from j which is greater than minimum number
                in the left */
                while( !stack.isEmpty() && stack.peek() <= min[j] ) {
                    stack.pop();
                }
                
                // Check if number in right is less than number at j
                if( !stack.isEmpty() && stack.peek() < nums[j] ) {
                    return true;
                }
            }
            stack.push(nums[j]);
        }
        return false;
    }
}
/*
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++) {
            
            for(int j=i+1; j<n; j++) {
                
                if( nums[i] < nums[j] ) {
                    for(int k=j+1; k<n; k++) {

                        if( nums[i] < nums[k] && nums[k] < nums[j] ) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}*/
