class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue(k);
        
        for(int num : nums) {
            if( queue.size() < k ) 
                queue.offer( num );
            else if( queue.peek() < num ) {
                queue.poll();
                queue.offer( num );
            }
        }
        
        return queue.peek();
    }
}
