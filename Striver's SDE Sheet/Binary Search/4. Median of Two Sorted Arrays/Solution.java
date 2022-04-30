class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // To apply binary search to the smaller array, swap num1 if it's not the smaller one
        if( nums1.length > nums2.length ) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int low = 0, high = n1;
        
        while( low <= high ) {
            
            int cut1 = low + (high-low)/2;
            
            int cut2 = (( n1 + n2 + 1) / 2) - cut1;
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if( left1 <= right2 && left2 <= right1 ) {
                
                if( (n1 + n2) % 2 == 0 ) {
                    
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2;
                    
                } else {
                    
                    return Math.max(left1, left2);
                }
            } else if( left1 > right2 ) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        
        return -1;
    }
}
/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        boolean isOdd = (nums1.length + nums2.length)%2 != 0;
        int mid = (nums1.length + nums2.length)/2;
        
        if( nums1.length == 0 ) {
            return isOdd ? nums2[mid] : (double)(nums2[mid-1]+nums2[mid])/2 ;    
        }
        if( nums2.length == 0 ) {
            return isOdd ? nums1[mid] : (double)(nums1[mid-1]+nums1[mid])/2 ;    
        }
        
        
        int i=0, j=0, k=0;
        int curr = 0, prev = 0;
        
        while( k <= mid  ) {
            prev = curr;
            
            if( i < nums1.length && j < nums2.length ) {
                if( nums1[i] < nums2[j] ) {
                    curr = nums1[i];
                    i++;
                } else {
                    curr = nums2[j];
                    j++;
                }
            } else if( i < nums1.length ) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
            
            k++;
        }
        
        return isOdd ? curr : (double)(prev+curr)/2;
    }
}*/
