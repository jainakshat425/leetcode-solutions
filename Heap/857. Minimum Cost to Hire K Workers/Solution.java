class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        /* 
        offer[i]      quality[i]
        --------   =  ---------
        offer[j]      quality[j]
        
        offer[i] >= wage[i]
        
        one of the worker must be paid exactly the expected wage to
        form the paid group with least amount of money
        
        Let the worker being paid exactly the expected wage is the
        captain. Then we've to find the amount for every paid group 
        for each worker being the captain. min of all the paid groups 
        will be the answer
        
        To find the offer for ith worker
        
                      wage[captain] * quality[i]
        offer[i]   =  --------------
                      quality[captain]
        offer[i] = ratio[captain] * quality[i]
        
        
        First Optimization
        ---------------
        offer[i] will be accepted only when
        offer[i] >= wage[i]
        
        ratio[captain] * quality[i] >= wage[i]
        ratio[captain] >= wage[i] / quality[i]
        ratio[captain] >= ratio[i]
        
        Second Optimization
        --------------
        offer[i] = capRatio * quality[i]
        
        offer[0] + offer[1] + ... + offer[k]
        capRatio * quality[0] + capRatio * quality[1] + ... + capRatio * quality[k]
        capRatio * ( q[0] + q[1] + ... + q[k] )
        
        Minimize quality
        */
        
        int n = quality.length;
        Pair<Double,Integer>[] worker = new Pair[n];
        double minCost = Double.MAX_VALUE, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int i=0; i<n; i++) 
            worker[i] = new Pair((double)wage[i] / quality[i], quality[i]);
        
        Arrays.sort(worker, (a,b) -> Double.compare(a.getKey(), b.getKey()));
        
        for(Pair<Double,Integer> pair : worker) {
            double r = pair.getKey();
            int q = pair.getValue();
            
            pq.offer( q );
            sum += q;
            
            if( pq.size() > k )
                sum -= pq.poll();
            
            if( pq.size() == k ) 
                minCost = Math.min(minCost, r * sum);
        }
        return minCost;
    }
}
