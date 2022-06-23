class Solution {
    public int leastInterval(char[] tasks, int n) {
        if( n == 0 )
            return tasks.length;
        
        int[] count = new int[26];
        
        for(char c : tasks) 
            count[c - 'A'] += 1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        // 0 > Count, 1 > Idle Time
        Queue<int[]> queue = new LinkedList();
        
        for(int cnt : count)
            if( cnt > 0 )
                maxHeap.offer( cnt );
        
        int time = 0;
        
        while( !maxHeap.isEmpty() || !queue.isEmpty() ) {
            
            time++;
            
            if( !maxHeap.isEmpty() ) {
                int cnt = maxHeap.poll();
                
                if( cnt != 1 ) 
                    queue.offer(new int[]{ cnt-1, time+n });
                
            }  -
            if( !queue.isEmpty() && queue.peek()[1] <= time )
                maxHeap.offer( queue.poll()[0] );
        }
        return time;
    }
}
