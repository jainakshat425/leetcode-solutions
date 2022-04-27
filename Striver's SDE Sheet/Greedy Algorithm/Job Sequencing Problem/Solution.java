class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sort the jobs in the increasing order of profit
        Arrays.sort( arr, (j1, j2) -> j2.profit - j1.profit );
        
        // Maximum deadline of all the jobs
        int maxDeadline = 0;
        
        for(Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        // Array to allocate jobs, stores profit from each job
        int[] profitArr = new int[maxDeadline+1];
         
        /* Array to hold result
        0th index - No. of jobs done
        1st index - Maximum Profit */
        int[] result = new int[2];
        
        for(Job job : arr) {
            
            /* Try to allocate the job at the deadline itself, if 
            at the deadline some job is already present, try to 
            schedule it anytime before the deadline */
            int deadline = job.deadline;
            
            while( deadline != 0 && profitArr[deadline] != 0 ) {
                deadline--;
            } 
            
            /* Higher profit jobs are already present till the 
            deadline of the current job, hence discard current job */
            if( deadline == 0 ) {
                continue;
            }
            
            profitArr[deadline] = job.profit;
            // increase count of No. of jobs done
            result[0]++;
            // Add profit due to current job
            result[1] += job.profit;
        }
        
        return result;
    }
}

