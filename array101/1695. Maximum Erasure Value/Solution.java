class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> visited = new HashMap();
        int[] prefixSum = new int[n+1];
        int max = 0, left = 0;
        
        for(int right=0; right<n; right++) {
            int num = nums[right];
            prefixSum[right+1] = prefixSum[right] + num; 
            
            if( visited.containsKey( num ) ) 
                left = Math.max(left, visited.get( num ) + 1);
            
            int sum = prefixSum[right+1] - prefixSum[left];
            max = Math.max(max, sum);
            visited.put( num, right );
        }
        return max;
    }
}
/* 
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> visited = new HashMap();
        int sum = 0, max = 0, left = 0;
        
        for(int right=0; right<n; right++) {
            int num = nums[right];
            
            if( visited.containsKey( num ) ) {
                int index = visited.get( num );
                
                while( left <= index ) {
                    sum -= nums[left];
                    visited.remove( nums[left] );
                    left++;
                }
            } 
            sum += num;
            max = Math.max(max, sum);
            visited.put( num, right );
        }
        return max;
    }
}
*/
