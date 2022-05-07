class Solution {
    public String countAndSay(int n) {
        // Since n will be atleast 1, start from 1
        Queue<Integer> queue = new LinkedList();
        queue.offer( 1 );
        
        // Repeat for 2 to n
        for(int i=2; i<=n; i++) {
            
            int size = queue.size();
            // Get the 1st number and set its count to 1
            int prev = queue.poll();
            int count = 1;
            
            // Repeat for all the numbers in queue till (size) only
            for(int j=1; j<size; j++) {
                int curr = queue.poll();
                
                // If current number matches previous one, increase count 
                if( curr == prev ) {
                    count++;
                } else {
                    // Else add the count and previous number to the queue
                    queue.offer( count );
                    queue.offer( prev );
                    
                    // Reset count and set previous number to the new number
                    count = 1;
                    prev = curr;
                }
            }
            
            // Add count of last sequence and the number
            queue.offer( count );
            queue.offer( prev );
        }
        
        // Append all the numbers from queue and return the string
        StringBuilder sb = new StringBuilder();
        while( !queue.isEmpty() ) {
            sb.append( queue.poll() + "" );
        }
        return sb.toString();
    }
}
