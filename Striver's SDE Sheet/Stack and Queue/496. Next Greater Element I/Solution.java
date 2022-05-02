class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int[] ans = new int[n1];
        
        // To hold the numbers in the right which can be greater than current number
        Stack<Integer> stack = new Stack<>();
        
        // To store the mapping of number with it's greater number in right
        Map<Integer,Integer> greaterInRight = new HashMap<>();
        
        // Iterate from last number to the first number
        for(int i=n2-1; i>=0; i--) {
            
            // Remove numbers from top of the stack until a greater number is found
            while( !stack.isEmpty() && stack.peek() < nums2[i] ) {
                stack.pop();
            }
            
            /* If a stack is not empty, then the top of the stack contains the greater
            number than current number, else there is no number in right which is 
            greater than current number */
            greaterInRight.put(nums2[i], stack.isEmpty() ? -1 : stack.peek() );
            
            /* Push current number into stack, as this number can be greater number
            for the numbers in left */
            stack.push( nums2[i] );
        }
        
        // Use the map to get the number in right greater than each number in {nums1}
        for(int i=0; i<n1; i++) {
            ans[i] = greaterInRight.get( nums1[i] );
        }
        
        return ans;
    }
}
