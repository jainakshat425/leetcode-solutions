class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer,Integer> remainderInd = new HashMap();
        remainderInd.put(0, -1);
        
        for(int i=0; i<n; i++) {
            sum += nums[i];
            
            int r = sum % k;
            
            if( remainderInd.containsKey(r) ) {
                int ind = remainderInd.get(r);
                
                if( i - ind >= 2 )
                    return true;
            } else
                remainderInd.put(r, i);
        }
        return false;
    }
}
