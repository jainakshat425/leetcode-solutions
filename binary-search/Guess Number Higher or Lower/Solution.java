/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        /* 
        1. Binary Search Approach
        2. Initialize {start} with 1 and {end} with the range {n}
        3. Repeat while {start} < {end}
            - Find {mid}. To overcome integer overflow use formula {start+(end-start)/2} to calculate mid.
            - If {mid} is the number, return {mid}.
            - else if {mid} < number (determined by {ans} == -1), search in the left portion.
            - else if {mid} > number (determined by {ans} == 1), search in the right portion.
        */
        // Initialize {start} with 1 and {end} with the range {n}
        int start = 1, end = n;
        int mid, ans;
        
        // Repeat while {start} < {end}
        while(start <= end) {
            // Find {mid}. 
            // To overcome integer overflow use formula {start+(end-start)/2} to calculate mid.
            mid = start+(end-start)/2;
            
            ans = guess(mid);
            
            // If {mid} is the number, return {mid}.
            if( ans == 0 ) {
                return mid;
            } else if( ans == -1 ) {
                // else if {mid} < number (determined by {ans} == -1), search in the left portion.
                end = mid-1;
            } else {
                // else if {mid} > number (determined by {ans} == 1), search in the right portion.
                start = mid+1;
            }
        }
        
        return -1;
    }
}
