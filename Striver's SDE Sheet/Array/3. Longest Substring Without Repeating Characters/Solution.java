class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Map to store the visited characters in the string with there last seen index.
        Map<Character,Integer> visited = new HashMap<Character,Integer>();
        
        // The maximum length of the string without any duplicate characters
        int max = 0;
        
        // Total no. of characters in the string
        int n = s.length();
        
        // Left and right pointer of the current substring (sliding window)
        int left=0, right=0;
        
        // Repeat while end of the substring is in the range of string's length
        while( right < n ) {
            
            // Get the character at the end of the current substring
            char curr = s.charAt( right );
            
            // If this character has already been visited
            if( visited.containsKey( curr ) ) {
                
                // Get the index when this character has been last seen
                int lastSeen = visited.get( curr );
                
                // If character has been last seen in the current substring
                if( lastSeen >= left ) {
                    
                    // Update the max, if current substring's length is greater than max
                    max = Math.max(max, right-left);
                    
                    // Move the left pointer after the last seen index, 
                    // so that duplicate character gets eliminated from current substring
                    left = lastSeen + 1;
                } 
            }
            
            // Put the character and it's index into the map, 
            // In case if the character already exist in the map 
            // it's index will get updated
            visited.put( curr, right );
            
            // Move the right pointer ahead
            right++;
        }
        
        // Calculating max again to handle case where longest substring is at the end of the array.
        return Math.max(max, right-left);
    }
}
