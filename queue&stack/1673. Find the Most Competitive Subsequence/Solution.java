class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int pos = -1;
        
        for(int i=0; i<n; i++) {
            
            while( pos != -1 && stack[pos] > nums[i] && (pos + n - i) >= k )
                pos--;
            
            if( pos+1 < k )
                stack[++pos] = nums[i];
        }
        return stack;
    }
}
// class Solution {
//     public int[] mostCompetitive(int[] nums, int k) {
//         int n = nums.length;
//         int[] ans = new int[k];
//         Stack<Integer> stack = new Stack();
        
//         for(int i=0; i<n; i++) {
//             int remaining = n-i;
            
//             while( !stack.isEmpty() && stack.peek() > nums[i] &&
//                   (stack.size() + remaining - 1) >= k )
//                 stack.pop();
            
//             if( stack.size() < k )
//                 stack.push(nums[i]);
//         }
        
//         for(int i=k-1; i>=0; i--)
//             ans[i] = stack.pop();
        
//         return ans;
//     }
// }
// class Solution {
//     public int[] mostCompetitive(int[] nums, int k) {
//         int n = nums.length;
//         int[] ans = new int[k];
//         PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
//             (a,b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
//         );
        
//         for(int i=0; i<=n-k; i++)
//             pq.offer(new int[]{ i, nums[i] });
        
//         for(int i=0; i<k; i++) {
//             int minInd = pq.peek()[0];
//             ans[i] = pq.peek()[1];
//             pq.poll();
            
//             while( !pq.isEmpty() && pq.peek()[0] < minInd )
//                 pq.poll();
            
//             int nextInd = n - k + 1 + i;
//             if( nextInd < n )
//                 pq.offer(new int[]{ nextInd, nums[nextInd] });
//         }
//         return ans;
//     }
// }
