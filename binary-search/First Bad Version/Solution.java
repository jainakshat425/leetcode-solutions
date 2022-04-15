/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        /* 
        1. Declare start and end initialized with 0 and {n} respectively.
        2. Repeat while {start} < {end}
            - Find {mid}
            - if {mid} is a bad version, search in left half for the first bad version.
            - else search in right half for a bad version. 
        */
        // Declare start and end initialized with 0 and {n} respectively.
        int start = 1, end = n;
        
        // Repeat while {start} < {end}
        while(start < end) {
            
            // Find {mid}
            int mid = start + (end-start)/2;
            
            // if {mid} is a bad version
            if( isBadVersion( mid ) ) {
                // search in left half for the first bad version.
                end = mid;
            } else {
                // else search in right half for a bad version. 
                start = mid+1;
            }
        }
        return start;
    }
}
