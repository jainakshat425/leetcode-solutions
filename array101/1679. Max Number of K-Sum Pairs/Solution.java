class Solution {
    public int maxOperations(int[] nums, int k) {
        // Stores numbers from nums with there frequency
        Map<Integer,Integer> frequency = new HashMap<>();
        
        int count = 0;
        
        for(int num : nums) {
            
            // The required number to get the sum {k}
            int diff = k - num;
            
            // Number of times required number appeared before
            int diffFreq = frequency.getOrDefault( diff, 0 );
            
            // If required number appeared
            if( diffFreq > 0 ) {
                // Decrement it's count as it has been used one time now
                frequency.put( diff, diffFreq-1 );
                
                // Increment the count as pair is found
                count++;
            } else {
                // Check if number already exist in map
                int numFreq = frequency.getOrDefault( num, 0 );
                
                // Store the new frequency of current number
                frequency.put( num, numFreq+1 );   
            }
        }
        return count;
    }
}
