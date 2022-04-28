class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        partition(s, 0,  new ArrayList<>(), result);
        
        return result;
    }
    
    private void partition(String str, int start, List<String> partitions, List<List<String>> result) {
        /* Reached till the end of the string and all the partitions
        in this path were palindrome, then add the partitions to the
        result */
        if( start == str.length() ) {
            result.add( new ArrayList<>(partitions) );
            return;
        }
        
        for(int i=start; i<str.length(); i++) {
        
            // Check if current substring is a palindrome
            boolean isPalindrome = isPalindrome( str, start, i );
            
            if( isPalindrome ) {
                /* Add it to the partitions and check for remaining
                part of the string, if it can form palindrome partitions */
                partitions.add( str.substring( start, i+1 ) );
                
                partition(str, i+1, partitions, result);
                
                // Remove the current substring to restore the original list
                partitions.remove( partitions.size() - 1 );
            }
        }
    }
    
    private boolean isPalindrome(String str, int left, int right) {        
        while( left < right ) {
            
            if( str.charAt(left) != str.charAt(right) ) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
