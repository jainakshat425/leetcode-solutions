class Solution {
    public int mctFromLeafValues(int[] arr) {
        int ans = 0;
        Stack<Integer> stack = new Stack();
        
        stack.push(Integer.MAX_VALUE);
                
        for(int num : arr) {
           
            while( stack.peek() <= num ) {
                int mid = stack.pop();
                ans += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        while( stack.size() > 2 )
            ans += stack.pop() * stack.peek();
        
        return ans;
    }
}
// class Solution {
//     public int mctFromLeafValues(int[] arr) {
//         int ans = 0;
//         List<Integer> nums = new ArrayList();
        
//         for(int num : arr) nums.add(num);
        
//         while( nums.size() > 1 ) {
//             int i = minIndex(nums);
            
//             int left = i > 0 ? nums.get(i-1) : Integer.MAX_VALUE;
//             int right = i < nums.size()-1 ? nums.get(i+1) : Integer.MAX_VALUE;
            
//             ans += nums.get(i) * Math.min(left,right);
//             nums.remove(i);
//         }
//         return ans;
//     }
    
//     private int minIndex(List<Integer> nums) {
//         int min = 0;
//         for(int i=1; i<nums.size(); i++) 
//             if( nums.get(i) < nums.get(min) )
//                 min = i;
//         return min;
//     }
// }
