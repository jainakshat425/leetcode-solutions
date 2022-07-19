class Solution {
    public int minimumJumps(int[] forbid, int a, int b, int x) {
        Set<Integer> forbidden = arrToSet(forbid);
        int max = a >= b ? x : 5000;
        // 0 > visited in forward direction, 1 > visited in backward direction
        Map<Integer,boolean[]> visited = new HashMap();
        int jumps = 0;
        // 0 > position on the x-axis, 1 -> is previous jump a back jump?
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0});
        visited.put(0, new boolean[]{ true, true });
        
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            
            while( size-- > 0 ) {
                int pos = queue.peek()[0];
                boolean isBackJump = queue.peek()[1] == 1;
                queue.poll();

                if( pos == x ) 
                    return jumps;
                     
                int forward = pos + a;
                visited.putIfAbsent(forward, new boolean[2]);
                boolean[] forwardVisit = visited.get(forward);
                // Move forward
                if( pos < max && !forbidden.contains(forward) && !forwardVisit[0] ) {
                    queue.offer(new int[]{forward, 0});
                    forwardVisit[0] = true;
                }
            
                int backward = pos - b;
                visited.putIfAbsent(backward, new boolean[2]);
                boolean[] backwardVisit = visited.get(backward);
                // Move backward
                if( backward > 0 && !isBackJump && !forbidden.contains(backward) 
                   && !backwardVisit[1] ) {
                    queue.offer(new int[]{backward, 1});
                    backwardVisit[1] = true;
                }
            }
            jumps++;
        }
        return -1;
    }
    
    private HashSet<Integer> arrToSet(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for(int item : arr)
            set.add(item);
        return set;
    }
}
