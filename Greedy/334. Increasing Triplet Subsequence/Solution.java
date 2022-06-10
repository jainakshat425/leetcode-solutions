class Solution {
    public boolean increaasingTriplet(int[] nums) {
        int n = nums.length;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++) {
            if( nums[i] <= first ) 
                first = nums[i];
            else if( nums[i] <= second )
                second = nums[i];
            else 
                return true;
        }
        return false;
    }
}
// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         int n = nums.length;
//         boolean[] hasLeftSmaller = new boolean[n];
//         Stack<Integer> stack = new Stack();
        
//         for(int i=0; i<n; i++) {
//             while(!stack.isEmpty() && stack.peek() >= nums[i])
//                 stack.pop();
            
//             hasLeftSmaller[i] = !stack.isEmpty(); 
            
//             stack.push(nums[i]);
//         }
//         stack.clear();
        
//         for(int i=n-1; i>=0; i--) {
            
//             while( !stack.isEmpty() && stack.peek() <= nums[i]) 
//                 stack.pop();
            
//             boolean hasRightGreater = !stack.isEmpty();
            
//             if( hasLeftSmaller[i] && hasRightGreater )
//                 return true;
            
//             stack.push(nums[i]);
//         }
//         return false;
//     }
// }
