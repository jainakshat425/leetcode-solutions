class Solution {
    public int majorityElement(int[] nums) {
        
        int ele = 0, count = 0, n = nums.length;
        
        for(int i=0; i<n; i++) {
            
            if( count == 0 ) {
                ele = nums[i];
                count = 1;
            } else if( ele == nums[i] ) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
}
