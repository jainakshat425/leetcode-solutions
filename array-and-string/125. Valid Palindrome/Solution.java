class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if( !isAlphaNumeric(leftChar) ) 
                left++;

            else if( !isAlphaNumeric(rightChar) )
                right--;
            
            else if( Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar) )
                return false;
            
            else {
                left++;
                right--;
            }
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') ||
            (c >= 'a' && c <= 'z') || 
            (c >= '0' && c <= '9');
    }
}
/* 
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        String str = s.toLowerCase();
        int left = 0, right = n-1;
        
        while(left < right) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);
            
            if( !isAlphaNumeric(leftChar) ) 
                left++;

            else if( !isAlphaNumeric(rightChar) )
                right--;
            
            else if( leftChar != rightChar )
                return false;
            
            else {
                left++;
                right--;
            }
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
*/
