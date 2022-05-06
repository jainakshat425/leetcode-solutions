class Solution {
    public String removeDuplicates(String s, int k) {
        
        int n = s.length();
        int count = 0; // previous character consecutive count 
        char prev = '\0';
        StringBuilder ans = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            
            char curr = s.charAt(i);
                        
            // Increase count if current and previous characters are same
            if( prev == curr ) {
                count++;
            } else {
                // New character found, update previous and set count to 1
                count = 1;
                prev = curr;
            }
            
            // If k duplicates found
            if( count == k ) {
                // delete last k-1 characters, as current character has not been appended yet
                deleteLastN(ans, k-1);
                
                // Find the previous character and it's count
                count = 0;
                
                int lastIdx = ans.length() - 1;
                
                if( lastIdx >= 0 ) {
                    prev = ans.charAt( lastIdx );
                    
                    for(int j=lastIdx; j>=0; j--) {
                        if( ans.charAt(j) != prev ) break;
                        count++;
                    }
                }  else {
                    prev = '\0';
                }
                
            } else {
                ans.append( curr );
            }
        }
        
        return ans.toString();
    }
    
    private void deleteLastN(StringBuilder str, int n) {
        int length = str.length();
        int start = length - n;
        for(int j=length-1; j>=start; j--) {
            str.deleteCharAt( j );
        }
    }
}
