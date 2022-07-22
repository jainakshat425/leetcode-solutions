class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int ans = 0, satisfied = 0;
        
        // Satisfy all the customers when the shop keeper was not grumpy
        for(int i=0; i<n; i++)
            if( grumpy[i] == 0 )
                satisfied += customers[i];
        
        for(int i=0; i<n; i++) {
            // Satisfy customers iff shopkeeper is grumpy
            satisfied += grumpy[i] * customers[i];
            
            // exclude customers left to the minutes size window 
            // (only the one when shopkeeper was grumpy)
            if( i >= minutes ) 
                satisfied -= grumpy[i-minutes] * customers[i-minutes];
            
            ans = Math.max(ans, satisfied);
        }
        return ans;
    }
}
