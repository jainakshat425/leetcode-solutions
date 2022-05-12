class KthLargest {
    private Queue<Integer> pQueue;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.pQueue = new PriorityQueue<Integer>(k);
        this.k = k;
        
        for(int val : nums) {
            add( val );
        }
    }
    
    public int add(int val) {
        // If the queue contains less than k numbers, add current number
        if( pQueue.size() < k ) 
            pQueue.offer( val ); 
        // Remove the minimum number and add the current number if it's greater than minimum
        else if( pQueue.peek() < val ) {
            pQueue.poll();
            pQueue.offer( val ); 
        }
        
        return pQueue.peek();
    }
}
