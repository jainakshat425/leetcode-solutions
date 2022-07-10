class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[] ans = new int[]{-100000, 100000};
        /* 
        0th -> index of list in nums
        1st -> index of the number in list
        2nd -> current number
        */
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[2], b[2]));
        int max = Integer.MIN_VALUE;
        
        for(int listInd=0; listInd<n; listInd++) {
            int num = nums.get(listInd).get(0);
            int[] triplet = new int[]{listInd, 0, num};
            queue.offer(triplet);
            max = Math.max(max, num);
        }
        
        while( true ) {
            int listInd = queue.peek()[0];
            int numInd = queue.peek()[1];
            int num = queue.peek()[2];
            queue.poll();
            
            if( max-num < ans[1]-ans[0] ) {
                ans[0] = num;
                ans[1] = max;
            }
            numInd++;
            
            if( numInd == nums.get(listInd).size() )
                break;
            
            int nextNum = nums.get(listInd).get(numInd);
            int[] triplet = new int[]{listInd, numInd, nextNum};
            queue.offer(triplet);
            max = Math.max(max, nextNum);
        }
        return ans;
    }
}
