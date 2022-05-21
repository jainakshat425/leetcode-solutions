class Solution {
    /*
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];
        
        for(int ind=n-1; ind>=0; ind--) {
            
            for(int prevInd=ind-1; prevInd>=-1; prevInd--) {
                
                int notTake = next[prevInd+1];
                
                int take = 0;
                if( prevInd == -1 || nums[prevInd] < nums[ind] )
                    take = 1 + next[ind+1];

                curr[prevInd+1] = Math.max( take, notTake );
            }
            next = curr;
        }
        return next[0];  
    }*/
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        List<Integer> temp = new ArrayList();
        temp.add( nums[0] );
        
        for(int i=1; i<n; i++) {
            
            if( temp.get(temp.size()-1) < nums[i] ) 
                temp.add( nums[i] );
            else {
                int ind = binarySearch(temp, 0, temp.size()-1, nums[i]);
                temp.set(ind, nums[i]);
            }
        }
        
        return temp.size();
    }
    
    private int binarySearch(List<Integer> nums, int low, int high, int num) {
        if( low >= high ) return low;
        
        int mid = low + (high-low)/2;
        
        if( nums.get(mid) == num ) 
            return mid;
        else if( nums.get(mid) < num ) 
            return binarySearch(nums, mid+1, high, num);
        else
            return binarySearch(nums, low, mid, num);
    }
}
