class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        
        while( l < r ) {
            if( s.charAt(l) != s.charAt(r) ) 
                return isPalindrome(l+1, r, s) || isPalindrome(l, r-1, s);
            l++;
            r--;
        }
        return true;
    }
    
    private boolean isPalindrome(int l, int r, String s) {
        while( l < r )
            if( s.charAt(l++) != s.charAt(r--) ) 
                return false;
        return true;
    }
}
