class Solution {
    
    private static final int MAX = 1000000007;
    
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        Stack<Integer> stack = new Stack(){{ push(-1); }};
        
        for(int i=0; i<=n; i++) {
            while( stack.size() > 1 && (i == n || arr[stack.peek()] > arr[i])) {
                int min = stack.pop(); 
                int nextSmall = i; // Index of next smaller value for value at min index
                int prevSmall = stack.peek(); // Index of prev smaller value for value at min index
                
                ans = (ans + (long)arr[min] * (nextSmall-min) * (min-prevSmall)) % MAX;
            }
            if( i < n ) stack.push(i);
        }            
        return (int)ans;
    }
}
// class Solution {
    
//     private static final int MAX = 1000000007;
    
//     public int sumSubarrayMins(int[] arr) {
//         int n = arr.length;
//         // next lesser and previous lesser index 
//         int[] next = new int[n], prev = new int[n];
//         long ans = 0;
//         Stack<Integer> nextStack = new Stack();
//         Stack<Integer> prevStack = new Stack();
        
//         for(int i=0; i<n; i++) {
//             while( !nextStack.isEmpty() && arr[nextStack.peek()] >= arr[i])
//                 next[nextStack.pop()] = i;
//             nextStack.push(i);
            
//             int j = n-i-1;
//             while( !prevStack.isEmpty() && arr[prevStack.peek()] > arr[j])
//                 prev[prevStack.pop()] = j;
//             prevStack.push(j);
//         }
//         while( !nextStack.isEmpty() )
//             next[nextStack.pop()] = n;
        
//         while( !prevStack.isEmpty() )
//             prev[prevStack.pop()] = -1;
        
//         for(int i=0; i<n; i++) 
//             ans = (ans + (long)arr[i] * (next[i]-i) * (i-prev[i])) % MAX;
        
//         return (int)ans;
//     }
// }
