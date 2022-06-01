class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    
    public MedianFinder() {
        // Max Heap, returns maximum element in O(1) time
        small = new PriorityQueue<Integer>((a, b) -> (b - a));
        // Min Heap, returns minimum element in O(1) time
        large = new PriorityQueue();
    }
    
    public void addNum(int num) {        
        if( large.size() > small.size() ) {
            if( num > large.peek() ) {
                small.offer( large.poll() );
                large.offer( num );
            } else
                small.offer( num );
        } else {
            if( !small.isEmpty() && num < small.peek() ) {
                large.offer( small.poll() );
                small.offer( num );
            } else
                large.offer( num );
        }
    }
    
    public double findMedian() {        
        if( large.size() > small.size() ) 
            return large.peek();
        else 
            return (long)(large.peek() + small.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
