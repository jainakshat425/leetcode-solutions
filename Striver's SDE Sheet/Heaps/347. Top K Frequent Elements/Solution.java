class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numCount = new HashMap();
        
        for(int num : nums)
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        
        // stores int[2] (0 > number, 1 > count)
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[1]-b[1]);
        
        for(int num : numCount.keySet()) {
            int count = numCount.get(num);
            
            if( queue.size() < k )
                queue.offer(new int[] {num, count});
            else if(queue.peek()[1] < count) {
                queue.poll();
                queue.offer(new int[] {num, count});   
            }
        }
        
        int[] ans = new int[k];
        for(int i=0; i<k; i++) 
            ans[i] = queue.poll()[0];
        
        return ans;
    }
}
