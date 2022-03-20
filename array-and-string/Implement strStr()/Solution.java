class Solution {
    public int strStr(String haystack, String needle) {
        /* 
        1. Use KMP Algorithm to solve this.
        2. Best Explanation - https://www.youtube.com/watch?v=4jY57Ehc14Y&ab_channel=LogicFirst
        3. Declare - 
            - {i} and {j} - Pointer to current element of text {haystack} and pattern {needle}
            - {m} and {n} - length of {haystack} and {needle}
            - {lps} array - To store the Longest Prefix Suffix. At each index, it stores the longest                                prefix length which is equal to suffix.
        4. Compute LPS
            - Declare 
                - {i} - Pointer to current element of pattern {pat}, initialized to 1.
                - {len} - Pointer to and length of current prefix. initialzied to 0.
            - Set LPS for first character as 0.
            - Loop from 1 {i} to pattern's length {n}
                - if suffix {pat[i]} and prefix {pat[len]} matches
                    - increment {len} and store it in {lps[i]}.
                    - increment {i}
                - else, 
                    - if {len} is not equal to 0
                        - copy {lps[len-1]} to {len}
                    - else assign 0 to {lps[i]} and increment {i}
        5. Loop from 0 {i} to text's length {m} 
            - If current character of text matches with current character of pattern
                - if complete pattern matches, return start index of matched pattern.
                - increment i and j by 1.
            - else (character doesn't match)
                - instead of backtracking to the start of the pattern, backtrack using lps array to the point {lps[j-1]} if {j} is not 0, else increment {i}.
                
        */
        if( needle.length() == 0 ) {
            return 0;
        }

        // Pointer to current element of text {haystack} and pattern {needle}
        int i=0, j=0;
        // length of {haystack} and {needle}
        int m = haystack.length(), n = needle.length();
        // To store the Longest Prefix Suffix. At each index, it stores the longest                                prefix length which is equal to suffix.
        int[] lps = new int[n];
        
        computeLPS(lps, needle, n);
        
        // Loop from 0 {i} to text's length {m} 
        while( i < m ) {
            
            // If current character of text matches with current character of pattern
            if( haystack.charAt(i) == needle.charAt(j) ) {
                
                // if complete pattern matches, return start index of matched pattern.
                if( j == (n-1) ) {
                    return (i-j);
                }
                
                // increment i and j by 1.
                i++;
                j++;
            } else {
                
                // instead of backtracking to the start of the pattern, backtrack using lps array to the point {lps[j-1]} if {j} is not 0, else increment {i}.
                if( j != 0 ) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
    
    private void computeLPS(int[] lps, String pat, int n) {
        
        // {i} - Pointer to current element of pattern {pat}, initialized to 1.
        // {len} - Pointer to and length of current prefix. initialzied to 0.
        int i = 1, len = 0;
        
        // Set LPS for first character as 0.
        lps[0] = 0;
        
        // Loop from 1 {i} to pattern's length {n}
        while( i < n ) {
            
            // if suffix {pat[i]} and prefix {pat[len]} matches
            if( pat.charAt(len) == pat.charAt(i) ) {
                
                // increment {len} and store it in {lps[i]}.
                len++;
                lps[i] = len;
                i++;
            } else {
                
                // if {len} is not equal to 0
                if( len != 0 ) {
                    
                    // copy {lps[len-1]} to {len}
                    len = lps[len-1]; 
                } else {
                    
                    // else assign 0 to {lps[i]} and increment {i}
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
