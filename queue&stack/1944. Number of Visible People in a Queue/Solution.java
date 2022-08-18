class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack();
        int[] ans = new int[n];
        
        for(int i=n-1; i>=0; i--) {
            
            while( !stack.isEmpty() && stack.peek() < heights[i] ) {
                ans[i] += 1;
                stack.pop();
            }
            
            if( !stack.isEmpty() )
                ans[i] += 1;
            
            stack.push(heights[i]);
        }
        return ans;
    }
}
// class Solution {
//     public int[] canSeePersonsCount(int[] heights) {
//         int n = heights.length;
//         int[] ans = new int[n];
        
//         for(int i=0; i<n; i++) {
//             int max = 0;
//             for(int j=i+1; j<n; j++) {
                
//                 if( heights[j] > heights[i] || heights[j] > max ) {
//                     ans[i]++;
//                     max = heights[j];
//                 }
                
//                 if( heights[j] > heights[i] )
//                     break;
//             }
//         }
//         return ans;
//     }
// }
