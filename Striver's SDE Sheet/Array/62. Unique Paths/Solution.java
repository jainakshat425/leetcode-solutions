class Solution {
    public int uniquePaths(int m, int n) {
        // No. of steps required in downward direction and right direction respectively.
        int downSteps = (m-1);
        int rightSteps = (n-1);
        
        // Total no. of steps required to reach from top-left corner (0,0) to bottom-right corner (m-1,n-1)
        int steps = downSteps + rightSteps;
        
        // Find the total number of ways to complete steps {steps} using {m-1} down steps or (n-1) right steps
        int min = Math.min(downSteps, rightSteps);
        
        /* 
           steps               steps!   
                C     =  ---------------------      
                 min      min! * (steps-min)!
        */
        
        double paths = 1;
        
        for(int i=min; i>0; i--) {
            paths *= ((double)steps / i);
            steps--;
        }
        
        return (int)Math.round(paths);
    }
}
