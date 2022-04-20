class Solution {
    public int minCostClimbingStairs(int[] cost) {

        // Total steps
        int n = cost.length;
        
        // Cost to reach 2nd previous step of current step
        int secondPrev = cost[0];
        // Cost to reach previous step of currrent step
        int prev = cost[1];
        
        // Iterate from 3rd step till the last step
        for(int step=2; step<n; step++) {
            
            // Calculate cost till current step
            int curr = cost[step] + Math.min(secondPrev, prev);
            
            // Advance prev costs to the cost of the current steps.
            secondPrev = prev;
            prev = curr;
        }
        
        // Return minimum of the cost of the second last step vs the last step
        return Math.min(secondPrev, prev);
    }
}
