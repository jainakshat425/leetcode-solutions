class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> queue = new PriorityQueue();
        int sum = 0;
        int i=0;
        for(; i<n-1; i++) {
            int jump = heights[i+1] - heights[i];
            
            if( jump <= 0 )
                continue;
            
            if( queue.size() < ladders )
                queue.offer( jump );
            else if( !queue.isEmpty() && jump > queue.peek() ) {
                sum += queue.poll();
                queue.offer(jump);
            } else
                sum += jump;
            
            if( sum > bricks )
                break;
        }
        return i;
    }
}
