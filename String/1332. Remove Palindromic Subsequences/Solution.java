
class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        return isPalindrome(0, n-1, s) ? 1 : 2;
    }

	private boolean isPalindrome(int start, int end, String str) {
		while( start < end ) {
			if( str.charAt(start) != str.charAt(end) )
				return false;
            start++;
            end--;
		}
		return true;
	}
}
